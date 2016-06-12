package my.PSM.PSM_Interface;

public class InterfaceFacadeStub extends InterfaceFacade {

	private static int course;
	private String username;
	private String password;
	private boolean ack;
	
	private boolean edit;
	private boolean logout;
	private boolean init;
	
	public static String defSub = "";
	public static String defSemester = "";
    public static String defCourseName = "";
    public String defCourseStart = "";
    public static String defCourseEnd = "";
    public static String defMonStart = "";
    public static String defMonEnd = "";
    public static String defTueStart = "";
    public static String defTueEnd = "";
    public static String defWedStart = "";
    public static String defWedEnd = "";
    public static String defThuStart = "";
    public static String defThuEnd = "";
    public static String defFriStart = "";
    public static String defFriEnd = "";
    public static String defSatStart = "";
    public static String defSatEnd = "";
    
	public InterfaceFacadeStub() {
		super();
		username = "";
		password = "";
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
	@Override
	public void lockedOut(){
		//do nothing
	}
	@Override
	public void logoutConfirmation(){
		//do nothing
	}
	@Override
	public void launchLogout(){
		//do nothing
	}
	@Override
	public void incorrectLogin(){
		//do nothing
	}
	@Override
	public void launchInitial(){
		//do nothing
	}
	@Override
	public void launchEdit(int courseID, String courseSubj, String courseName, String semester,
            String startDate, String endDate, String startMon, String endMon,
            String startTue, String endTue, String startWed, String endWed, String startThu, String endThu, 
            String startFri, String endFri, String startSat, String endSat){
		//do nothing
	}
	@Override
	public void launchCourse(){
		//do nothing
	}
	@Override
	public void launchLoginForm(){
		//do nothing
	}
	@Override
	public void launchMenu(){
		//do nothing
	}
	@Override
	public boolean menuDataRec(){
		return true;
	}
	@Override
	public void setMenuDataRec(boolean bool){
		//do nothing
	}
	@Override
	public boolean schedDataRec(){
		return true;
	}
	@Override
	public void setSchedDataRec(boolean bool){
		//do nothing
	}
	@Override
	public boolean courseSelected(){
		return true;
	}
	@Override
	public void setCourseSelected(boolean bool){
		//true
	}
	@Override
	public int getSelection(){
		return course;
	}
	public void setCourse(int courseID){
		course = courseID;
	}
	@Override
	public boolean psDataRec(){
		return true;
	}
	@Override
	public void setPsDataRec(boolean bool){
		//do nothing
	}
	@Override
	public boolean dataReceived(){
		return true;
	}
	@Override
	public void setLogDataRec(boolean bool){
		//do nothing
	}
	public void setUsername(String u){
		username = u;
	}
	public void setPassword(String p){
		password = p;
	}
	@Override
	public String getUsername(){
		return username;
	}
	@Override
	public String getPassword(){
		return password;
	}
	@Override
	public void setAck(boolean bool){
		ack = bool;
	}
	@Override
	public boolean getAck(){
		return ack;
	}
	@Override
	public boolean editSchedSelected(){
		return edit;
	}
	@Override
	public boolean InitSetupSelected(){
		return init;
	}
	@Override
	public boolean logoutSelected(){
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
	public String getNewCourseStart(){ 
		return defCourseStart;
	}
	@Override
	public String getpNewCourseStart(){ 
		return defCourseStart;
	}
	
	public static int getDefCourseID() {
		return course;
	}
	
	public static String getpNewCourseEnd() {
		return defCourseEnd;
	}
	
	public static String getpNewMonStart() {
		return defMonStart;
	}

	public static String getpNewTueStart() {
		return defTueStart;
	}

	public String getpNewTueEnd() {
		return defTueEnd;
	}

	public static String getpNewThuEnd() {
		return defThuEnd;
	}

	public static String getpNewThuStart() {
		return defThuStart;
	}

	public static String getpNewWedEnd() {
		return defWedEnd;
	}

	public static String getpNewWedStart() {
		return defWedStart;
	}

	public static String getpNewFriEnd() {
		return defFriEnd;
	}

	public static String getpNewSatEnd() {
		return defSatEnd;
	}

	public static String getpNewSatStart() {
		return defSatStart;
	}

	public static String getpNewFriStart() {
		return defFriStart;
	}

	public static String getpNewMonEnd() {
		return defMonEnd;
	}
	
	public static int getNewCourseID() {
		return course;
	}

	public static String getNewSub() {
		return defSub;
	}

	public static String getNewCourseName() {
		return defCourseName;
	}

	public static String getNewSemester() {
		return defSemester;
	}
	
	public static String getNewCourseEnd() {
		return defCourseEnd;
	}

	public static String getNewMonStart() {
		return defMonStart;
	}

	public static String getNewTueStart() {
		return defTueStart;
	}

	public String getNewTueEnd() {
		return defTueEnd;
	}

	public static String getNewThuEnd() {
		return defThuEnd;
	}

	public static String getNewThuStart() {
		return defThuStart;
	}

	public static String getNewWedEnd() {
		return defWedEnd;
	}

	public static String getNewWedStart() {
		return defWedStart;
	}

	public static String getNewFriEnd() {
		return defFriEnd;
	}

	public static String getNewSatEnd() {
		return defSatEnd;
	}

	public static String getNewSatStart() {
		return defSatStart;
	}

	public static String getNewFriStart() {
		return defFriStart;
	}

	public static String getNewMonEnd() {
		return defMonEnd;
	}
}
