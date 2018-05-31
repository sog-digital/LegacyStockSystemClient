package com.sogeti.digital.lss.service;

public class PersonServiceImplProxy implements com.sogeti.digital.lss.service.PersonServiceImpl {
  private String _endpoint = null;
  private com.sogeti.digital.lss.service.PersonServiceImpl personServiceImpl = null;
  
  public PersonServiceImplProxy() {
    _initPersonServiceImplProxy();
  }
  
  public PersonServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonServiceImplProxy();
  }
  
  private void _initPersonServiceImplProxy() {
    try {
      personServiceImpl = (new com.sogeti.digital.lss.service.PersonServiceImplServiceLocator()).getPersonServiceImpl();
      if (personServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personServiceImpl != null)
      ((javax.xml.rpc.Stub)personServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sogeti.digital.lss.service.PersonServiceImpl getPersonServiceImpl() {
    if (personServiceImpl == null)
      _initPersonServiceImplProxy();
    return personServiceImpl;
  }
  
  public boolean update(com.sogeti.digital.lss.model.Person person) throws java.rmi.RemoteException{
    if (personServiceImpl == null)
      _initPersonServiceImplProxy();
    return personServiceImpl.update(person);
  }
  
  public com.sogeti.digital.lss.model.Person read(java.lang.String email) throws java.rmi.RemoteException{
    if (personServiceImpl == null)
      _initPersonServiceImplProxy();
    return personServiceImpl.read(email);
  }
  
  public boolean login(java.lang.String email, java.lang.String password) throws java.rmi.RemoteException{
    if (personServiceImpl == null)
      _initPersonServiceImplProxy();
    return personServiceImpl.login(email, password);
  }
  
  public boolean changePassword(com.sogeti.digital.lss.model.Person person) throws java.rmi.RemoteException{
    if (personServiceImpl == null)
      _initPersonServiceImplProxy();
    return personServiceImpl.changePassword(person);
  }
  
  
}