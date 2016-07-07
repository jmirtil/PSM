package my.PSM.PSM_Interface;

import my.PSM.PSM_Logic.LogicFacade;

public class InterfaceFacade {
	private courseSelect course;
	private LoginForm login;
	private LogOutConfirm logout;
	private MainMenu menu;
	private Messages message;
	private static PrefilledScheduleForm psForm;
	private static ScheduleForm sForm;
	
	public InterfaceFacade(){
		
	}
	public void initiate(LogicFacade lfacade){
		course = new courseSelect(lfacade);
		login = new LoginForm();
		logout = new LogOutConfirm();
		menu = new MainMenu();
		message = new Messages();
		psForm = new PrefilledScheduleForm();
		sForm = new ScheduleForm();
	}
	public void lockedOut(){
		message.lockedOut();
	}
	
	public void logoutConfirmation(){
		message.logoutConfirmation();
	}
	
	public void launchLogout(){
		logout.launchLogout();
	}
	
	public void incorrectLogin(){
		message.incorrectLogin();
	}
	
	public void launchInitial(){
		sForm.launchInitial();
	}
	
	public void launchEdit(int courseID, String courseSubj, String courseName, String semester,
            String startDate, String endDate, String startMon, String endMon,
            String startTue, String endTue, String startWed, String endWed, String startThu, String endThu, 
            String startFri, String endFri, String startSat, String endSat){
		psForm.launchEdit(courseID, courseSubj, courseName, semester, startDate, endDate, startMon, endMon, startTue, endTue, startWed, endWed, startThu, endThu, startFri, endFri, startSat, endSat);
	}
	
	public void launchCourse(){
		course.launchCourse();
	}
	
	public void launchLoginForm(){
		login.launchForm();
	}
	
	public void launchMenu(){
		menu.launchForm();
	}
	
	public boolean menuDataRec(){
		return menu.dataRec();
	}
	
	public boolean editSchedSelected(){
		return menu.editSchedSelected();
	}
	
	public boolean InitSetupSelected(){
		return menu.InitSetupSelected();
	}
	
	public boolean logoutSelected(){
		return menu.logoutSelected();
	}
	
	public void setMenuDataRec(boolean bool){
		menu.setdataRec(bool);
	}
	
	public boolean schedDataRec(){
		return sForm.dataRec();
	}
	
	public void setSchedDataRec(boolean bool){
		sForm.setDataRec(bool);
	}
	
	public int getDefCourseID() {
		return psForm.getDefCourseID();
	}

	public String getpNewCourseEnd() {
		return psForm.getNewCourseEnd();
	}

	public String getpNewMonStart() {
		return psForm.getNewMonStart();
	}

	public String getpNewTueStart() {
		return psForm.getNewTueStart();
	}

	public String getpNewTueEnd() {
		return psForm.getNewTueEnd();
	}

	public String getpNewThuEnd() {
		return psForm.getNewThuEnd();
	}

	public String getpNewThuStart() {
		return psForm.getNewThuStart();
	}

	public String getpNewWedEnd() {
		return psForm.getNewWedEnd();
	}

	public String getpNewWedStart() {
		return psForm.getNewWedStart();
	}

	public String getpNewFriEnd() {
		return psForm.getNewFriEnd();
	}

	public String getpNewSatEnd() {
		return psForm.getNewSatEnd();
	}

	public String getpNewSatStart() {
		return psForm.getNewSatStart();
	}

	public String getpNewFriStart() {
		return psForm.getNewFriStart();
	}

	public String getpNewMonEnd() {
		return psForm.getNewMonEnd();
	}
	
	public int getNewCourseID() {
		return sForm.getNewCourseID();
	}

	public String getNewSub() {
		return sForm.getNewSub();
	}

	public String getNewCourseName() {
		return sForm.getNewCourseName();
	}

	public String getNewSemester() {
		return sForm.getNewSemester();
	}
	
	public String getNewCourseEnd() {
		return sForm.getNewCourseEnd();
	}

	public String getNewMonStart() {
		return sForm.getNewMonStart();
	}

	public String getNewTueStart() {
		return sForm.getNewTueStart();
	}

	public String getNewTueEnd() {
		return sForm.getNewTueEnd();
	}

	public String getNewThuEnd() {
		return sForm.getNewThuEnd();
	}

	public String getNewThuStart() {
		return sForm.getNewThuStart();
	}

	public String getNewWedEnd() {
		return sForm.getNewWedEnd();
	}

	public String getNewWedStart() {
		return sForm.getNewWedStart();
	}

	public String getNewFriEnd() {
		return sForm.getNewFriEnd();
	}

	public String getNewSatEnd() {
		return sForm.getNewSatEnd();
	}

	public String getNewSatStart() {
		return sForm.getNewSatStart();
	}

	public String getNewFriStart() {
		return sForm.getNewFriStart();
	}

	public String getNewMonEnd() {
		return sForm.getNewMonEnd();
	}
	
	public boolean courseSelected(){
		return course.courseSelected();
	}
	
	public void setCourseSelected(boolean bool){
		course.setCourseSelected(bool);
	}
	
	public int getSelection(){
		return course.getSelection();
	}
	
	public boolean psDataRec(){
		return psForm.dataRec();
	}
	
	public void setPsDataRec(boolean bool){
		psForm.setDataRec(bool);
	}

	public String getNewCourseStart(){ 
		return sForm.getNewCourseStart();
	}
	
	public String getpNewCourseStart(){ 
		return psForm.getNewCourseStart();
	}
	
	public boolean dataReceived(){
		return login.dataReceived();
	}
	
	public void setLogDataRec(boolean bool){
		login.setDataRec(bool);
	}
	
	public String getUsername(){
		return login.getUsername();
	}
	
	public String getPassword(){
		return login.getPassword();
	}
	
	public void setAck(boolean bool){
		message.ack = bool;
	}
	
	public boolean getAck(){
		return message.ack;
	}
	
	public void FifteenMinWarning(){
		message.FifteenMinWarning();
	}
	
	public void FiveMinWarning(){
		message.FiveMinWarning();
	}
	
	public void endClassWarning(){
		message.endClassWarning();
	}
	
	
}
