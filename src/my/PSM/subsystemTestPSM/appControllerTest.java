package my.PSM.subsystemTestPSM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import my.PSM.PSM_Logic.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class appControllerTest {
	private appController app; //tested class
	private InterfaceFacadeStub iFacade; //stub
	private DataStoreFacadeStub dataStub; //stub

	@Before
	public void runBeforeAllTest(){
		//--Makes sure all dependent classes used are stubbed
		app = new appController();
		iFacade = new InterfaceFacadeStub(); //stubbed interface facade
		dataStub = new DataStoreFacadeStub("user", "pw"); //stubbed date store facade
		app.setDataStoreFacade(dataStub);
		Authenticate auth = new Authenticate();
		auth.setFacade(dataStub);
		app.setAuthenticate(auth); //inject authenticate stub
		InterfaceController interfaceStub = new InterfaceController(); //stubbed interface Controller
		interfaceStub.setFacade(iFacade);
		app.setInterfaceController(interfaceStub);
	}
	@After
	public void runAfterAllTest(){
		app = null;
		iFacade = null;
		dataStub = null;
	}
	
	@Test
	public void testCheckTimes() {
		dataStub.testHelper(5000, "CEN", "Software Testing", "SummerA",
				"01/15/16", "04/31/16", "04:30", "06:15", "04:30", "06:15", 
				"04:30", "06:15", "04:30", "06:15", "04:30", "06:15", "04:30", "06:15");

		try {
			app.checkTimes();
		} catch (NullPointerException e) {
			fail("did not handle this exception");
		}

		assertTrue(app.getActiveTimer());
	}
	@Test
	public void testCheckTimes2() {
		
		dataStub.testHelper(4072, "CEN", "Software Testing", "SummerA",
				"01/15/16", "04/31/16", null, null, null, null, null,
				null, null, null, null, null, null, null);
		try {
			app.checkTimes();
		} catch (NullPointerException e) {
			fail("did not handle this exception");
		}

		assertFalse(app.getActiveTimer());
	}
	@Test
	public void testAppEditSched2(){
		dataStub.courses.add(4072);
		app.setDataReceived(true);
		iFacade.setCourse(4072);
		iFacade.testHelper("CEN", "Software Testing", "Fall", "06/15/16", 
				"07/15/16", null, null, "04:30", "06:15", null, null,
				"04:30", "06:15", null, null, null, null);
		app.appEditSched();
		
		//--Expect the mimicked user input to be in the database
		Assert.assertEquals(dataStub.defCourseStart.get(4072), "06/15/16");
		Assert.assertEquals(dataStub.defCourseEnd.get(4072), "07/15/16");
		Assert.assertEquals(dataStub.defMonStart.get(4072), null);
		Assert.assertEquals(dataStub.defMonEnd.get(4072), null);
		Assert.assertEquals(dataStub.defTueStart.get(4072), "04:30");
		Assert.assertEquals(dataStub.defTueEnd.get(4072), "06:15");
		Assert.assertEquals(dataStub.defWedStart.get(4072), null);
		Assert.assertEquals(dataStub.defWedEnd.get(4072), null);
		Assert.assertEquals(dataStub.defThuStart.get(4072), "04:30");
		Assert.assertEquals(dataStub.defThuEnd.get(4072), "06:15");
		Assert.assertEquals(dataStub.defFriStart.get(4072), null);
		Assert.assertEquals(dataStub.defFriEnd.get(4072), null);
		Assert.assertEquals(dataStub.defSatStart.get(4072), null);
		Assert.assertEquals(dataStub.defSatEnd.get(4072), null);
		
	}
	@Test
	public void testMyMain() {
		//--Mimic User Input
		iFacade.setUsername("user");
		iFacade.setPassword("pw");
		iFacade.setLogout(true);

		app.myMain();
		
		//--Expect to be logged out when method returns
		assertEquals(app.getUser(), "user");
		assertEquals(app.getPass(), "pw");
		assertEquals(app.getLoggedIn(), false);
		assertTrue(app.isLogoutSel());
	}

	@Test
	public void testAppMainMenu(){
		//--Mimic user input
		iFacade.setEdit(true);
		
		app.appMainMenu();
		
		//--Expect edSchedSel to be true
		assertTrue(app.isEdSchedSel());
	}
	@Test
	public void testAppMainMenu02(){
		//--Mimic user input
		iFacade.setLogout(true);
		
		app.appMainMenu();
		
		//--Expect logoutSel to be true
		assertTrue(app.isLogoutSel());
	}
	@Test
	public void testAppMainMenu03(){
		//--Mimic user input
		iFacade.setInit(true);
		
		app.appMainMenu();
		
		//--Expect schedSetupSel to be true
		assertTrue(app.isSchedSetupSel());
	}
	@Test
	public void testSetupSched() {
		
		//--Mimic user input
		iFacade.setCourse(4072);
		iFacade.testHelper("CEN", "Software Testing", "Fall", "06/15/16", 
				"07/15/16", null, null, "04:30", "06:15", null, null,
				"04:30", "06:15", null, null, null, null);
		
		app.setupSched();
		
		//--Expect the mimicked user input to be in the database
		Assert.assertTrue(dataStub.courses.contains(4072));
		Assert.assertEquals(dataStub.defCourseName.get(4072), "Software Testing");
		Assert.assertEquals(dataStub.defSub.get(4072), "CEN");
		Assert.assertEquals(dataStub.defSemester.get(4072), "Fall");
		Assert.assertEquals(dataStub.defCourseStart.get(4072), "06/15/16");
		Assert.assertEquals(dataStub.defCourseEnd.get(4072), "07/15/16");
		Assert.assertEquals(dataStub.defMonStart.get(4072), null);
		Assert.assertEquals(dataStub.defMonEnd.get(4072), null);
		Assert.assertEquals(dataStub.defTueStart.get(4072), "04:30");
		Assert.assertEquals(dataStub.defTueEnd.get(4072), "06:15");
		Assert.assertEquals(dataStub.defWedStart.get(4072), null);
		Assert.assertEquals(dataStub.defWedEnd.get(4072), null);
		Assert.assertEquals(dataStub.defThuStart.get(4072), "04:30");
		Assert.assertEquals(dataStub.defThuEnd.get(4072), "06:15");
		Assert.assertEquals(dataStub.defFriStart.get(4072), null);
		Assert.assertEquals(dataStub.defFriEnd.get(4072), null);
		Assert.assertEquals(dataStub.defSatStart.get(4072), null);
		Assert.assertEquals(dataStub.defSatEnd.get(4072), null);
	}

	@Test
	public void testAppEditSched() {
		//--Precondition: Database has the course with ID 4072
		dataStub.courses.add(4072);
		
		//--Mimic user input
		iFacade.setCourse(4072);
		iFacade.testHelper("CEN", "Software Testing", "Fall", "06/15/16", 
				"07/15/16", null, null, "04:30", "06:15", null, null,
				"04:30", "06:15", null, null, null, null);
		//--
		
		app.appEditSched();
		
		//--Expect the mimicked user input to be in the database
		Assert.assertEquals(dataStub.defCourseStart.get(4072), "06/15/16");
		Assert.assertEquals(dataStub.defCourseEnd.get(4072), "07/15/16");
		Assert.assertEquals(dataStub.defMonStart.get(4072), null);
		Assert.assertEquals(dataStub.defMonEnd.get(4072), null);
		Assert.assertEquals(dataStub.defTueStart.get(4072), "04:30");
		Assert.assertEquals(dataStub.defTueEnd.get(4072), "06:15");
		Assert.assertEquals(dataStub.defWedStart.get(4072), null);
		Assert.assertEquals(dataStub.defWedEnd.get(4072), null);
		Assert.assertEquals(dataStub.defThuStart.get(4072), "04:30");
		Assert.assertEquals(dataStub.defThuEnd.get(4072), "06:15");
		Assert.assertEquals(dataStub.defFriStart.get(4072), null);
		Assert.assertEquals(dataStub.defFriEnd.get(4072), null);
		Assert.assertEquals(dataStub.defSatStart.get(4072), null);
		Assert.assertEquals(dataStub.defSatEnd.get(4072), null);
	}

	@Test
	public void testAppLogin() {
		//--Mimic User Input
		iFacade.setUsername("user");
		iFacade.setPassword("pw");
		
		app.appLogin();
		
		//--Expect to successfully login. And the state of app to change.
		Assert.assertTrue(app.getLoggedIn());
		Assert.assertEquals(app.getUser(), "user");
		Assert.assertEquals(app.getPass(), "pw");
	}

	@Test
	public void testAppLogin02() {
		//--Mimic User Input
		iFacade.setUsername("Peter");
		iFacade.setPassword("Clarke");
		
		app.appLogin();
		
		//--Expect to unsuccessfully login. And method returns from 3 failed attempts.
		assertEquals(app.getLoggedIn(), false);
		assertEquals(app.getCounter(), 3);
		assertEquals(app.getUser(), "Peter");
		assertEquals(app.getPass(), "Clarke");
	}
	@Test
	public void testCheckClear() {
		//--Precondition: database is empty
		
		//--Expect the method to return true
		Assert.assertTrue(app.checkClear());
		
	}
	
	@Test
	public void testCheckClear02() {
		//--Precondition: database contains the following info
		dataStub.testHelper(4072, "CEN", "Software Testing", "SummerA", "01/15/16", "04/31/16", null, null, 
				"04:30", "06:15", null, null, "04:30", "06:15", null, null, null, null);
		dataStub.testHelper(4010, "CEN", "Software Engineering", "SummerA", "01/15/16", "04/28/16", null, null, 
				"04:30", "06:15", null, null, "04:30", "06:15", null, null, null, null);
		//--Expect the method to return true
		Assert.assertTrue(app.checkClear());
	}

	@Test
	public void testCheckClear03() {
		//--Precondition: database is contains the following info
		dataStub.testHelper(4072, "CEN", "Software Testing", "SummerA", "04/31/16", "07/31/16", null, null, 
				"04:30", "06:15", null, null, "04:30", "06:15", null, null, null, null);
		dataStub.testHelper(4010, "CEN", "Software Engineering", "SummerA", "04/28/16", "07/28/16", null, null, 
				"04:30", "06:15", null, null, "04:30", "06:15", null, null, null, null);
		//--Expect the method to return false
		Assert.assertEquals(app.checkClear(), false);
		
	}

	@Test
	public void testGetData() {
		//--Precondition: Database contains the following info
		dataStub.testHelper(4072, "CEN", "Software Testing", "SummerA", "06/15/16", "07/15/16", null, null, 
				"04:30", "06:15", null, null, "04:30", "06:15", null, null, null, null);
		
		app.getData(4072);
		
		//--Expect the fields of app to change to the corresponding data in the database
		Assert.assertEquals(app.defCourseName, "Software Testing");
		Assert.assertEquals(app.defSub, "CEN");
		Assert.assertEquals(app.defSemester, "SummerA");
		Assert.assertEquals(app.defCourseStart, "06/15/16");
		Assert.assertEquals(app.defCourseEnd, "07/15/16");
		Assert.assertEquals(app.defMonStart, null);
		Assert.assertEquals(app.defMonEnd, null);
		Assert.assertEquals(app.defTueStart, "04:30");
		Assert.assertEquals(app.defTueEnd, "06:15");
		Assert.assertEquals(app.defWedStart, null);
		Assert.assertEquals(app.defWedEnd, null);
		Assert.assertEquals(app.defThuStart, "04:30");
		Assert.assertEquals(app.defThuEnd, "06:15");
		Assert.assertEquals(app.defFriStart, null);
		Assert.assertEquals(app.defFriEnd, null);
		Assert.assertEquals(app.defSatStart, null);
		Assert.assertEquals(app.defSatEnd, null);
	}

}
