package com.sogeti.digital.test.e2e.lss.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.lss.service.PersonServiceImpl;
import com.sogeti.digital.lss.service.PersonServiceImplServiceLocator;

import mockit.Expectations;

public class PersonSOAPServiceTest {
	
	static PersonServiceImplServiceLocator psl;
	static PersonServiceImpl psi;
	static Person personExpected;
	
	@BeforeClass
	public static void setUp() throws ServiceException, RemoteException {
		
		psl = new PersonServiceImplServiceLocator();
		psi = psl.getPersonServiceImpl();	
		
		personExpected = new Person();
		personExpected.setId(1);
		personExpected.setFirstName("sogeti");
		personExpected.setLastName("ireland");
		personExpected.setDob("01-01-1967");
		personExpected.setEmail("sogeti@sogeti.com");
		
	}
	
	@AfterClass
	public static void tearDown() {
		
		psl = null;
		psi = null;
	}
	
	@Test	
	@Ignore public void validLogin() throws ServiceException, RemoteException {
		
		assertTrue("login successful", psi.login("sogeti@sogeti.com", "pass"));
	}
	
	@Test	
	@Ignore public void loginFailureDueToEmail() throws ServiceException, RemoteException {

		assertFalse("login failure due to email address", psi.login("sogeti@so.com", "pass"));
	}
	
	@Test	
	@Ignore public void loginFailureDueToPassword() throws ServiceException, RemoteException {


		assertFalse("login failure due to password", psi.login("sogeti@sogeti.com", "pas"));
	}
	
	@Test	
	@Ignore public void loginFailureDueToEmailAndPassword() throws ServiceException, RemoteException {

		assertFalse("login failure due to email address and password", psi.login("sogeti@seti.com", "pas"));
	}
	
	@Test
	@Ignore public void personDetailsAreCorrect() throws ServiceException, RemoteException {
		
		Person person = psi.read("sogeti@sogeti.com");
		//assertEquals("Found the person details for " + personExpected.getEmail() +"", personExpected, person);
		assertEquals(personExpected.getFirstName(), person.getFirstName(),"matches the first name");
		assertEquals(personExpected.getLastName(), person.getLastName(),"matches the last name");
		assertEquals(personExpected.getDob(), person.getDob(),"matches the dob");
		assertEquals(personExpected.getEmail(), person.getEmail(),"matches the email");
	}
	

}
