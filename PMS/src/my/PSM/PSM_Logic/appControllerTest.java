package my.PSM.PSM_Logic;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class appControllerTest {
	private appController app;
	
	@Before
	public void runBeforeAllTest(){
		app = new appController();
	}
	@Test
	public void testAppController() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetupSched() {
		fail("Not yet implemented");
	}

	@Test
	public void testAppEditSched() {
		fail("Not yet implemented");
	}

	@Test
	public void testAppLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckClear() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckTimes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetData() {
		fail("Not yet implemented");
	}

	@Test
	public void testSleep() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCon() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTimeMillis() {
		fail("Not yet implemented");
	}

	@Test
	public void testTimerParser() {
		app.timerParser("04:35");
		Assert.assertTrue(app.returnHr() == 4 && app.returnMin() == 35);
	}

	@Test
	public void testDateParser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEndTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSemesterClear() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSemesterClear() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet15BeforeEnd() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet5BeforeEnd() {
		fail("Not yet implemented");
	}

	@Test
	public void testAutoExit() {
		fail("Not yet implemented");
	}

	@Test
	public void testAutoClear() {
		fail("Not yet implemented");
	}

}
