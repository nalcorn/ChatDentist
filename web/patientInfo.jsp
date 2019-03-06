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
        <title>Chatt Dentistry :: Patient Information</title>
    </head>
    <header>
        <h1 style="text-align:center;">Welcome to Chatt Dentistry</h1>
    </header>
    <body>
        <% Patient c1 = (Patient)request.getSession().getAttribute("patient"); %>
        <div id="leftcolumn" >
            
                <li><a href="index.jsp">Home</a></li>
                <li><a href="patientUpdate.jsp">Update Information</a></li>
                <% if(c1.patientAppt.hasAppt()){ %>
                    <li><a href="patientChangeApt.jsp">Change Appointment</a></li>
                <% }else{ %>
                    <li><a href="patientMakeApt.jsp">Make Appointment</a></li>
                <% } %>
        </div>
        <div id="rightcolumn" >
            <h1>Welcome <%= c1.getFirstName() %> <%=c1.getLastName() %></h1>
            <br>
            <br>
            <h2>Address: <%=c1.getAddress() %></h2>
            <h2>Email: <%=c1.getEmail() %></h2>
            <h2>Insurance Company: <%= c1.getInsuranceCo() %></h2>
            <br>
            <br>
            <h2>Next Appointment:</h2>
            <% if(c1.patientAppt.hasAppt()){ %>
                <table id="t01">
                    <tr>
                        <td>Appointment Time:</td>
                        <td><%= c1.patientAppt.getApptDateTime() %></td>
                    </tr> 
                    <tr>
                        <td>Dentist ID:</td>
                        <td><%= c1.patientAppt.getDentistId() %></td>
                    </tr>
                    <tr>
                        <td>Procedure Code:</td>
                        <td><%= c1.patientAppt.getProcedureCode() %></td>
                    </tr>
                    <tr>
                        <td>Procedure Name:</td>
                        <td><%= c1.patientAppt.getProcedureName() %></td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td><%= c1.patientAppt.getProcedureDescription() %></td>
                    </tr>
                    <tr><td style="line-height:10px;" colspan=3>&nbsp;</td></tr>
                    <tr><td style="line-height:10px;" colspan=3>&nbsp;</td></tr>
                </table>
            <% }else{ %>
                <h2> There are no current appointments</h2>
            <% } %>
            <img src="dentist.jpg" alt="Dentist Image" height ="500" width ="560"/>
        </div>
    </body>
</html>
