package com.sogeti.digital.test.e2e.lss.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sogeti.digital.lss.service.PersonServiceImpl;
import com.sogeti.digital.lss.service.PersonServiceImplServiceLocator;

public class PersonSOAPServiceTest {
	
	static PersonServiceImplServiceLocator psl;
	static PersonServiceImpl psi;
	
	@BeforeClass
	public static void setUp() throws ServiceException, RemoteException {
		
		psl = new PersonServiceImplServiceLocator();
		psi = psl.getPersonServiceImpl();	
	}
	
	@AfterClass
	public static void tearDown() {
		
		psl = null;
		psi = null;
	}
	
	@Test	
	public void validLogin() throws ServiceException, RemoteException {
		
		assertTrue("login successful", psi.login("sogeti@sogeti.com", "pass"));
	}
	
	@Test	
	public void loginFailureDueToEmail() throws ServiceException, RemoteException {

		assertFalse("login failure due to email address", psi.login("sogeti@so.com", "pass"));
	}
	
	@Test	
	public void loginFailureDueToPassword() throws ServiceException, RemoteException {


		assertFalse("login failure due to password", psi.login("sogeti@sogeti.com", "pas"));
	}
	
	@Test	
	public void loginFailureDueToEmailAndPassword() throws ServiceException, RemoteException {

		assertFalse("login failure due to email address and password", psi.login("sogeti@seti.com", "pas"));
	}

}
