/*
 * DBConnection.java
 *
 * Created on April 7, 2008, 11:40 PM
 *
 
 */

package my.PSM.PSM_Storage;

import java.util.ArrayList;

/**
 * @author Luis
 */
public class DBConnection
{
    private String result;
    private MySQLManager myManager;
    
    public void setMyManager(MySQLManager myManager) {
		this.myManager = myManager;
	}

	/** Creates a new instance of DBConnection */
    public DBConnection()
    {
    	myManager = new MySQLManager();
    }
           
    // Connect using known database address
    public int connect(String db, String user, String pw)
    {
        return myManager.connect(db, user, pw);
    }
    
    // Connect using local host as database address
    public int connect(String user,String pw)
    {
        return myManager.connect(user, pw);
    }
    
    public int disconnect()
    {
        return myManager.disconnect();
    }
     
    public int fetchCourseID(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
        return myManager.fetchCourseID(courseID);  
    }
    
    public ArrayList<String> getEndDates()
    {
        return myManager.getEndDates();
    }
    public ArrayList<Integer> getCourses()
    {
        return myManager.getCourses();
    }
    
    public String fetchCourses()
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
    	StringBuffer sb = new StringBuffer();          
        // System.out.print("here");
         // System.out.println("SELECT course_id FROM class100 WHERE course_id = " +courseID +";");
         ArrayList<Integer> list = myManager.getCourses();
         for(int i = 0; i < list.size(); i++)
         {
             
             sb.append(list.get(i));
             sb.append(",");
                    
         }   
    	result = sb.toString();
        return result;
        //String[] courses = result.split(",");
       //return courses;
    }
    
    public String fetchCourseSubj(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
        return myManager.fetchCourseSubj(courseID);
       
    }
    
    public String fetchCourseName(int courseID)
    {
        return myManager.fetchCourseName(courseID);
       
    }
    
    public String fetchCourseSemester(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
        return myManager.fetchCourseSemester(courseID);
       
    }
    
    public String fetchCourseStart(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
        return myManager.fetchCourseStart(courseID);
       
    }
    
    public String fetchCourseEnd(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
       
        return myManager.fetchCourseEnd(courseID);
       
    }
    
    
//    public String fetchAMPM(int courseID)
//    {
//        try{
//            Statement s = myCon.createStatement();
//            s.executeQuery("SELECT am_or_pm FROM class100 WHERE course_id = " +courseID +";");
//            ResultSet res = s.getResultSet();
//            res.next();
//            return res.getString("am_or_pm");
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//            return null;
//        }
//    }
    
    public String fetchStartMon(int courseID)
    {
        return myManager.fetchStartMon(courseID);
    }
    
    public String fetchEndMon(int courseID)
    {
        return myManager.fetchEndMon(courseID);
    }
    
    public String fetchStartTue(int courseID)
    {
        return myManager.fetchStartTue(courseID);
    }
    
    public String fetchEndTue(int courseID)
    {
        return myManager.fetchEndTue(courseID);
    }
    
    public String fetchStartWed(int courseID)
    {
    	return myManager.fetchStartWed(courseID);
    }
    
    public String fetchEndWed(int courseID)
    {
    	return myManager.fetchEndWed(courseID);
    }
    
    
    public String fetchStartThu(int courseID)
    {
        return myManager.fetchStartThu(courseID);
    }
    
    public String fetchEndThu(int courseID)
    {
        return myManager.fetchEndThu(courseID);
    }
    
    public String fetchStartFri(int courseID)
    {
    	return myManager.fetchStartFri(courseID);
    }
    
    public String fetchEndFri(int courseID)
    {
        return myManager.fetchEndFri(courseID);
    }
    
    
    public String fetchStartSat(int courseID)
    {
        return myManager.fetchStartSat(courseID);
    }
    
    public String fetchEndSat(int courseID)
    {
        
        return myManager.fetchEndSat(courseID);
    }
    
    public int storeClassInfo(int courseID, String courseSubj, String courseName, String semester)
    {
        return myManager.storeClassInfo(courseID, courseSubj, courseName, semester);
    }
    
    public int storeClassSched(int courseID, String startDate, String endDate, String startMon, String endMon,
            String startTue, String endTue, String startWed, String endWed, String startThu, String endThu, 
            String startFri, String endFri, String startSat, String endSat)
    {
        return myManager.storeClassSched(courseID, startDate, endDate, startMon, endMon, startTue, endTue, startWed, endWed, startThu, endThu, startFri, endFri, startSat, endSat);
        
    }
    
    public void clearDatabase()
    {
        myManager.clearDatabase();
    }
    
    public int createClassTable()
    {
       return myManager.createClassTable();
                       
    }
    
//    public void init()
//    {
//        try
//        {
//          myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDatabase","root","luis2101");
//        } catch (SQLException ex)
//        {
//            System.out.println("Cannot connect to Database");
//            ex.printStackTrace();
//        }
//         
//    }
    
}


// Database Scripts:

//CREATE TABLE Class1(
//    course_id INT UNSIGNED NOT NULL,
//    course_subject VARCHAR (20),
//    course_name VARCHAR (20),
//
//    semester VARCHAR (20),
//    start_date VARCHAR (20),
//    end_date VARCHAR (20),
//
//    am_or_pm VARCHAR (5),
//    start_mon VARCHAR (20),
//    end_mon VARCHAR (20),
//    start_tue VARCHAR (20),
//    end_tue VARCHAR (20),
//    start_wed VARCHAR (20),
//    end_wed VARCHAR (20),
//    start_thu VARCHAR (20),
//    end_thu VARCHAR (20),
//    start_fri VARCHAR (20),
//    end_fri VARCHAR (20),
//    start_sat VARCHAR (20),
//    end_sat VARCHAR (20),
//
//
//    PRIMARY KEY (course_id)
//);

//    INSERT INTO class1
//        VALUES(4010,'CEN','Software Engineering','Spring 2008','01-02-08','04-20-08','am','12:00','12:50','null','null',
//               '12:00','12:50','null','null','12:00','12:50','null','null')



