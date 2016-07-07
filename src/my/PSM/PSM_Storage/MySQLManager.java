package my.PSM.PSM_Storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLManager {
	private Connection myCon;
	private String marcosDb;
	
	public MySQLManager(){
		myCon = null;
		marcosDb = "jdbc:mysql://127.0.0.1:3306/mydb";
	}
	
	public int connect(String db, String user, String pw){
		try{
	           // DriverManager.getDriver("com.mysql.jdbc.Driver");
	            Class.forName("com.mysql.jdbc.Driver");
	            myCon = DriverManager.getConnection(db,user,pw);
	        } 
	        // Launch Message Window Here
	        catch (Exception e){
	            e.printStackTrace();
	            return -1;              // -1 = Fail State
	        }
	        
	        return 0;
	}
	
	public int connect(String user,String pw){
		return connect(marcosDb, user, pw);
	}
	
	public int disconnect()
    {
        if(myCon != null){
            try{
                myCon.close();
               
            }
            catch(Exception e){
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
    }
	public int fetchCourseID(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
        try{
            Statement s = myCon.createStatement();          
            // System.out.println("SELECT course_id FROM class100 WHERE course_id = " +courseID +";");
            s.executeQuery("SELECT course_id FROM class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();             // Move to first row!
            return res.getInt("course_id");
                   
        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
       
    }
	
	public ArrayList<String> getEndDates(){
		ArrayList<String> endDates = new ArrayList<String>();
        
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT end_date FROM class100");
            ResultSet res = s.getResultSet();
            
            while(res.next())
            {
                endDates.add(res.getString("end_date"));       
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return endDates;
	}
	
	public ArrayList<Integer> getCourses(){
		ArrayList<Integer> courseList = new ArrayList<Integer>();
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT course_id FROM class100");
            ResultSet res = s.getResultSet();
            
            while(res.next())
            {
                courseList.add(res.getInt("course_id"));       
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }	
        return courseList;
	}
	
	public String fetchCourseSubj(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
        try{
            Statement s = myCon.createStatement();          
            // System.out.println("SELECT course_id FROM class100 WHERE course_id = " +courseID +";");
            s.executeQuery("SELECT course_subject FROM class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();             // Move to first row!
            return res.getString("course_subject");
                   
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
       
    }
    
    public String fetchCourseName(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
        try{
            Statement s = myCon.createStatement();          
            // System.out.println("SELECT course_id FROM class100 WHERE course_id = " +courseID +";");
            s.executeQuery("SELECT course_name FROM class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();             // Move to first row!
            return res.getString("course_name");
                   
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
       
    }
    
    public String fetchCourseSemester(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
        try{
            Statement s = myCon.createStatement();          
            // System.out.println("SELECT course_id FROM class100 WHERE course_id = " +courseID +";");
            s.executeQuery("SELECT semester FROM class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();             // Move to first row!
            return res.getString("semester");
                   
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
       
    }
    
    public String fetchCourseStart(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
        try{
            Statement s = myCon.createStatement();          
            // System.out.println("SELECT course_id FROM class100 WHERE course_id = " +courseID +";");
            s.executeQuery("SELECT start_date FROM class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();             // Move to first row!
            return res.getString("start_date");
                   
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
       
    }
    
    public String fetchCourseEnd(int courseID)
    {
        // SELECT * FROM example WHERE name='Sandy Smith'
       
        try{
            Statement s = myCon.createStatement();          
            // System.out.println("SELECT course_id FROM class100 WHERE course_id = " +courseID +";");
            s.executeQuery("SELECT end_date FROM class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();  
            
            String courseEnd = res.getString("end_date");// Move to first row!
            return courseEnd;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
       
    }
    
    public String fetchStartMon(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT start_mon FROM Class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();
            return res.getString("start_mon");
            // hh:mm
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
            return null;
        }
    }
    
    public String fetchEndMon(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT end_mon FROM Class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();
            return res.getString("end_mon");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String fetchStartTue(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT start_tue FROM Class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();
            return res.getString("start_tue");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
            return "";
        }
    }
    
    public String fetchEndTue(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT end_tue FROM Class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();
            return res.getString("end_tue");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String fetchStartWed(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT start_wed FROM Class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();
            return res.getString("start_wed");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String fetchEndWed(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT end_wed FROM Class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();
            return res.getString("end_wed");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    
        public String fetchStartThu(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT start_thu FROM Class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();
            return res.getString("start_thu");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String fetchEndThu(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT end_thu FROM Class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();
            return res.getString("end_thu");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String fetchStartFri(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT start_fri FROM Class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();
            return res.getString("start_fri");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String fetchEndFri(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeQuery("SELECT end_fri FROM Class100 WHERE course_id = " +courseID +";");
            ResultSet res = s.getResultSet();
            res.next();
            return res.getString("end_fri");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    
        public String fetchStartSat(int courseID)
    {
        try{
            Statement s = myCon.createStatement();
            ResultSet res = s.executeQuery("SELECT start_sat FROM Class100 WHERE course_id = " +courseID +";");
            
            res.next();
            return res.getString("start_sat");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String fetchEndSat(int courseID)
    {
        
        try{
            Statement s = myCon.createStatement();
            
            ResultSet res = s.executeQuery("SELECT end_sat FROM Class100 WHERE course_id = " +courseID +";");
            
            res.next();
            String end = res.getString("end_sat");
           
            return end;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public int storeClassInfo(int courseID, String courseSubj, String courseName, String semester)
    {
        try{
            Statement s = myCon.createStatement();
           // System.out.println("INSERT INTO Class100 (course_id, course_subject, course_name, semester)" +
           //         " VALUES ( "+courseID +", '" +courseSubj +"', " +courseName +"', '" +semester +"')");
            s.executeUpdate("INSERT INTO Class100 (course_id, course_subject, course_name, semester)" +
                    " VALUES ( '"+courseID +"', '" +courseSubj +"', '" +courseName +"', '" +semester +"')");
            

        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
    
    public int storeClassSched(int courseID, String startDate, String endDate, String startMon, String endMon,
            String startTue, String endTue, String startWed, String endWed, String startThu, String endThu, 
            String startFri, String endFri, String startSat, String endSat)
    {
        try{
            Statement s = myCon.createStatement();
            s.executeUpdate("UPDATE Class100 SET " +
                    "start_date = '" +startDate +"', end_date = '" +endDate +"', start_mon =  '" 
                    +startMon +"', end_mon = '" +endMon + "', start_tue = '" +startTue +"', end_tue = '" +endTue 
                    +"', start_wed = '" +startWed +"', end_wed = '" +endWed +"', start_thu =  '" +startThu 
                    + "', end_thu = '" +endThu +"', start_fri = '" +startFri +"', end_fri = '" +endFri 
                    +"', start_sat =  '" +startSat +"', end_sat = '" +endSat
                    +"' WHERE course_id = '" +courseID + "';");
        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
        
    }
    
    public void clearDatabase()
    {
        try{
            Statement s = myCon.createStatement();
            s.execute("DELETE FROM class100;");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public int createClassTable()
    {
       try{ 
        Statement s = myCon.createStatement();
        s.executeUpdate("DROP TABLE IF EXISTS Class100");
        s.executeUpdate(
                        "CREATE TABLE Class100("
                            + "course_id INT UNSIGNED NOT NULL,"
                            + "course_subject VARCHAR (20),"
                            + "course_name VARCHAR (20),"
                            + "semester VARCHAR (20),"
                            + "start_date VARCHAR (20),"
                            + "end_date VARCHAR (20),"
//                            + "am_or_pm VARCHAR (5),"
                            + "start_mon VARCHAR (20),"
                            + "end_mon VARCHAR (20),"
                            + "start_tue VARCHAR (20),"
                            + "end_tue VARCHAR (20),"
                            + "start_wed VARCHAR (20),"
                            + "end_wed VARCHAR (20),"
                            + "start_thu VARCHAR (20),"
                            + "end_thu VARCHAR (20),"
                            + "start_fri VARCHAR (20),"
                            + "end_fri VARCHAR (20),"
                            + "start_sat VARCHAR (20),"
                            + "end_sat VARCHAR (20),"
                            + "PRIMARY KEY (course_id))");
        s.close();
       }
       catch(Exception e){
           e.printStackTrace();
           return -1;
       }
       return 0;
                       
    }
}
