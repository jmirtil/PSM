package my.PSM.subsystemTestPSM;

import static org.junit.Assert.*;
import my.PSM.PSM_Logic.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AuthenticateTest {

	Authenticate auth;
	private DataStoreFacadeStub dataStub; //stub
	
	@Before
	public void setup(){
		auth = new Authenticate();
		dataStub = new DataStoreFacadeStub("user", "pw");
		auth.setFacade(dataStub);
	}
	
	@After
	public void teardown(){
		auth = null;
		dataStub = null;
	}
	
	@Test
	public void testValidate_Login() {
		auth.setCredentials("user", "pw");
		assertTrue(auth.validate_Login());
	}

	@Test
	public void testValidate_Login_02() {
		auth.setCredentials("Peter", "Clarke");
		assertFalse(auth.validate_Login());
	}
	@Test
	public void testLogout() {
		assertTrue(auth.logout());
	}

}
