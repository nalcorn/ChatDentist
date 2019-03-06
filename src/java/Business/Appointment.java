/***********************************************************************
 * lab 8
 * Class: Java III
 * Quarter: Fall 2015
 * Instructor: Ron Enz
 * Description:  Dentist Office Lab
 * Due: 02/04/2016
 * @author Nicholas Alcorn
 * @version 1.0
 * 
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source.
 * 3. I have not given my code to any student.
 * 
 ***********************************************************************/
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *This is the Appointment object
 */
public class Appointment {
    /*Properties
    *******************************************************************/
    private String driver = "jdbc:mysql://localhost:3306/DentistOffice?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String pass = "linux";
    private String apptDateTime = "",
                   patientId,
                   dentistId,
                   procedureCode,
                   procedureName,
                   procedureDescription;
    private boolean isEmpty;
    
    
    /*Constructors
    *******************************************************************/

    /**
     * Default Constructor makes appointment object and does not make values for 
     * any of the properties
     */
    public Appointment(){
        isEmpty = true;
    }
    /**
     *Loading constructor that takes in arguments and assigns them to the values
     * @param apptDateTime the time of the appointment
     * @param patientId the ID for the patient getting the procedure
     * @param dentistId the ID for the dentist performing the procedure
     * @param procedureCode the code in the procedure table
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Appointment(String apptDateTime, String patientId, String dentistId,
                       String procedureCode) 
                       throws SQLException, ClassNotFoundException{
        this.apptDateTime = apptDateTime;
        this.patientId = patientId;
        this.dentistId = dentistId;
        this.procedureCode = procedureCode;
        selectProcDb(procedureCode);
        if(apptDateTime.equals("")){
            isEmpty = false;
        }
    }
    
    /*Setters
    *******************************************************************/

    /**
     *Sets the Appointment Object's appointment time parameter.
     * @param aptTime
     */
    public void setApptDateTime(String aptTime){
        this.apptDateTime = aptTime;
    }

    /**
     *Sets the Appointment Object's patient ID parameter.
     * @param patientId
     */
    public void setPatientId(String patientId){
        this.patientId = patientId;
    }

    /**
     *Sets the Appointment Object's Dentist ID parameter.
     * @param dentistId
     */
    public void setDentistId(String dentistId){
        this.dentistId = dentistId;
    }

    /**
     *Sets the Appointment Object's procedure code parameter.
     * Also updates the procedure name and description from this code.
     * @param procCode
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void setProcedureCode(String procCode) 
            throws SQLException, ClassNotFoundException{
        this.procedureCode = procCode;
        selectProcDb(procCode);
    } 
    
    /*Getters
    *******************************************************************/

    /**
     *returns the Appointment Object's appointment time parameter.
     * @return
     */
    public String getApptDateTime(){
        return this.apptDateTime;
    }

    /**
     *returns the Appointment Object's patient ID parameter.
     * @return
     */
    public String getPatientId(){
        return this.patientId;
    }

    /**
     *returns the Appointment Object's dentist ID parameter.
     * @return
     */
    public String getDentistId(){
        return this.dentistId;
    }

    /**
     *returns the Appointment Object's procedure code parameter.
     * @return
     */
    public String getProcedureCode(){
        return this.procedureCode;
    }

    /**
     *returns the Appointment Object's procedure name parameter.
     * @return
     */
    public String getProcedureName(){
        return this.procedureName;
    }

    /**
     *returns the Appointment Object's procedure description parameter.
     * @return
     */
    public String getProcedureDescription(){
        return this.procedureDescription;
    }
    
    /**
     *returns True if the Appointment Object has an associated appointment.
     * @return
     */
    public boolean hasAppt(){
        return !this.isEmpty;
    }
    
    
    /*Database Methods
    *******************************************************************/

    /**
     * Procedure to fill Appointment Object's fields from database.
     * @param patientId
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void selectPatApptDb(String patientId) 
            throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery (
                    "SELECT * from appointments WHERE patId = '"+patientId+"';");
            while(resultSet.next()){
                setApptDateTime(resultSet.getString("ApptDateTime"));
                setPatientId(resultSet.getString("patId"));
                setDentistId(resultSet.getString("dentId"));
                setProcedureCode(resultSet.getString("procCode"));
            }
            if(!apptDateTime.equals("")){
                isEmpty = false;
            }
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }
    
    /**
     * Procedure to fill Appointment Object's fields from database.
     * @param apptDateTime
     * @param patId
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void selectDb(String apptDateTime, String patId) 
            throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery (
                    "SELECT * from appointments WHERE apptDateTime = '"
                            +apptDateTime+"' and patId = '"+patId+"';");
            while(resultSet.next()){
                setApptDateTime(resultSet.getString("ApptDateTime"));
                setPatientId(resultSet.getString("patId"));
                setDentistId(resultSet.getString("dentId"));
                setProcedureCode(resultSet.getString("procCode"));
            }
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }

    /**
     * Procedure to fill Appointment objects fields from database.
     * @param procCode
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void selectProcDb(String procCode) 
            throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery (
                    "SELECT procName, procDesc from procedures WHERE procCode LIKE '"+
                    procCode+"';");
            while(resultSet.next()){
                this.procedureName = resultSet.getString("procName");
                this.procedureDescription = resultSet.getString("procDesc");
            }
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }

    /**
     * Inserts the appointment object into the database.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void insertApptDb() 
            throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT into appointments VALUES('"
                    +getApptDateTime()+"','"+getPatientId()+"','"
                    +getDentistId()+"','"+getProcedureCode()+"')");
            if(!apptDateTime.equals("")){
                isEmpty = false;
                System.out.println(isEmpty);
            }
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }

    
    /**
     * Updates the database with the Appointment Object's current values.
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void updateApptDb() 
            throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            statement.executeUpdate("UPDATE appointments "+
                    "SET apptDateTime='"+getApptDateTime()+
                    "', dentId='"+getDentistId()+
                    "', procCode='"+getProcedureCode()+
                    "' where patId='"+getPatientId()+"'");
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }

     /**
     * Deletes the entry in the database that matches the values of the 
     * Appointment Object.
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void deleteApptDb() 
            throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            statement.executeUpdate (
                    "DELETE from appointments WHERE patId = '"
                            +getPatientId()+"';");
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }

    /**
     * Converts the Appointment object to a readable String.
     */
    public String toString(){
        return"Appointment Date Time is: "+getApptDateTime()+"\n"+
              "Dentist id is: "+getDentistId()+"\n"+
              "patient id is: "+getPatientId()+"\n"+
              "procedure code is: "+getProcedureCode()+"\n"+
              "Description is: "+getProcedureDescription()+"\n"+
              "procedure is: "+getProcedureName()+"\n";
    }
    /*Main Tester
    *******************************************************************/

    /**
     * Tester for Appointment Object.
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Appointment a1 =new Appointment();
        a1.selectPatApptDb("A909");
        System.out.println(a1.toString());
    }
}
