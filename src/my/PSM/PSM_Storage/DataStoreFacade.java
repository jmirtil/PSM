/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.PSM.PSM_Storage;

import java.util.ArrayList;

/**
 *
 * @author clarkep
 */
public class DataStoreFacade {
	public DataStoreFacade(){
		
	}
	//DBConnection dbCon = new DBConnection();
	private static DBConnection myManager = new DBConnection();
	
	public DBConnection getCon(){
		return myManager;
	}
	public int connect(String username, String password) {	
		//return dbCon.connect(username, password);
		return myManager.connect(username, password);
	}	
	public int disconnect() {
		return myManager.disconnect();
	}	
	
	public ArrayList<String> getEndDates() {
		return myManager.getEndDates();
	}
	public String fetchCourses() {
		//return dbCon.fetchCourses();
		return myManager.fetchCourses().toString();
	}
	public String fetchCourseSubj(int courseId) {
		//return dbCon.fetchCourseSubj(courseId);
		return myManager.fetchCourseSubj(courseId);
	}
	public String fetchCourseName(int courseId) {
		//return dbCon.fetchCourseName(courseId);
		return myManager.fetchCourseName(courseId);
	}
	public String fetchCourseSemester(int courseId) {
		//return dbCon.fetchCourseSemester(courseId);
		return myManager.fetchCourseSemester(courseId);
	}
	public String fetchCourseStart(int courseId) {
		//return dbCon.fetchCourseStart(courseId);
		return myManager.fetchCourseStart(courseId);
	}
	public String fetchCourseEnd(int courseId) {
		//return dbCon.fetchCourseEnd(courseId);
		return myManager.fetchCourseEnd(courseId);
	}
	public String fetchStartMon(int courseId) {
		//return dbCon.fetchStartMon(courseId);
		return myManager.fetchStartMon(courseId);
	}
	public String fetchEndMon(int courseId) {
		//return dbCon.fetchEndMon(courseId);
		return myManager.fetchEndMon(courseId);
	}
	public String fetchStartTue(int courseId) {
		//return dbCon.fetchStartTue(courseId);
		return myManager.fetchStartTue(courseId);
	}
	public String fetchEndTue(int courseId) {
		//return dbCon.fetchEndTue(courseId);
		return myManager.fetchEndTue(courseId);
	}
	public String fetchStartWed(int courseId) {
		//return dbCon.fetchStartWed(courseId);
		return myManager.fetchStartWed(courseId);
	}
	public String fetchEndWed(int courseId) {
		//return dbCon.fetchEndWed(courseId);
		return myManager.fetchEndWed(courseId);
	}
	public String fetchStartThu(int courseId) {
		//return dbCon.fetchStartThu(courseId);
		return myManager.fetchStartThu(courseId);
	}
	public String fetchEndThu(int courseId) {
		//return dbCon.fetchEndThu(courseId);
		return myManager.fetchEndThu(courseId);
	}
	public String fetchStartFri(int courseId) {
		//return dbCon.fetchStartFri(courseId);
		return myManager.fetchStartFri(courseId);
	}
	public String fetchEndFri(int courseId) {
		//return dbCon.fetchEndFri(courseId);
		return myManager.fetchEndFri(courseId);
	}
	public String fetchStartSat(int courseId) {
		//return dbCon.fetchStartSat(courseId);
		return myManager.fetchStartSat(courseId);
	}
	public String fetchEndSat(int courseId) {
		//return dbCon.fetchEndSat(courseId);
		return myManager.fetchEndSat(courseId);
	}
	public void clearDatabase() {
		myManager.clearDatabase();
	}
	public ArrayList<Integer> getCourses() {
		return myManager.getCourses();
	}
	public int storeClassInfo(int courseID, String courseSubj, String courseName, String semester)
	{
		return myManager.storeClassInfo(courseID, courseSubj, courseName, semester);
	}
	
	public int storeClassSched(int courseID, String startDate, String endDate, String startMon, String endMon,	            String startTue, String endTue, String startWed, String endWed, String startThu, String endThu, 
	            String startFri, String endFri, String startSat, String endSat)
    {
		return myManager.storeClassSched(courseID, startDate, endDate, startMon, endMon, startTue, endTue, startWed, endWed, startThu, endThu, startFri, endFri, startSat, endSat);
    }
	
	
}
		
