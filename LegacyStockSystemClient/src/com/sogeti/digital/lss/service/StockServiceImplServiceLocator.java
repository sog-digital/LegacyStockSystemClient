/**
 * StockServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sogeti.digital.lss.service;

public class StockServiceImplServiceLocator extends org.apache.axis.client.Service implements com.sogeti.digital.lss.service.StockServiceImplService {

    public StockServiceImplServiceLocator() {
    }


    public StockServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StockServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StockServiceImpl
    private java.lang.String StockServiceImpl_address = "http://localhost:8080/LegacyStockSystem/services/StockServiceImpl";

    public java.lang.String getStockServiceImplAddress() {
        return StockServiceImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StockServiceImplWSDDServiceName = "StockServiceImpl";

    public java.lang.String getStockServiceImplWSDDServiceName() {
        return StockServiceImplWSDDServiceName;
    }

    public void setStockServiceImplWSDDServiceName(java.lang.String name) {
        StockServiceImplWSDDServiceName = name;
    }

    public com.sogeti.digital.lss.service.StockServiceImpl getStockServiceImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StockServiceImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStockServiceImpl(endpoint);
    }

    public com.sogeti.digital.lss.service.StockServiceImpl getStockServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sogeti.digital.lss.service.StockServiceImplSoapBindingStub _stub = new com.sogeti.digital.lss.service.StockServiceImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getStockServiceImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStockServiceImplEndpointAddress(java.lang.String address) {
        StockServiceImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sogeti.digital.lss.service.StockServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sogeti.digital.lss.service.StockServiceImplSoapBindingStub _stub = new com.sogeti.digital.lss.service.StockServiceImplSoapBindingStub(new java.net.URL(StockServiceImpl_address), this);
                _stub.setPortName(getStockServiceImplWSDDServiceName());
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
        if ("StockServiceImpl".equals(inputPortName)) {
            return getStockServiceImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.lss.digital.sogeti.com", "StockServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.lss.digital.sogeti.com", "StockServiceImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StockServiceImpl".equals(portName)) {
            setStockServiceImplEndpointAddress(address);
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
