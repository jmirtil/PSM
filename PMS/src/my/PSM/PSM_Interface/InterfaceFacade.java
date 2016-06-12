package my.PSM.PSM_Interface;

public class InterfaceFacade {
	private courseSelect course;
	private endOfClass end;
	private LoginForm login;
	private LogOutConfirm logout;
	private MainMenu menu;
	private Messages message;
	private static PrefilledScheduleForm psForm;
	private static ScheduleForm sForm;
	
	public InterfaceFacade(){
		course = new courseSelect();
		end = new endOfClass();
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
	
	public static int getDefCourseID() {
		return psForm.getDefCourseID();
	}

	public static String getpNewCourseEnd() {
		return psForm.getNewCourseEnd();
	}

	public static String getpNewMonStart() {
		return psForm.getNewMonStart();
	}

	public static String getpNewTueStart() {
		return psForm.getNewTueStart();
	}

	public String getpNewTueEnd() {
		return psForm.getNewTueEnd();
	}

	public static String getpNewThuEnd() {
		return psForm.getNewThuEnd();
	}

	public static String getpNewThuStart() {
		return psForm.getNewThuStart();
	}

	public static String getpNewWedEnd() {
		return psForm.getNewWedEnd();
	}

	public static String getpNewWedStart() {
		return psForm.getNewWedStart();
	}

	public static String getpNewFriEnd() {
		return psForm.getNewFriEnd();
	}

	public static String getpNewSatEnd() {
		return psForm.getNewSatEnd();
	}

	public static String getpNewSatStart() {
		return psForm.getNewSatStart();
	}

	public static String getpNewFriStart() {
		return psForm.getNewFriStart();
	}

	public static String getpNewMonEnd() {
		return psForm.getNewMonEnd();
	}
	
	public static int getNewCourseID() {
		return sForm.getNewCourseID();
	}

	public static String getNewSub() {
		return sForm.getNewSub();
	}

	public static String getNewCourseName() {
		return sForm.getNewCourseName();
	}

	public static String getNewSemester() {
		return sForm.getNewSemester();
	}
	
	public static String getNewCourseEnd() {
		return sForm.getNewCourseEnd();
	}

	public static String getNewMonStart() {
		return sForm.getNewMonStart();
	}

	public static String getNewTueStart() {
		return sForm.getNewTueStart();
	}

	public String getNewTueEnd() {
		return sForm.getNewTueEnd();
	}

	public static String getNewThuEnd() {
		return sForm.getNewThuEnd();
	}

	public static String getNewThuStart() {
		return sForm.getNewThuStart();
	}

	public static String getNewWedEnd() {
		return sForm.getNewWedEnd();
	}

	public static String getNewWedStart() {
		return sForm.getNewWedStart();
	}

	public static String getNewFriEnd() {
		return sForm.getNewFriEnd();
	}

	public static String getNewSatEnd() {
		return sForm.getNewSatEnd();
	}

	public static String getNewSatStart() {
		return sForm.getNewSatStart();
	}

	public static String getNewFriStart() {
		return sForm.getNewFriStart();
	}

	public static String getNewMonEnd() {
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
