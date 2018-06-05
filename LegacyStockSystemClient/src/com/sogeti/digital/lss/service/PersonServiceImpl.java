/**
 * PersonServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sogeti.digital.lss.service;

public interface PersonServiceImpl extends java.rmi.Remote {
    public com.sogeti.digital.lss.model.Person read(java.lang.String email) throws java.rmi.RemoteException;
    public boolean changePassword(com.sogeti.digital.lss.model.Person person) throws java.rmi.RemoteException;
    public boolean login(java.lang.String email, java.lang.String password) throws java.rmi.RemoteException;
}
