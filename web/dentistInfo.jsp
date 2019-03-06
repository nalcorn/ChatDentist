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

<%@page import="Business.Dentist"%>
<%@page import="Business.Appointment"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chatt Dentistry :: Dentist Information</title>
    </head>
    <header>
        <h1 style="text-align:center;">Welcome to Chatt Dentistry</h1>
    </header>
    <body>
        <div id="leftcolumn" >
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="dentistUpdate.jsp">Update Information</a></li>
                <li><a href="dentistCompleteApt.jsp">Complete Appointment</a></li>
            </ul>
        </div>
        <div id="rightcolumn" >
            <% Dentist c1 = (Dentist)request.getSession().getAttribute("dentist"); 
            c1.selectAppointments();%>
            <h1>Welcome <%= c1.getFirstName() %> <%=c1.getLastName() %></h1>
            <br>
            <br>
            <h2>Office: <%=c1.getOffice() %></h2>
            <h2>Email: <%=c1.getEmail() %></h2>
            <table id="t01">
                <% for(int i =1; i<=c1.getCount(); i++){ %>
                <tr>
                    <td>Appointment Time:</td>
                    <td><%= c1.list.get(i-1).getApptDateTime() %></td>
                </tr> 
                <tr>
                    <td>Patient ID:</td>
                    <td><%= c1.list.get(i-1).getPatientId() %></td>
                </tr>
                <tr>
                    <td>Procedure Code:</td>
                    <td><%= c1.list.get(i-1).getProcedureCode() %></td>
                </tr>
                <tr>
                    <td>Procedure Name:</td>
                    <td><%= c1.list.get(i-1).getProcedureName() %></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><%= c1.list.get(i-1).getProcedureDescription() %></td>
                </tr>
                <tr><td style="line-height:10px;" colspan=3>&nbsp;</td></tr>
                <tr><td style="line-height:10px;" colspan=3>&nbsp;</td></tr>
                <% } %>
             </table>
            <img src="dentist.jpg" alt="Dentist Image" height ="500" width ="560"/>
        </div>
    </body>
</html>
