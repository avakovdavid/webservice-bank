package fr.upem.bank;

import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.rpc.ServiceException;

import net.restfulwebservices.www.DataContracts._2008._01.Currency;
import net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode;
import net.restfulwebservices.www.ServiceContracts._2008._01.CurrencyServiceLocator;
import net.restfulwebservices.www.ServiceContracts._2008._01.ICurrencyService;

/**
 * Bank class 
 * @author davakov
 *
 */
public class Bank {
	
	private final String name = "BNP-MLV-Bank";
	private final ArrayList<Account> accounts = new ArrayList<>();
	private final Object lock = new Object();
	
	/**
	 * Sort of factory method to create (add) new account to the bank
	 * @param id Unique id number
	 * @param balance Starting balance for the account 
	 * @param currency the account currency
	 * @throws IllegalArgumentException if this account id already exists or the balance value is wrong 
	 * @throws ServiceException
	 */
	public void createNewAccount(long id, double balance, String strCurrency) throws IllegalArgumentException, ServiceException{
		boolean exist = false;
		
		synchronized(lock){
			for (Account account : accounts) {
				if(account.getId() == id){
					exist = true;
					break;
				}
			}
		}
		
		if(exist){
			throw new IllegalArgumentException("This account already exists");
		}
		
		if(balance <= 0){
			throw new IllegalArgumentException("Wrong balance value");
		}
		
		CurrencyCode currency;
		
		try{
			currency = CurrencyCode.fromString(strCurrency);
		} catch (IllegalArgumentException e){
			throw new IllegalArgumentException("Wrong currency");
		}
		
		Account a = new Account(id, balance, currency);
		
		synchronized(lock){
			accounts.add(a);
		}
	}
	
	/**
	 * Do a transaction from one account to another
	 * @param aFrom The account number to debit 
	 * @param aTo The account number to credit
	 * @param amount Amount to transfer
	 * @param strCurrency The transaction currency
	 * @throws IllegalArgumentException if this account id already exists or the amount value is wrong 
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws ServiceException
	 */
	public void transaction(long aFrom, long aTo, double amount, String strCurrency) throws IllegalArgumentException, IllegalStateException, RemoteException, ServiceException{		
		int from=-1,to=-1;
		boolean existFrom = false;
		boolean existTo = false;
		
		synchronized(lock){
			for(int i = 0; i<accounts.size(); i++){			
				if(accounts.get(i).getId() == aFrom){
					from = i;
					existFrom = true;
				}
				if(accounts.get(i).getId() == aTo){
					to = i;
					existTo = true;
				}			
			}
		}
								
		if(!existFrom){
			throw new IllegalArgumentException("Account " + aFrom + " not found in " + name);
		}
		
		if(!existTo){
			throw new IllegalArgumentException("Account " + aTo + " not found in " + name);
		}
						
		if(amount <= 0){
			throw new IllegalArgumentException("Wrong amount value");
		}
		
		CurrencyCode currency;
		
		try{
			currency = CurrencyCode.fromString(strCurrency);
		} catch (IllegalArgumentException e){
			throw new IllegalArgumentException("Wrong currency");
		}
		
		synchronized(lock){
			try{
				accounts.get(from).withdraw(amount, currency);
				accounts.get(to).deposit(amount, currency);
			} catch(IllegalArgumentException | IllegalStateException e){
				throw new IllegalStateException("The transaction failed. Make sure you have enough money");
			}
		}
	}

	/**
	 * Getter for the account balance
	 * @param id Account unique id 
	 * @return the account balance
	 * @throws IllegalArgumentException if this account id was not found
	 */
	public double getBalance(long id) throws IllegalArgumentException{
		boolean exist = false;
		double balance = 0.0;
		
		synchronized(lock){
			for (Account account : accounts) {
				if(account.getId() == id){
					balance = account.getBalance();
					exist = true;
					break;
				}
			}
		}
		
		if(!exist){
			throw new IllegalArgumentException("Account " + id + " not found in " + name);
		}
						
		return balance;
	}

	/**
	 * Deposit money in the account
	 * @param id Account unique id
	 * @param amount Amount to deposit  
	 * @param strCurrency Amount currency
	 * @throws IllegalArgumentException if this account id was not found or the amount value is wrong 
	 * @throws RemoteException
	 * @throws ServiceException
	 */
	public void deposit(long id, double amount, String strCurrency) throws IllegalArgumentException, RemoteException, ServiceException{
		int index = -1;
		boolean exist = false;
		
		synchronized(lock){
			for(int i = 0; i<accounts.size(); i++){			
				if(accounts.get(i).getId() == id){
					index = i;
					exist = true;
				}
			}
		}
		
		if(!exist){
			throw new IllegalArgumentException("Account " + id + " not found in " + name);
		}
				
		if(amount <= 0) {
			throw new IllegalArgumentException("Wrong amount");	
		}
		
		CurrencyCode currency;
		
		try{
			currency = CurrencyCode.fromString(strCurrency);
		} catch (IllegalArgumentException e){
			throw new IllegalArgumentException("Wrong currency");
		}
		
		synchronized(lock){
			accounts.get(index).deposit(amount, currency);
		}
	}
	
	/**
	 * Withdraw money from the account
	 * @param id Account unique id
	 * @param amount Amount to withdraw
	 * @param strCurrency Amount currency
	 * @throws IllegalArgumentException if amount is wrong ( <= 0 ) or this account id was not found
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws ServiceException
	 */
	public void withdraw(long id, double amount, String strCurrency) throws IllegalArgumentException, IllegalStateException, RemoteException, ServiceException{
		int index = -1;
		boolean exist = false;
		
		synchronized(lock){
			for(int i = 0; i<accounts.size(); i++){			
				if(accounts.get(i).getId() == id){
					index = i;
					exist = true;
				}
			}
		}
		
		if(!exist){
			throw new IllegalArgumentException("Account " + id + " not found in " + name);
		}
		
		if(amount <= 0) {
			throw new IllegalArgumentException("Wrong amount");	
		}
		
		CurrencyCode currency;
		
		try{
			currency = CurrencyCode.fromString(strCurrency);
		} catch (IllegalArgumentException e){
			throw new IllegalArgumentException("Wrong currency");
		}
				
		synchronized(lock){
			accounts.get(index).withdraw(amount, currency);
		}
	}

	/**
	 * Getter for the bank name
	 * @return the bank name 
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Getter for the list of available currencies
	 * @return the list of available currencies 
	 */
	public String[] getCurrenciesList(){		
		Field [] fields = CurrencyCode.class.getFields();		
		ArrayList<String> array = new ArrayList<>();
		
		for(int i=0; i< fields.length; i++){
			
			if(!fields[i].getName().startsWith("_")){
				array.add(fields[i].getName());
			}
		}
		
		String [] result = new String[array.size()];
		array.toArray(result);
		Arrays.sort(result);
		return result;
	}
	
	/**
	 * Convert an amount from one currency to another 
	 * @param amount Amount to convert
	 * @param strCfrom Amount currency
	 * @param strCto Result currency
	 * @return Result amount
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public double convert(double amount, String strCfrom, String strCto) throws ServiceException, RemoteException{
		if(amount <= 0) {
			throw new IllegalArgumentException("Wrong amount");	
		}
		
		CurrencyCode cFrom;
		CurrencyCode cTo;
		
		try{
			cFrom = CurrencyCode.fromString(strCfrom);
			cTo = CurrencyCode.fromString(strCto);
		} catch (IllegalArgumentException e){
			throw new IllegalArgumentException("Wrong currency");
		}
		
		ICurrencyService c = new CurrencyServiceLocator().getBasicHttpBinding_ICurrencyService();
		Currency x = c.getConversionRate(cFrom, cTo);
		return amount*x.getRate();
	}
}
