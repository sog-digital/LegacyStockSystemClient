/**
 * StockServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sogeti.digital.lss.service;

public interface StockServiceImpl extends java.rmi.Remote {
    public boolean update(com.sogeti.digital.lss.model.Product product) throws java.rmi.RemoteException;
    public boolean delete(int id) throws java.rmi.RemoteException;
    public boolean create(com.sogeti.digital.lss.model.Product product) throws java.rmi.RemoteException;
    public com.sogeti.digital.lss.model.Product[] getAllTheStocks() throws java.rmi.RemoteException;
    public com.sogeti.digital.lss.model.Product getStock(int id) throws java.rmi.RemoteException;
}
