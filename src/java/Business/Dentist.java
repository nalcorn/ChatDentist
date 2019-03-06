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
import java.util.ArrayList;
import java.util.List;

/**
 *This is the Dentist object
 */
public class Dentist {
    /*Properties
    *******************************************************************/
    private String driver = "jdbc:mysql://localhost:3306/DentistOffice?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String pass = "linux";
    private String dentistId,
                   password,
                   firstName,
                   lastName,
                   email,
                   office;
    private int count;

    /**
     * List of Appointment Objects that have Dentist Object as performing them.
     */
    public List<Appointment> list = new ArrayList<>();    
    
    /*Constructors
    *******************************************************************/

    /**
     * Default Constructor makes appointment object and does not make values for 
     * any of the properties     */
    
    public Dentist(){
        setPassword("");
        count = 0;
    }
    
    /**
     *Loading constructor that takes in arguments and assigns them to the values
     * @param dentId
     * @param pass
     * @param fName
     * @param lName
     * @param office
     * @param email
     */
    public Dentist(String dentId, String pass, String fName, String lName, 
                   String office, String email){
        setDentistId(dentId);
        setPassword(pass);
        setFirstName(fName);
        setLastName(lName);
        setOffice(office);
        setEmail(email);
        count = 0;
    }
    
    
    /*Setters
    *******************************************************************/

    /**
     * Sets the Dentist Object's Dentist Id time parameter.
     * @param dentId
     */
    
    public void setDentistId(String dentId){
        this.dentistId = dentId;
    }

    /**
     * Sets the Dentist Object's Password time parameter.
     * @param pass
     */
    public void setPassword(String pass){
        this.password = pass;
    }

    /**
     * Sets the Dentist Object's First Name time parameter.
     * @param fName
     */
    public void setFirstName(String fName){
        this.firstName = fName;
    }

    /**
     * Sets the Dentist Object's Last Name time parameter.
     * @param lName
     */
    public void setLastName(String lName){
        this.lastName = lName;
    }

    /**
     * Sets the Dentist Object's Email time parameter.
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Sets the Dentist Object's Office time parameter.
     * @param office
     */
    public void setOffice(String office){
        this.office = office;
    }
    
    
    /*Getters
    *******************************************************************/

    /**
     * returns the Dentist Object's Dentist Id parameter.
     * @return
     */
    public String getDentistId(){
        return this.dentistId;
    }

    /**
     * returns the Dentist Object's Password parameter.
     * @return
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * returns the Dentist Object's First Name parameter.
     * @return
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * returns the Dentist Object's Last Name parameter.
     * @return
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * returns the Dentist Object's Email parameter.
     * @return
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * returns the Dentist Object's Office parameter.
     * @return
     */
    public String getOffice(){
        return this.office;
    }

    /**
     * returns the Dentist Object's list of appointments  parameter.
     * @return
     */
    public int getCount(){
        return this.count;
    }
    
    
    /*Methods
    *******************************************************************/

    /**
     * Procedure to fill Dentist Object's fields from database.
     * @param dentId
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    
    public void selectDB(String dentId) 
            throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery (
                    "SELECT * from dentists WHERE id = '"+dentId+"';");
            while(resultSet.next()){
                setDentistId(resultSet.getString("id"));
                setPassword(resultSet.getString("passwd"));
                setFirstName(resultSet.getString("firstName"));
                setLastName(resultSet.getString("lastName"));
                setOffice(resultSet.getString("office"));
                setEmail(resultSet.getString("email"));
            }
            selectAppointments();
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }
    
    /**
     * Procedure adds appointments to the appointment list parameter.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void selectAppointments() 
            throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            count = 0;
            list.clear();
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery (
                    "SELECT * from appointments WHERE dentId ='"
                            +getDentistId()+"';");
            while(resultSet.next()){
                Appointment a1 = new Appointment();
                a1.selectDb(resultSet.getString("apptDateTime"),
                            resultSet.getString("patId"));
                list.add(a1);
                count++;
            }
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }
    
    /**
     * Procedure to insert Dentist Object's values into the database.
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
                    +getDentistId()+"','"+getPassword()+"','"
                    +getFirstName()+"','"+getLastName()+"','"
                    +getEmail()+"','"+getOffice()+"')");
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        } 
    }
    
    /**
     * Procedure updates the database with the current values of the Dentist 
     * Object.
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
            statement.executeUpdate("UPDATE dentists "+
                    "SET passwd ='"+getPassword()+
                    "', firstName ='"+getFirstName()+
                    "', lastName ='"+getLastName()+
                    "', email ='"+getEmail()+
                    "', office ='"+getOffice()+
                    "' WHERE id='"+getDentistId()+"'");
            selectAppointments();
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        } 
    }
    
    /**
     * Procedure deletes the values in the Dentist Object from the database.
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
                    "DELETE * from dentists WHERE id = '"+
                    getDentistId()+"';");
            selectAppointments();
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
        return"Dentist ID is: "+getDentistId()+"\n"+
              "Dentist name is: "+getFirstName()+" "+getLastName()+"\n"+
              "Dentist email is: "+getEmail()+"\n"+
              "Dentist office is: "+getOffice()+"\n";
    }
    
    /*Main Tester
    *******************************************************************/    

    /**
     * Tester for the Dentist Object.
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException
     */
        
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Dentist d1 = new Dentist();
        d1.selectDB("D201");
        System.out.println(d1.toString());
        
    }
}
