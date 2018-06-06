package com.sogeti.digital.lss.service;

public class StockServiceImplProxy implements com.sogeti.digital.lss.service.StockServiceImpl {
  private String _endpoint = null;
  private com.sogeti.digital.lss.service.StockServiceImpl stockServiceImpl = null;
  
  public StockServiceImplProxy() {
    _initStockServiceImplProxy();
  }
  
  public StockServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initStockServiceImplProxy();
  }
  
  private void _initStockServiceImplProxy() {
    try {
      stockServiceImpl = (new com.sogeti.digital.lss.service.StockServiceImplServiceLocator()).getStockServiceImpl();
      if (stockServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)stockServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)stockServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (stockServiceImpl != null)
      ((javax.xml.rpc.Stub)stockServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sogeti.digital.lss.service.StockServiceImpl getStockServiceImpl() {
    if (stockServiceImpl == null)
      _initStockServiceImplProxy();
    return stockServiceImpl;
  }
  
  public boolean create(com.sogeti.digital.lss.model.Product product) throws java.rmi.RemoteException{
    if (stockServiceImpl == null)
      _initStockServiceImplProxy();
    return stockServiceImpl.create(product);
  }
  
  public com.sogeti.digital.lss.model.Product getStock(int id) throws java.rmi.RemoteException{
    if (stockServiceImpl == null)
      _initStockServiceImplProxy();
    return stockServiceImpl.getStock(id);
  }
  
  
}