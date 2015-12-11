/**
 * CurrencyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.restfulwebservices.www.ServiceContracts._2008._01;

public class CurrencyServiceLocator extends org.apache.axis.client.Service implements net.restfulwebservices.www.ServiceContracts._2008._01.CurrencyService {

    public CurrencyServiceLocator() {
    }


    public CurrencyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CurrencyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_ICurrencyService
    private java.lang.String BasicHttpBinding_ICurrencyService_address = "http://www.restfulwebservices.net/wcf/CurrencyService.svc";

    public java.lang.String getBasicHttpBinding_ICurrencyServiceAddress() {
        return BasicHttpBinding_ICurrencyService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_ICurrencyServiceWSDDServiceName = "BasicHttpBinding_ICurrencyService";

    public java.lang.String getBasicHttpBinding_ICurrencyServiceWSDDServiceName() {
        return BasicHttpBinding_ICurrencyServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_ICurrencyServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_ICurrencyServiceWSDDServiceName = name;
    }

    public net.restfulwebservices.www.ServiceContracts._2008._01.ICurrencyService getBasicHttpBinding_ICurrencyService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_ICurrencyService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_ICurrencyService(endpoint);
    }

    public net.restfulwebservices.www.ServiceContracts._2008._01.ICurrencyService getBasicHttpBinding_ICurrencyService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.restfulwebservices.www.ServiceContracts._2008._01.BasicHttpBinding_ICurrencyServiceStub _stub = new net.restfulwebservices.www.ServiceContracts._2008._01.BasicHttpBinding_ICurrencyServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_ICurrencyServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_ICurrencyServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_ICurrencyService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.restfulwebservices.www.ServiceContracts._2008._01.ICurrencyService.class.isAssignableFrom(serviceEndpointInterface)) {
                net.restfulwebservices.www.ServiceContracts._2008._01.BasicHttpBinding_ICurrencyServiceStub _stub = new net.restfulwebservices.www.ServiceContracts._2008._01.BasicHttpBinding_ICurrencyServiceStub(new java.net.URL(BasicHttpBinding_ICurrencyService_address), this);
                _stub.setPortName(getBasicHttpBinding_ICurrencyServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_ICurrencyService".equals(inputPortName)) {
            return getBasicHttpBinding_ICurrencyService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.restfulwebservices.net/ServiceContracts/2008/01", "CurrencyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.restfulwebservices.net/ServiceContracts/2008/01", "BasicHttpBinding_ICurrencyService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_ICurrencyService".equals(portName)) {
            setBasicHttpBinding_ICurrencyServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
