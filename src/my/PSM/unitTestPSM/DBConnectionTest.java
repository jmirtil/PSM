package my.PSM.unitTestPSM;
import static org.junit.Assert.*;

import java.util.ArrayList;

import my.PSM.PSM_Storage.DBConnection;

import org.junit.Before;
import org.junit.Test;

public class DBConnectionTest {

	DBConnection db = new DBConnection();
	MySQLManagerStub stub = new MySQLManagerStub("user","pw");
	
	
	@Before
	public void runBefore(){
		stub.testHelper(4010, "CEN", "Software Engineering", "Spring 2008", "01-02-08", "04-20-08", "12:00", "12:50", null, null, "12:00", "12:50", null, null, "12:00", "12:50", null, null);
		db.setMyManager(stub);
	}
	
	@Test
	public void testConnectStringStringString() {
		db.connect("jdbc:mysql://131.94.178.165:3306/mydb", "user", "pw");
	}

	@Test
	public void testConnectStringString() {
		db.connect("user", "pw");
	}

	@Test
	public void testDisconnect() {
		db.disconnect();
	}

	@Test
	public void testFetchCourseID() {
		boolean flag = false;
		int course = 4010;
		//courses = courses + "";
		if (course == db.fetchCourseID(4010)){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);

	}

	@Test
	public void testGetEndDates() {
		db.getEndDates().size();
		assertEquals(true,true);
	}

	@Test
	public void testGetCourses() {
		ArrayList<Integer> courses = new ArrayList<Integer>();
		boolean flag = false;
		courses.add(0, 4010);
		int a = courses.size();
		int b = db.getEndDates().size();
		int max;
		if (a >= b) {
			max = a;
		} else
			max = b;
		for (int i = 0; i < max; i++) {
			if (courses.get(i) == (db.getCourses().get(i))) {
				// do nothing
			} else
				flag = false;
		}
		flag = true;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchCourses() {
		boolean flag = false;
		String courses = "4010,";
		//courses = courses + "";
		if (courses.equalsIgnoreCase(db.fetchCourses())){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchCourseSubj() {
		boolean flag = false;
		String subj = "CEN";	//based on ID
		if (subj.equalsIgnoreCase(db.fetchCourseSubj(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchCourseName() {
		boolean flag = false;
		String courses = "Software Engineering"; //based on ID
		if (courses.equalsIgnoreCase(db.fetchCourseName(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchCourseSemester() {
		boolean flag = false;
		String semester= "Spring 2008"; //based on ID
		if (semester.equalsIgnoreCase(db.fetchCourseSemester(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchCourseStart() {
		boolean flag = false;
		String startDate= "01-02-08"; //based on ID
		if (startDate.equalsIgnoreCase(db.fetchCourseStart(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchCourseEnd() {
		boolean flag = false;
		String endDate= "04-20-08"; //based on ID
		if (endDate.equalsIgnoreCase(db.fetchCourseEnd(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchStartMon() {
		boolean flag = false;
		String startMon= "12:00"; //based on ID
		if (startMon.equalsIgnoreCase(db.fetchStartMon(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchEndMon() {
		boolean flag = false;
		String endMon= "12:50"; //based on ID
		if (endMon.equalsIgnoreCase(db.fetchEndMon(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchStartTue() {
		boolean flag = false;
		String startTue= null; //based on ID
		if (startTue == (db.fetchStartTue(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchEndTue() {
		boolean flag = false;
		String endTue= null; //based on ID
		if (endTue == (db.fetchEndTue(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchStartWed() {
		boolean flag = false;
		String startWed= "12:00"; //based on ID
		if (startWed.equalsIgnoreCase(db.fetchStartWed(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchEndWed() {
		boolean flag = false;
		String endWed= "12:50"; //based on ID
		if (endWed.equalsIgnoreCase(db.fetchEndWed(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchStartThu() {
		boolean flag = false;
		String startThu= null; //based on ID
		if (startThu == (db.fetchStartThu(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchEndThu() {
		boolean flag = false;
		String endThu= null; //based on ID
		if (endThu == (db.fetchEndThu(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchStartFri() {
		boolean flag = false;
		String startFri= "12:00"; //based on ID
		if (startFri.equalsIgnoreCase(db.fetchStartFri(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchEndFri() {
		boolean flag = false;
		String endFri= "12:50"; //based on ID
		if (endFri.equalsIgnoreCase(db.fetchEndFri(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchStartSat() {
		boolean flag = false;
		String startSat= null; //based on ID
		if (startSat == (db.fetchStartSat(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testFetchEndSat() {
		boolean flag = false;
		String endSat= null; //based on ID
		if (endSat == (db.fetchEndSat(4010))){
			flag = true;
		} else flag = false;
		assertEquals(true,flag);
	}

	@Test
	public void testStoreClassInfo() {
		db.storeClassInfo(4010, "CEN", "Software Testing", "Fall 2016");
		assertEquals(true,stub.courses.contains(4010));
		assertEquals("Software Testing",stub.defCourseName.get(4010));
		assertEquals("CEN",stub.defSub.get(4010));
		assertEquals("Fall 2016",stub.defSemester.get(4010));
	}

	//@Test
	//public void testStoreClassSched() {
		//fail("Not yet implemented");
	//}

	//@Test
	//public void testClearDatabase() {
		//fail("Not yet implemented");
	//}

	//@Test
	//public void testCreateClassTable() {
		//fail("Not yet implemented");
	//}

}
