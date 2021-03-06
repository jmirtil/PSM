/*
 * ApplicationLogic.java
 *
 * Created on April 12, 2008, 11:03 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package my.PSM.PSM_Logic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.lang.Thread;
import java.util.logging.Level;
import java.util.logging.Logger;

import my.PSM.PSM_Storage.DBConnection;
import my.PSM.PSM_Interface.*;

/**
 *
 * @author lrizo002
 */
public class appController {
    
    private static final long TENMIN = 600000;
    
    private static int hr;
    private static int min;
    private static Calendar autoClear = new GregorianCalendar();
    private static Calendar setRun = new GregorianCalendar();
    private static Calendar calendar = new GregorianCalendar();
    private static Timer timer = new FutureTimer();
    private static Date date = new Date();
    private static Date date2 = new Date();
    
    public static String defSub = "";
    public static String defSemester = "";
    public static String defCourseName = "";
    public static String defCourseStart = "";
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
    
    private static String username;
    private static String password;
    private static boolean loggedin;
    private static boolean dataReceived = false;
    private static boolean edSchedSel = false;
    private static boolean schedSetupSel = false;
    private static boolean logoutSel = false;
    
    private static int clearDate, clearMonth, clearYear;
    private static int counter = 0;
    
    public static DBConnection db = new DBConnection();
    private static InterfaceController ic = new InterfaceController();
    private static Authenticate auth;
    private static int courseSel;
    private static long classEnded = 0;
       
    
    /** Creates a new instance of ApplicationLogic */
    public appController() {
        hr = min = 0;
    }
    
    /* Set to the stubs when testing*/
    public static void setDBConnection(DBConnection temp){
    	db = temp;
    }
    public static void setInterfaceController(InterfaceController temp){
    	ic = temp;
    }
    public static void setAuthenticate(Authenticate temp){
    	auth = temp;
    }
    
    public static void main(String args[])
    {       
//       Calendar now = new GregorianCalendar();
//       now.set(2008, 3, 15, 13, 29);
//       date = now.getTime();
//               
    	appLogin();
        ic.Initiate_MainMenu();
        if(checkClear())
        {
            db.clearDatabase();
        }
        
        checkTimes();
        while(!logoutSel)
        {
            
            
            long newCurrentTime;
            while(!dataReceived)
            {
                dataReceived = ic.facade.menuDataRec();
                edSchedSel = ic.facade.editSchedSelected();
                schedSetupSel = ic.facade.InitSetupSelected();
                logoutSel = ic.facade.logoutSelected();
                //System.out.println("Class end time: " +classEnded);
                //System.out.println("Current time: " +System.currentTimeMillis());
                        
                        
                if(classEnded != 0 && System.currentTimeMillis() - classEnded >= TENMIN)
                {
                  //System.out.println("EXIT");
                  System.exit(0);   
                }
                
                sleep(500);
            }
            newCurrentTime = 0;
            ic.facade.setMenuDataRec(false);
            dataReceived = false;

            if(logoutSel)
            {
                // Logout 
                auth.logout();
                ic.Initiate_Logout();

            }
            else if(edSchedSel)
            {
                appEditSched();
            }
            else if(schedSetupSel)
            {
                setupSched();
            }

            dataReceived = false;
            
           // db.disconnect();
        }
       
    }
    
    public static void setupSched(){
    	ic.facade.launchInitial();
        //Initial Schedule Setup
        while(!ic.facade.schedDataRec())
        {
            dataReceived = ic.facade.schedDataRec();
            sleep(300);
        }
        dataReceived = false;
        ic.facade.setSchedDataRec(false);
        
        db.storeClassInfo(ic.facade.getNewCourseID(), ic.facade.getNewSub(), ic.facade.getNewCourseName(),ic.facade.getNewSemester());
        db.storeClassSched(ic.facade.getNewCourseID(), ic.facade.getNewCourseStart(), ic.facade.getNewCourseEnd(), 
                ic.facade.getNewMonStart(), ic.facade.getNewMonEnd(), ic.facade.getNewTueStart(), ic.facade.getNewTueEnd(), 
                ic.facade.getNewWedStart(), ic.facade.getNewWedEnd(), ic.facade.getNewThuStart(), ic.facade.getNewThuEnd(), 
                ic.facade.getNewFriStart(), ic.facade.getNewFriEnd(), ic.facade.getNewSatStart(), ic.facade.getNewSatEnd());

    }
    public static void appEditSched(){
    	 //Edit Schedule
        ic.Course_Select_Form();

        while(!dataReceived)
        {
            dataReceived = ic.facade.courseSelected();
            sleep(300);
         //   System.out.println("test");
        }

        ic.facade.setCourseSelected(false);
        dataReceived = false;

        courseSel = ic.facade.getSelection();
        getData(courseSel);
        
        ic.Pre_Filled_Form(courseSel,defSub,defCourseName,defSemester,defCourseStart,
                defCourseEnd,defMonStart,defMonEnd,defTueStart,defTueEnd,defWedStart,
                defWedEnd,defThuStart,defThuEnd,defFriStart,defFriEnd,defSatStart,defSatEnd);
        
        while(!dataReceived)
        {
            dataReceived = ic.facade.psDataRec(); 
            sleep(300);
        }
        
        dataReceived = false;
        ic.facade.setPsDataRec(false);

        //System.out.println("Save has been pressed" +ic.edSched.newMonStart);

        db.storeClassSched(ic.facade.getDefCourseID(), ic.facade.getpNewCourseStart(), ic.facade.getpNewCourseEnd(), 
                ic.facade.getpNewMonStart(), ic.facade.getpNewMonEnd(), ic.facade.getpNewTueStart(), ic.facade.getpNewTueEnd(), 
                ic.facade.getpNewWedStart(), ic.facade.getpNewWedEnd(), ic.facade.getpNewThuStart(), ic.facade.getpNewThuEnd(), 
                ic.facade.getpNewFriStart(), ic.facade.getpNewFriEnd(), ic.facade.getpNewSatStart(), ic.facade.getpNewSatEnd());


    }
    
    public static void appLogin(){
    	while(!loggedin)
        {           
            ic.Initiate_Login_Form();            
            
             do
             {
                 dataReceived = ic.facade.dataReceived();
                 sleep(300);
                 
             }while(!dataReceived);
             ic.facade.setLogDataRec(false);
             dataReceived = false;
             username = ic.facade.getUsername();
             password = ic.facade.getPassword();

             
             auth = new Authenticate(username,password);
             if(auth.validate_Login()){
                 loggedin = true;
                 auth.logout();
                 db.connect(username,password);
             }
             
               
             if(!loggedin){
                 ic.Initiate_IncorrectLogin();
                 counter++;
                 while(!dataReceived)
                 {
                     dataReceived = ic.facade.getAck();
                     System.out.println("in");
                 }
                 dataReceived = false;
                 ic.facade.setAck(false);
                 
             }
             if(counter >= 3){
                
                 ic.passwordLock();
                 while(!dataReceived)
                 {
                     dataReceived = ic.facade.getAck();
                     
                 }
                 System.exit(0);
              }
        }
    }
    public static boolean checkClear()
    {
        ArrayList<String> endDates = db.getEndDates();
        Calendar endCal = new GregorianCalendar();
        Calendar now = Calendar.getInstance();
        
        for(int i = 0; i < endDates.size(); i++)
        {
            dateParser(endDates.get(i));
            
            //System.out.println("Day : " +clearDate);
            //System.out.println("Month : " +clearMonth);
            //System.out.println("Year : " +clearYear);

            endCal.set(clearYear + 2000, clearMonth-1, clearDate);
            if(now.compareTo(endCal) <= 0)
               return false;
                
        }
        return true;
                
    }
            
    public static void checkTimes()
    {
        ArrayList<Integer> courseList = db.getCourses();
        
        Calendar tempC = new GregorianCalendar();
        int currentDay = tempC.get(tempC.DAY_OF_WEEK);
        tempC.setTimeInMillis(System.currentTimeMillis());
        //System.out.println("Curr Day: " +currentDay);
        Date fifteenMin;
        Date fiveMin;
        Date endClass;
        
        for(int i = 0; i < courseList.size(); i++)
        {
            boolean isNull = true;
            getData(courseList.get(i).intValue());
            Timer newTimer = new FutureTimer();
            
            if(currentDay == 2 && defMonEnd.compareTo("") != 0)
            {
                timerParser(defMonEnd);
                isNull = false;
            }
            else if(currentDay == 3 && defTueEnd.compareTo("") != 0)
            {
                timerParser(defTueEnd);
                isNull = false;
            }
            else if(currentDay == 4 && defWedEnd.compareTo("") != 0)
            {
                timerParser(defWedEnd);
                isNull = false;
            }
            else if(currentDay == 5 && defThuEnd.compareTo("") != 0)
            {
                timerParser(defThuEnd);
                isNull = false;
            }
            else if(currentDay == 6 && defFriEnd.compareTo("") != 0)
            {
                timerParser(defFriEnd);
                isNull = false;
            }
            
            else if(currentDay == 7 && defSatEnd.compareTo("") != 0)
            {
                
                timerParser(defSatEnd);
                isNull = false;
            }
            
            
            if(!isNull){
                fiveMin = get5BeforeEnd(hr, min);
                newTimer.schedule(popup5min, fiveMin);
                fifteenMin = get15BeforeEnd(hr, min);              
                newTimer.schedule(popup15min, fifteenMin);
                endClass = getEndTime(hr, min);
                newTimer.schedule(endofclass, endClass);
            }
        }   
       
    }
    
    public static void getData(int course)
    {
        defSub = db.fetchCourseSubj(course);
        defSemester = db.fetchCourseSemester(course);
        defCourseName = db.fetchCourseName(course);
        defCourseStart = db.fetchCourseStart(course);
        defCourseEnd = db.fetchCourseEnd(course);
        defMonStart = db.fetchStartMon(course);
        defMonEnd = db.fetchEndMon(course);
        defTueStart = db.fetchStartTue(course);
        defTueEnd = db.fetchEndTue(course);
        defWedStart = db.fetchStartWed(course);
        defWedEnd = db.fetchEndWed(course);
        defThuStart = db.fetchStartThu(course);
        defThuEnd = db.fetchEndThu(course);
        defFriStart = db.fetchStartFri(course);
        defFriEnd = db.fetchEndFri(course);
        defSatStart = db.fetchStartSat(course);
        defSatEnd = db.fetchEndSat(course);           
    }
    
    
    public static void sleep(int milli)
    {
          try { 
           Thread.sleep(milli);
        } catch (InterruptedException ex) {
           Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    public static void LogIn()
    {      
        if(db.connect(username,password) == 0)
            loggedin = true;
        else
            loggedin = false;        
    }
    
    public static DBConnection getCon()
    {
        return db;
    }
    
    
    private static TimerTask dbClear = new TimerTask()
    {
        public void run()
        {
           db.clearDatabase();
        }
    };
    
    private static TimerTask popup15min = new TimerTask()
    {
        public void run()
        {
            ic.facade.FifteenMinWarning();
        }
    };
	
    private static TimerTask popup5min = new TimerTask()
    {
        public void run()
        {
            ic.facade.FiveMinWarning();
        }
    };
    
    
    private static TimerTask endofclass = new TimerTask()
    {
        public void run()
        {
            ic.facade.endClassWarning();
            classEnded = System.currentTimeMillis();
        }
    };
    
    
    private static TimerTask systemExit = new TimerTask()
    {
        public void run()
        {
            System.exit(0);
        }
    };
    
       
    public void setTime(int year, int month, int date, int hours, int mins)
    {
        setRun.set(year, month, date, hours, mins);
    }
    
    public Date getTime()
    {
        return setRun.getTime();
    }
    
    public static long getTimeMillis()
    {
        return setRun.getTimeInMillis();
    }
    
    public static void timerParser(String timer)
    {
        hr = Integer.parseInt(timer.substring(0,2));
        min = Integer.parseInt(timer.substring(3,5));
    }
    public static void dateParser(String timer)
    {
        
        clearMonth = Integer.parseInt(timer.substring(0,2));
        clearDate = Integer.parseInt(timer.substring(3,5));
        clearYear = Integer.parseInt(timer.substring(6,8));
    }
    
    public int returnHr()
    {
        return hr;
    }
    
    public int returnMin()
    {
        return min;
    }
    
    public static Date getEndTime(int hrs, int mins)
    {
        int years, months, dates, dayOfWeek;
        
        Calendar tempC = new GregorianCalendar();
        
        tempC.setTimeInMillis(System.currentTimeMillis());
        
        years = tempC.get(tempC.YEAR);
        months = tempC.get(tempC.MONTH);
        dates = tempC.get(tempC.DATE);
        dayOfWeek = tempC.get(tempC.DAY_OF_WEEK);
        tempC.set(years, months, dates, hrs, mins - 1, 1);
        // System.out.println(dayWeek);
        return tempC.getTime();
    }
    
    public static void setSemesterClear(int year, int month, int date, int hours, int mins)
    {
        autoClear.set(year, month, date, hours, mins);
        date2 = autoClear.getTime();
    }
    
    public Date getSemesterClear()
    {
        return autoClear.getTime();
    }
    
    public static Date get15BeforeEnd(int hrs, int mins)
    {
        int years, months, dates, dayOfWeek; 
        
        Calendar tempC = new GregorianCalendar();
        
        tempC.setTimeInMillis(System.currentTimeMillis());
        
        years = tempC.get(tempC.YEAR);
        months = tempC.get(tempC.MONTH);
        dates =  tempC.get(tempC.DATE);
        dayOfWeek = tempC.get(tempC.DAY_OF_WEEK);
        
        tempC.set(years, months, dates, hrs, mins - 15, 1);
        
        return tempC.getTime();
    }
    
    public static Date get5BeforeEnd(int hrs, int mins)
    {
        int years, months, dates, dayOfWeek;
        
        Calendar tempC = new GregorianCalendar();
        
        tempC.setTimeInMillis(System.currentTimeMillis());
        
        years = tempC.get(tempC.YEAR);
        months = tempC.get(tempC.MONTH);
        dates = tempC.get(tempC.DATE);
        dayOfWeek = tempC.get(tempC.DAY_OF_WEEK);
        tempC.set(years, months, dates, hrs, mins - 5, 1);
        // System.out.println(dayWeek);
        return tempC.getTime();
    }
    
    public void autoExit()
    {
        timer.schedule(systemExit, date);
    }
    
    public void autoClear()
    {
        timer.schedule(dbClear, date2);
    }
}
