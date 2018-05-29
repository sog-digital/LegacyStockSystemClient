package com.sogeti.digital.test.mocking.lss.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.sogeti.digital.lss.model.Person;
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
	
	
	@Test
	public void personDetailsAreCorrect() throws ServiceException, RemoteException {
		
		Person personExpected = new Person();
		personExpected.setId(1);
		personExpected.setFirstName("sogeti");
		personExpected.setLastName("ireland");
		personExpected.setDob("01-01-1967");
		personExpected.setEmail("sogeti@sogeti.com");
		
		Person personReturned = new Person();
		personReturned.setId(1);
		personReturned.setFirstName("sogeti");
		personReturned.setLastName("ireland");
		personReturned.setDob("01-01-1967");
		personReturned.setEmail("sogeti@sogeti.com");
		
		new Expectations() {
			{
				psi.read("sogeti@sogeti.com");
				result = personReturned;				
			}
		};
		
		psi.read("sogeti@sogeti.com");
		
		assertEquals(personExpected.getFirstName(), personReturned.getFirstName(),"matches the first name");
		assertEquals(personExpected.getLastName(), personReturned.getLastName(),"matches the last name");
		assertEquals(personExpected.getDob(), personReturned.getDob(),"matches the dob");
		assertEquals(personExpected.getEmail(), personReturned.getEmail(),"matches the email");
		
	}

}
