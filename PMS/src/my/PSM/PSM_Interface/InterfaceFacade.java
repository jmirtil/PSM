package my.PSM.PSM_Interface;

public class InterfaceFacade {
	private courseSelect course;
	private endOfClass end;
	private LoginForm login;
	private LogOutConfirm logout;
	private MainMenu menu;
	private Messages message;
	private PrefilledScheduleForm psForm;
	private ScheduleForm sForm;
	
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
}
