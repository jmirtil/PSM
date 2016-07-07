package my.PSM.unitTestPSM;

import my.PSM.PSM_Interface.InterfaceFacade;

public class InterfaceFacadeStub extends InterfaceFacade {

	private int course;
	private String username;
	private String password;
	private boolean edit;
	private boolean logout;
	private boolean init;

	public String defSub = "";
	public String defSemester = "";
	public String defCourseName = "";
	public String defCourseStart = "";
	public String defCourseEnd = "";
	public String defMonStart = "";
	public String defMonEnd = "";
	public String defTueStart = "";
	public String defTueEnd = "";
	public String defWedStart = "";
	public String defWedEnd = "";
	public String defThuStart = "";
	public String defThuEnd = "";
	public String defFriStart = "";
	public String defFriEnd = "";
	public String defSatStart = "";
	public String defSatEnd = "";

	public InterfaceFacadeStub() {
		super();
		username = "";
		password = "";
	}

	public void testHelper(String courseSubj, String courseName,
			String semester, String startDate, String endDate, String startMon,
			String endMon, String startTue, String endTue, String startWed,
			String endWed, String startThu, String endThu, String startFri,
			String endFri, String startSat, String endSat) {
		defSub = courseSubj;
		defCourseName = courseName;
		defSemester = semester;
		defCourseStart = startDate;
		defCourseEnd = endDate;
		defMonStart = startMon;
		defMonEnd = endMon;
		defTueStart = startTue;
		defTueEnd = endTue;
		defWedStart = startWed;
		defWedEnd = endWed;
		defThuStart = startThu;
		defThuEnd = endThu;
		defFriStart = startFri;
		defFriEnd = endFri;
		defSatStart = startSat;
		defSatEnd = endSat;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public void setLogout(boolean logout) {
		this.logout = logout;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public void setUsername(String u) {
		username = u;
	}

	public void setPassword(String p) {
		password = p;
	}

	@Override
	public void lockedOut() {
		// do nothing
	}

	@Override
	public void logoutConfirmation() {
		// do nothing
	}

	@Override
	public void launchLogout() {
		// do nothing
	}

	@Override
	public void incorrectLogin() {
		// do nothing
	}

	@Override
	public void launchInitial() {
		// do nothing
	}

	@Override
	public void launchEdit(int courseID, String courseSubj, String courseName,
			String semester, String startDate, String endDate, String startMon,
			String endMon, String startTue, String endTue, String startWed,
			String endWed, String startThu, String endThu, String startFri,
			String endFri, String startSat, String endSat) {
		// do nothing
	}

	@Override
	public void launchCourse() {
		// do nothing
	}

	@Override
	public void launchLoginForm() {
		// do nothing
	}

	@Override
	public void launchMenu() {
		// do nothing
	}

	@Override
	public boolean menuDataRec() {
		return true;
	}

	@Override
	public void setMenuDataRec(boolean bool) {
		// do nothing
	}

	@Override
	public boolean schedDataRec() {
		return true;
	}

	@Override
	public void setSchedDataRec(boolean bool) {
		// do nothing
	}

	@Override
	public boolean courseSelected() {
		return true;
	}

	@Override
	public void setCourseSelected(boolean bool) {
		// true
	}

	@Override
	public int getSelection() {
		return course;
	}

	public void setCourse(int courseID) {
		course = courseID;
	}

	@Override
	public boolean psDataRec() {
		return true;
	}

	@Override
	public void setPsDataRec(boolean bool) {
		// do nothing
	}

	@Override
	public boolean dataReceived() {
		return true;
	}

	@Override
	public void setLogDataRec(boolean bool) {
		// do nothing
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setAck(boolean bool){
		//do nothing
	}
	@Override
	public boolean getAck() {
		return true;
	}

	@Override
	public boolean editSchedSelected() {
		return edit;
	}

	@Override
	public boolean InitSetupSelected() {
		return init;
	}

	@Override
	public boolean logoutSelected() {
		return logout;
	}

	public void setDefSub(String defSub) {
		this.defSub = defSub;
	}

	public void setDefSemester(String defSemester) {
		this.defSemester = defSemester;
	}

	public void setDefCourseName(String defCourseName) {
		this.defCourseName = defCourseName;
	}

	public void setDefCourseStart(String defCourseStart) {
		this.defCourseStart = defCourseStart;
	}

	public void setDefCourseEnd(String defCourseEnd) {
		this.defCourseEnd = defCourseEnd;
	}

	public void setDefMonStart(String defMonStart) {
		this.defMonStart = defMonStart;
	}

	public void setDefMonEnd(String defMonEnd) {
		this.defMonEnd = defMonEnd;
	}

	public void setDefTueStart(String defTueStart) {
		this.defTueStart = defTueStart;
	}

	public void setDefTueEnd(String defTueEnd) {
		this.defTueEnd = defTueEnd;
	}

	public void setDefWedStart(String defWedStart) {
		this.defWedStart = defWedStart;
	}

	public void setDefWedEnd(String defWedEnd) {
		this.defWedEnd = defWedEnd;
	}

	public void setDefThuStart(String defThuStart) {
		this.defThuStart = defThuStart;
	}

	public void setDefThuEnd(String defThuEnd) {
		this.defThuEnd = defThuEnd;
	}

	public void setDefFriStart(String defFriStart) {
		this.defFriStart = defFriStart;
	}

	public void setDefFriEnd(String defFriEnd) {
		this.defFriEnd = defFriEnd;
	}

	public void setDefSatStart(String defSatStart) {
		this.defSatStart = defSatStart;
	}

	public void setDefSatEnd(String defSatEnd) {
		this.defSatEnd = defSatEnd;
	}

	@Override
	public String getNewCourseStart() {
		return defCourseStart;
	}

	@Override
	public String getpNewCourseStart() {
		return defCourseStart;
	}

	@Override
	public int getDefCourseID() {
		return course;
	}

	@Override
	public String getpNewCourseEnd() {
		return defCourseEnd;
	}

	@Override
	public String getpNewMonStart() {
		return defMonStart;
	}

	@Override
	public String getpNewTueStart() {
		return defTueStart;
	}

	@Override
	public String getpNewTueEnd() {
		return defTueEnd;
	}

	@Override
	public String getpNewThuEnd() {
		return defThuEnd;
	}

	@Override
	public String getpNewThuStart() {
		return defThuStart;
	}

	@Override
	public String getpNewWedEnd() {
		return defWedEnd;
	}

	@Override
	public String getpNewWedStart() {
		return defWedStart;
	}

	@Override
	public String getpNewFriEnd() {
		return defFriEnd;
	}

	@Override
	public String getpNewSatEnd() {
		return defSatEnd;
	}

	@Override
	public String getpNewSatStart() {
		return defSatStart;
	}

	@Override
	public String getpNewFriStart() {
		return defFriStart;
	}

	@Override
	public String getpNewMonEnd() {
		return defMonEnd;
	}

	@Override
	public int getNewCourseID() {
		return course;
	}

	@Override
	public String getNewSub() {
		return defSub;
	}

	@Override
	public String getNewCourseName() {
		return defCourseName;
	}

	@Override
	public String getNewSemester() {
		return defSemester;
	}

	@Override
	public String getNewCourseEnd() {
		return defCourseEnd;
	}

	@Override
	public String getNewMonStart() {
		return defMonStart;
	}

	@Override
	public String getNewTueStart() {
		return defTueStart;
	}

	@Override
	public String getNewTueEnd() {
		return defTueEnd;
	}

	@Override
	public String getNewThuEnd() {
		return defThuEnd;
	}

	@Override
	public String getNewThuStart() {
		return defThuStart;
	}

	@Override
	public String getNewWedEnd() {
		return defWedEnd;
	}

	@Override
	public String getNewWedStart() {
		return defWedStart;
	}

	@Override
	public String getNewFriEnd() {
		return defFriEnd;
	}

	@Override
	public String getNewSatEnd() {
		return defSatEnd;
	}

	@Override
	public String getNewSatStart() {
		return defSatStart;
	}

	@Override
	public String getNewFriStart() {
		return defFriStart;
	}

	@Override
	public String getNewMonEnd() {
		return defMonEnd;
	}
	
}
