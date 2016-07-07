package my.PSM.unitTestPSM;

import java.util.ArrayList;
import java.util.HashMap;

import my.PSM.PSM_Storage.MySQLManager;

public class MySQLManagerStub extends MySQLManager {

	private String correctUser;
	private String correctPass;
	private boolean isConnected;

	/* Mimic functionality of database with hashmaps*/
	public ArrayList<Integer> courses = new ArrayList<Integer>();
	public HashMap<Integer, String> defSub = new HashMap<Integer, String>();
	public HashMap<Integer, String> defSemester = new HashMap<Integer, String>();
	public HashMap<Integer, String> defCourseName = new HashMap<Integer, String>();
	public HashMap<Integer, String> defCourseStart = new HashMap<Integer, String>();
	public HashMap<Integer, String> defCourseEnd = new HashMap<Integer, String>();
	public HashMap<Integer, String> defMonStart = new HashMap<Integer, String>();
	public HashMap<Integer, String> defMonEnd = new HashMap<Integer, String>();
	public HashMap<Integer, String> defTueStart = new HashMap<Integer, String>();
	public HashMap<Integer, String> defTueEnd = new HashMap<Integer, String>();
	public HashMap<Integer, String> defWedStart = new HashMap<Integer, String>();
	public HashMap<Integer, String> defWedEnd = new HashMap<Integer, String>();
	public HashMap<Integer, String> defThuStart = new HashMap<Integer, String>();
	public HashMap<Integer, String> defThuEnd = new HashMap<Integer, String>();
	public HashMap<Integer, String> defFriStart = new HashMap<Integer, String>();
	public HashMap<Integer, String> defFriEnd = new HashMap<Integer, String>();
	public HashMap<Integer, String> defSatStart = new HashMap<Integer, String>();
	public HashMap<Integer, String> defSatEnd = new HashMap<Integer, String>();

	/**
	 * This method is used to setup the "database" before applying test cases.
	 * 
	 * 
	 */
	public void testHelper(int courseID, String courseSubj, String courseName, String semester, String startDate,
			String endDate, String startMon, String endMon, String startTue, String endTue, String startWed,
			String endWed, String startThu, String endThu, String startFri, String endFri, String startSat,
			String endSat) {
		courses.add(courseID);
		defSub.put(courseID, courseSubj);
		defCourseName.put(courseID, courseName);
		defSemester.put(courseID, semester);
		defCourseStart.put(courseID, startDate);
		defCourseEnd.put(courseID, endDate);
		defMonStart.put(courseID, startMon);
		defMonEnd.put(courseID, endMon);
		defTueStart.put(courseID, startTue);
		defTueEnd.put(courseID, endTue);
		defWedStart.put(courseID, startWed);
		defWedEnd.put(courseID, endWed);
		defThuStart.put(courseID, startThu);
		defThuEnd.put(courseID, endThu);
		defFriStart.put(courseID, startFri);
		defFriEnd.put(courseID, endFri);
		defSatStart.put(courseID, startSat);
		defSatEnd.put(courseID, endSat);
	}

	/**
	 * This method will initiliaze a database with credentials corresponding to
	 * the parameters
	 * 
	 * @param username
	 * @param password
	 */
	public MySQLManagerStub(String username, String password) {
		correctUser = username;
		correctPass = password;
		isConnected = false;
	}

	@Override
	public int connect(String db, String user, String pw) {
		if (correctUser.equals(user) && correctPass.equals(pw)) {
			isConnected = true;
			return 0;
		} else {
			isConnected = false;
			return -1;
		}
	}

	@Override
	public int connect(String user, String pw) {
		if (correctUser.equals(user) && correctPass.equals(pw)) {
			isConnected = true;
			return 0;
		} else {
			isConnected = false;
			return -1;
		}
	}

	@Override
	public int disconnect() {
		isConnected = false;
		return 0;
	}

	@Override
	public int fetchCourseID(int courseID) {
		if (courses.contains(courseID))
			return courseID;
		else
			return -1;
	}

	@Override
	public ArrayList<String> getEndDates() {
		ArrayList<String> endDates = new ArrayList<String>();
		endDates.addAll(defCourseEnd.values());
		return endDates;
	}

	@Override
	public ArrayList<Integer> getCourses() {
		return courses;
	}

	@Override
	public String fetchCourseSubj(int courseID) {
		return defSub.get(courseID);
	}

	@Override
	public String fetchCourseName(int courseID) {
		return defCourseName.get(courseID);
	}

	@Override
	public String fetchCourseSemester(int courseID) {
		return defSemester.get(courseID);
	}

	@Override
	public String fetchCourseStart(int courseID) {
		return defCourseStart.get(courseID);
	}

	@Override
	public String fetchCourseEnd(int courseID) {
		return defCourseEnd.get(courseID);
	}

	@Override
	public String fetchStartMon(int courseID) {
		return defMonStart.get(courseID);
	}

	@Override
	public String fetchEndMon(int courseID) {
		return defMonEnd.get(courseID);
	}

	@Override
	public String fetchStartTue(int courseID) {
		return defTueStart.get(courseID);
	}

	@Override
	public String fetchEndTue(int courseID) {
		return defTueEnd.get(courseID);
	}

	@Override
	public String fetchStartWed(int courseID) {
		return defWedStart.get(courseID);
	}

	@Override
	public String fetchEndWed(int courseID) {
		return defWedEnd.get(courseID);
	}

	@Override
	public String fetchStartThu(int courseID) {
		return defThuStart.get(courseID);
	}

	@Override
	public String fetchEndThu(int courseID) {
		return defThuEnd.get(courseID);
	}

	@Override
	public String fetchStartFri(int courseID) {
		return defFriStart.get(courseID);
	}

	@Override
	public String fetchEndFri(int courseID) {
		return defFriEnd.get(courseID);
	}

	@Override
	public String fetchStartSat(int courseID) {
		return defSatStart.get(courseID);
	}

	@Override
	public String fetchEndSat(int courseID) {
		return defSatEnd.get(courseID);
	}

	@Override
	public int storeClassInfo(int courseID, String courseSubj, String courseName, String semester) {
		courses.add(courseID);
		defSub.put(courseID, courseSubj);
		defCourseName.put(courseID, courseName);
		defSemester.put(courseID, semester);
		return 0;
	}

	@Override
	public int storeClassSched(int courseID, String startDate, String endDate, String startMon, String endMon,
			String startTue, String endTue, String startWed, String endWed, String startThu, String endThu,
			String startFri, String endFri, String startSat, String endSat) {
		if (courses.contains(courseID)) {
			defCourseStart.put(courseID, startDate);
			defCourseEnd.put(courseID, endDate);
			defMonStart.put(courseID, startMon);
			defMonEnd.put(courseID, endMon);
			defTueStart.put(courseID, startTue);
			defTueEnd.put(courseID, endTue);
			defWedStart.put(courseID, startWed);
			defWedEnd.put(courseID, endWed);
			defThuStart.put(courseID, startThu);
			defThuEnd.put(courseID, endThu);
			defFriStart.put(courseID, startFri);
			defFriEnd.put(courseID, endFri);
			defSatStart.put(courseID, startSat);
			defSatEnd.put(courseID, endSat);
		}
		return 0;
	}

	@Override
	public void clearDatabase() {
		if (isConnected) {
			courses.clear();
			defSub.clear();
			defCourseName.clear();
			defSemester.clear();
			defCourseStart.clear();
			defCourseEnd.clear();
			defMonStart.clear();
			defMonEnd.clear();
			defTueStart.clear();
			defTueEnd.clear();
			defWedStart.clear();
			defWedEnd.clear();
			defThuStart.clear();
			defThuEnd.clear();
			defFriStart.clear();
			defFriEnd.clear();
			defSatStart.clear();
			defSatEnd.clear();
		}
	}

	@Override
	public int createClassTable() {
		// Precondition: the database is connected.
		return 0;
	}

}