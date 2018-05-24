package com.sogeti.digital.test.mocking.lss.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.sogeti.digital.lss.service.PersonServiceImpl;
import com.sogeti.digital.lss.service.PersonServiceImplServiceLocator;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class PersonSOAPServiceMockTest {
	
	@Mocked
	private PersonServiceImplServiceLocator psl;

	@Mocked
	private  PersonServiceImpl psi;
	
	@Test	
	public void validLogin() throws ServiceException, RemoteException {
		
		new Expectations() { {
	
			psi.login("sogeti@sogeti.com", "pass");
			result = true;
		}};

		assertTrue("login successful", psi.login("sogeti@sogeti.com", "pass"));
	}
	
	@Test	
	public void loginFailureDueToEmail() throws ServiceException, RemoteException {
		
		new Expectations() { {
			
			psi.login("sogeti@soti.com", "pass");
			result = false;
		}};

		assertFalse("login failure due to email address", psi.login("sogeti@soti.com", "pass"));
	}
	
	@Test	
	public void loginFailureDueToPassword() throws ServiceException, RemoteException {
		
		new Expectations() { {
			
			psi.login("sogeti@sogeti.com", "wpass");
			result = false;
		}};

		assertFalse("login failure due to password", psi.login("sogeti@sogeti.com", "wpass"));
	}
	
	
	@Test	
	public void loginFailureDueToEmailAndPassword() throws ServiceException, RemoteException {
		
		new Expectations() { {
			
			psi.login("sogeti@seti.com", "wpass");
			result = false;
		}};

		assertFalse("login failure due to email address and password", psi.login("sogeti@seti.com", "wpass"));
	}
	
	

	
	


	
	

}
