package my.PSM.subsystemTestPSM;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import my.PSM.PSM_Logic.LogicFacade;

public class logicTest {
	
    LogicFacade logicFacade;
    DataStoreFacadeStub data;
	@Before
	public void setUp() throws Exception {
		data = new DataStoreFacadeStub("user", "pw");
    	logicFacade = new LogicFacade(data);
		
	}

	@After
	public void tearDown() throws Exception {
		logicFacade = null;
	}

	@Test
	public void testfetchcourse() {
		data.testHelper(4072, "CEN", "Software Testing", "SummerA", "06/15/16", "07/15/16", null, null, "4:30", "6:15", null, null, null, null, null, null, null, null);
		data.testHelper(3530, "CEN", "Software Testing", "SummerA", "06/15/16", "07/15/16", null, null, "4:30", "6:15", null, null, null, null, null, null, null, null);
		((DataStoreFacadeStub)data).setString("4072,3530,");
		String s=logicFacade.fetchCourses();
	   
		assertEquals(s, "4072,3530,");
		
		
	}
	
	@Test
	public void testfetchcourse02(){
		((DataStoreFacadeStub)data).setString("");
		String s=logicFacade.fetchCourses();
	   
		assertEquals(s, "");
	}
	@Test
	public void testfetchcourse01(){
		data.testHelper(4072, "CEN", "Software Testing", "SummerA", "06/15/16", "07/15/16", null, null, "4:30", "6:15", null, null, null, null, null, null, null, null);
		((DataStoreFacadeStub)data).setString("4072,");
		String s=logicFacade.fetchCourses();
	   
		assertEquals(s, "4072,");
	}

}

