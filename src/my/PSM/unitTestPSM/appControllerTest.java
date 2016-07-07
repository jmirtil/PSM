package my.PSM.unitTestPSM;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.lang.System;

import my.PSM.PSM_Logic.appController;

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
		app.setAuthenticate(new AuthenticateStub("user", "pw")); //inject authenticate stub
		InterfaceControllerStub interfaceStub = new InterfaceControllerStub(iFacade); //stubbed interface Controller
		app.setInterfaceController(interfaceStub);
	}
	@After
	public void runAfterAllTest(){
		app = null;
		iFacade = null;
		dataStub = null;
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

	@Test
	public void testSleep() {
		long begin = System.currentTimeMillis();
		app.sleep(5);
		long end = System.currentTimeMillis();
		
		//Expect time elapsed to be 5ms.
		Assert.assertEquals(end-begin, 5);
	}

	@Test
	public void testLogIn() {
		//--Precondition: The state of app has the correct user credentials
		app.setUser("user");
		app.setPassword("pw");
		
		app.LogIn();
		
		//--Expect the loggedin field to be true
		Assert.assertTrue(app.getLoggedIn());
	}

	@Test
	public void testLogIn02() {
		//--Precondition: The state of app has the correct user credentials
		app.setUser("peter");
		app.setPassword("clarke");
		
		app.LogIn();
		
		//--Expect the loggedin field to be true
		Assert.assertFalse(app.getLoggedIn());
	}

	@Test
	public void testTimerParser() {
		app.timerParser("04:35");
		
		//--Expect the hr = 4 and min = 35
		Assert.assertTrue(app.returnHr() == 4 && app.returnMin() == 35);
	}

	
	@Test
	public void testDateParser() {
		app.dateParser("06/31/16");
		
		//--Expect month = 6, date = 31, year = 16
		Assert.assertEquals(app.getClearYear(), 16);
		Assert.assertEquals(app.getClearMonth(), 6);
		Assert.assertEquals(app.getClearDate(), 31);
	}

	@Test
	public void testGetEndTime() {
		//--Expect a date that has hr = 4, min = 29
		assertEquals(app.getEndTime(4, 30).toString().substring(11, 16), "04:29");
	}

	@Test
	public void testGet15BeforeEnd() {
		//--Expect a date that has hr = 4, min = 15
		assertEquals(app.get15BeforeEnd(4, 30).toString().substring(11, 16), "04:15");
	}

	@Test
	public void testGet15BeforeEnd02() {
		//--Expect a date that has hr = 3, min = 55
		assertEquals(app.get15BeforeEnd(4, 10).toString().substring(11, 16), "03:55");
	}
	@Test
	public void testGet5BeforeEnd() {
		Calendar date = new GregorianCalendar();
		date.setTimeInMillis(System.currentTimeMillis());
		date.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE, 
				4, 25, 1);
		
		//--Expect a date that has hr = 4, min = 25
		assertEquals(app.get5BeforeEnd(4, 30).toString().substring(11, 16), "04:25");
	}

	@Test
	public void testGet5BeforeEnd02() {
		Calendar date = new GregorianCalendar();
		date.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE, 
				3, 58, 1);
		
		//--Expect a date that has hr = 3, min = 58
		assertEquals(app.get5BeforeEnd(4, 3).toString().substring(11, 16), "03:58");
	}
}
