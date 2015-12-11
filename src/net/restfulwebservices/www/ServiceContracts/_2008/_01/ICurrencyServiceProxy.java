package net.restfulwebservices.www.ServiceContracts._2008._01;

public class ICurrencyServiceProxy implements net.restfulwebservices.www.ServiceContracts._2008._01.ICurrencyService {
  private String _endpoint = null;
  private net.restfulwebservices.www.ServiceContracts._2008._01.ICurrencyService iCurrencyService = null;
  
  public ICurrencyServiceProxy() {
    _initICurrencyServiceProxy();
  }
  
  public ICurrencyServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initICurrencyServiceProxy();
  }
  
  private void _initICurrencyServiceProxy() {
    try {
      iCurrencyService = (new net.restfulwebservices.www.ServiceContracts._2008._01.CurrencyServiceLocator()).getBasicHttpBinding_ICurrencyService();
      if (iCurrencyService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iCurrencyService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iCurrencyService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iCurrencyService != null)
      ((javax.xml.rpc.Stub)iCurrencyService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.restfulwebservices.www.ServiceContracts._2008._01.ICurrencyService getICurrencyService() {
    if (iCurrencyService == null)
      _initICurrencyServiceProxy();
    return iCurrencyService;
  }
  
  public net.restfulwebservices.www.DataContracts._2008._01.Currency getConversionRate(net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode fromCurrency, net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode toCurrency) throws java.rmi.RemoteException, FaultContracts.GOTLServices._2008._01.DefaultFaultContract{
    if (iCurrencyService == null)
      _initICurrencyServiceProxy();
    return iCurrencyService.getConversionRate(fromCurrency, toCurrency);
  }
  
  
}