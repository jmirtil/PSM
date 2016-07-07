package my.PSM.PSM_Logic;

import my.PSM.PSM_Interface.InterfaceFacade;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : PSM - Professor Schedule Manager
//  @ File Name : 
//  @ Date : 03/16/2008
//  @ Author : 
//
//

public class InterfaceController {
    public InterfaceFacade facade;
    
    public InterfaceController()
    {
        
    }
    public void setFacade(InterfaceFacade temp){
    	facade = temp;
    }
    public void passwordLock()
    {
        facade.lockedOut();
    }
    public void Initiate_Logout() 
    {
        //System.out.print("lame");
        
         //logout.launchLogout();
         facade.logoutConfirmation();
     
    }

    public void Initiate_IncorrectLogin()
    {
        
        facade.incorrectLogin();
        //il.launchForm();
        
    }
    
    public void Initiate_Schedule_Form() 
    {
       
       facade.launchInitial();
    }

    public void Pre_Filled_Form(int courseID, String courseSubj, String courseName, String semester,
            String startDate, String endDate, String startMon, String endMon,
            String startTue, String endTue, String startWed, String endWed, String startThu, String endThu, 
            String startFri, String endFri, String startSat, String endSat) 
    {

    
        
         facade.launchEdit(courseID, courseSubj, courseName, semester,
            startDate, endDate, startMon, endMon, startTue, endTue, 
            startWed, endWed, startThu, endThu, startFri, endFri, startSat, endSat);
    }
    
    public void Course_Select_Form(){
        facade.launchCourse();
    }
    public void Initiate_Login_Form() {

        facade.launchLoginForm();

    }

    public void Initiate_Message() {

    }

    public void Initiate_MainMenu() {
        facade.launchMenu();

    }
}
