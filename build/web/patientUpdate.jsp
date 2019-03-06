<%--/***********************************************************************
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
--%>

<%@page import="Business.Patient"%>
<%@page import="Business.Appointment"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chatt Dentistry :: Patient Update</title>
    </head>
    <header>
        <h1 style="text-align:center;">Update Information</h1>
    </header>
    <body>
        <div id="leftcolumn" >
            <ul>
                <li><a href="patientInfo.jsp">Patient Information</a></li>
            </ul>
        </div>
        <div id="rightcolumn" >
            <% Patient c1 = (Patient)request.getSession().getAttribute("patient"); %>
            <form name ="patientUpdate" method ="POST" action ="patUpdateServlet">
                <table id="t01">
                    <tr>
                        <td>First Name</td>
                        <td>
                            <input type ="text" name ="fname" value = <%= c1.getFirstName() %> />
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td>
                            <input type ="text" name ="lname" value = <%= c1.getLastName() %> />
                        </td> 
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>
                            <input type ="text" name ="email" value = <%= c1.getEmail() %> />
                        </td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td>
                            <input type ="text" name ="address" value = <%= c1.getAddress() %> />
                        </td> 
                    </tr>
                    <tr>
                        <td>Insurance Company</td>
                        <td>
                            <input type ="text" name ="insco" value = <%= c1.getInsuranceCo() %> />
                        </td> 
                    </tr>
                    <tr>
                        <td>
                            <input type ="submit" name ="submitbtn" value ="Submit"/>
                        </td>
                        <td>
                            <input type ="reset" name ="clearbtn" value ="Clear"/>
                        </td>
                    </tr>
                </table>
            </form>
            <img src="dentist.jpg" alt="Dentist Image" height ="500" width ="560"/>
        </div>
    </body>
</html>
