/**
 * ICurrencyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.restfulwebservices.www.ServiceContracts._2008._01;

public interface ICurrencyService extends java.rmi.Remote {
    public net.restfulwebservices.www.DataContracts._2008._01.Currency getConversionRate(net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode fromCurrency, net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode toCurrency) throws java.rmi.RemoteException, FaultContracts.GOTLServices._2008._01.DefaultFaultContract;
}
