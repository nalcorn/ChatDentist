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
 *This is the Patient object
 */
public class Patient {
    /*Properties
    *******************************************************************/
    private String driver = "jdbc:mysql://localhost:3306/DentistOffice?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String pass = "linux";
    private String patientId,
                   password,
                   firstName,
                   lastName,
                   address,
                   email,
                   insuranceCo;

    /**
     * This is the appointment associated with the Patient Object.
     */
    public Appointment patientAppt = new Appointment();
    
    
    /*Constructors
    *******************************************************************/

    /**
     * Default Constructor makes Patient Object and does not make values for 
     * any of the properties
     */
    
    public Patient(){
        setPassword("");
    }
    
    /**
     *Loading constructor that takes in arguments and assigns them to the values
     * @param patId
     * @param pass
     * @param fName
     * @param lName
     * @param addr
     * @param email
     * @param insCo
     */
    public Patient(String patId, String pass, String fName, String lName, 
                   String addr, String email, String insCo){
        setPatientId(patId);
        setPassword(pass);
        setFirstName(fName);
        setLastName(lName);
        setAddress(addr);
        setEmail(email);
        setInsuranceCo(insCo);
    }
    
    /*Setters
    *******************************************************************/

    /**
     * Sets the Patient Object's Patient Id parameter.
     * @param patId
     */
    
    public void setPatientId(String patId){
        this.patientId = patId;
    }

    /**
     * Sets the Patient Object's Password parameter.
     * @param pass
     */
    public void setPassword(String pass){
        this.password = pass;
    }

    /**
     * Sets the Patient Object's First Name parameter.
     * @param fName
     */
    public void setFirstName(String fName){
        this.firstName = fName;
    }

    /**
     * Sets the Patient Object's Last Name parameter.
     * @param lName
     */
    public void setLastName(String lName){
        this.lastName = lName;
    }

    /**
     * Sets the Patient Object's Address parameter.
     * @param addr
     */
    public void setAddress(String addr){
        this.address = addr;
    }

    /**
     * Sets the Patient Object's Email parameter.
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Sets the Patient Object's Insurance Company parameter.
     * @param insCo
     */
    public void setInsuranceCo(String insCo){
        this.insuranceCo = insCo;
    }
    
    
    /*Getters
    *******************************************************************/

    /**
     * returns the Patient Object's Patient Id parameter.
     * @return
     */
    public String getPatientId(){
        return this.patientId;
    }

    /**
     * returns the Patient Object's Password parameter.
     * @return
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * returns the Patient Object's First Name parameter.
     * @return
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * returns the Patient Object's Last Neme parameter.
     * @return
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * returns the Patient Object's Address parameter.
     * @return
     */
    public String getAddress(){
        return this.address;
    }

    /**
     * returns the Patient Object's Email parameter.
     * @return
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * returns the Patient Object's Insurance Company parameter.
     * @return
     */
    public String getInsuranceCo(){
        return this.insuranceCo;
    }
    
    
    /*Methods
    *******************************************************************/

    /**
     * Procedure to fill Patient Object's fields from database.
     * @param patientId
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    
    public void selectDB(String patientId) 
            throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery (
                    "SELECT * from patients WHERE patId = '"+patientId+"';");
            while(resultSet.next()){
                setPatientId(resultSet.getString("patId"));
                setPassword(resultSet.getString("passwd"));
                setFirstName(resultSet.getString("firstName"));
                setLastName(resultSet.getString("lastName"));
                setAddress(resultSet.getString("addr"));
                setEmail(resultSet.getString("email"));
                setInsuranceCo(resultSet.getString("insCo"));
            }
            this.patientAppt.selectPatApptDb(patientId);
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }
    
    /**
     * Procedure to insert Patient Object's fields into database.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertDb() 
            throws SQLException, ClassNotFoundException{
       Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT into patients VALUES('"
                    +getPatientId()+"','"+getPassword()+"','"
                    +getFirstName()+"','"+getLastName()+"','"
                    +getAddress()+"','"+getEmail()+"','"
                    +getInsuranceCo()+"')");
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        } 
    }
    
    /**
     *  Procedure to update Patient Object's fields from database.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void updateDb() 
            throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            statement.executeUpdate("UPDATE patients "+
                    "SET passwd='"+getPassword()+
                    "', firstName='"+getFirstName()+
                    "', lastName='"+getLastName()+
                    "', addr='"+getAddress()+
                    "', email='"+getEmail()+
                    "', insCo='"+getInsuranceCo()+
                    "' WHERE patId='"+getPatientId()+"'");
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        } 
    }
    
    /**
     * Procedure to delete Patient Object's fields from database.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void deleteDb() 
            throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
             Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery (
                    "DELETE * from patients WHERE patId = '"+
                    getPatientId()+"';");
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
        String output = "Patient ID is: "+getPatientId()+"\n"+
              "Dentist name is: "+getFirstName()+" "+getLastName()+"\n"+
              "Dentist email is: "+getEmail()+"\n"+
              "Dentist office is: "+getAddress()+"\n";
        return output + patientAppt.toString();
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
        Patient d1 = new Patient();
        d1.selectDB("a900");
        System.out.println(d1.toString());
        
    }
}
