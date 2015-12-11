package fr.upem.bank;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import FaultContracts.GOTLServices._2008._01.DefaultFaultContract;
import net.restfulwebservices.www.DataContracts._2008._01.Currency;
import net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode;
import net.restfulwebservices.www.ServiceContracts._2008._01.CurrencyServiceLocator;
import net.restfulwebservices.www.ServiceContracts._2008._01.ICurrencyService;

/**
 * Bank Account class
 * @author davakov
 *
 */
public class Account {
	private final long id;
	private double balance; 
	private CurrencyCode currency;
	
	/**
	 * Account constructor
	 * @param id Unique id number
	 * @param balance Starting balance for the account 
	 * @param currency the account currency
	 */
	Account(long id, double balance, CurrencyCode currency){
		this.id = id;
		this.balance = balance;
		this.currency = currency;
	}
	
	/**
	 * Deposit money into the account
	 * @param amount Amount to deposit 
	 * @param currency Amount currency
	 * @throws IllegalArgumentException	if amount is wrong ( <= 0 )
	 * @throws ServiceException 
	 * @throws RemoteException
	 */
	public void deposit(double amount, CurrencyCode currency) throws IllegalArgumentException, ServiceException, RemoteException{
		if(amount <= 0) {
			throw new IllegalArgumentException("Wrong amount");	
		}
		
		if(this.currency == currency){
			balance += amount; 
		} else {
			ICurrencyService c = new CurrencyServiceLocator().getBasicHttpBinding_ICurrencyService();
			Currency x = c.getConversionRate(currency, this.currency);
			balance += amount*x.getRate();
		}
	}
	
	/**
	 * Withdraw money from the account
	 * @param amount Amount to deposit 
	 * @param currency Amount currency
	 * @throws IllegalArgumentException	if amount is wrong ( <= 0 )
	 * @throws IllegalStateException if there is not enough money in the account
	 * @throws ServiceException
	 * @throws DefaultFaultContract
	 * @throws RemoteException
	 */
	public void withdraw(double amount, CurrencyCode currency) throws IllegalArgumentException, IllegalStateException, ServiceException, DefaultFaultContract, RemoteException{
		if(amount <= 0) {
			throw new IllegalArgumentException("Wrong amount");
		}
		
		if(this.currency != currency){
			ICurrencyService c = new CurrencyServiceLocator().getBasicHttpBinding_ICurrencyService();
			Currency x = c.getConversionRate(currency, this.currency);
			amount = amount*x.getRate();
		}
		
		if(balance < amount) {
			throw new IllegalStateException("Not enough money");
		}
		balance -= amount;
	}
	
	/**
	 * Getter for the account balance 
	 * @return the account balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Getter for the account unique id
	 * @return the account unique id
	 */
	long getId(){
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Account)){
			return false;
		}
		
		Account a = (Account)obj;
				
		return this.id == a.id;
	}
}
