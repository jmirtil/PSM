package my.PSM.PSM_Logic;

public class InterfaceControllerStub extends InterfaceController {
	public InterfaceControllerStub(){
		super();
	}
	
	@Override
    public void passwordLock()
    {
        //do nothing
    }
	
	@Override
    public void Initiate_Logout() 
    {
        //do nothing
     
    }
	
	@Override
    public void Initiate_IncorrectLogin()
    {
        
        //do nothing
        
    }
    
	@Override
    public void Initiate_Schedule_Form() 
    {
       
       //do nothing
    }

	@Override
    public void Pre_Filled_Form(int courseID, String courseSubj, String courseName, String semester,
            String startDate, String endDate, String startMon, String endMon,
            String startTue, String endTue, String startWed, String endWed, String startThu, String endThu, 
            String startFri, String endFri, String startSat, String endSat) 
    {

    
        
         //do nothing
    }
    
	@Override
    public void Course_Select_Form(){
        //do nothing
    }
	
	@Override
    public void Initiate_Login_Form() {

        //do nothing

    }

	@Override
    public void Initiate_MainMenu() {
        //do nothing

    }
}
