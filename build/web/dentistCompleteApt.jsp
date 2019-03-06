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
        <title>Chatt Dentistry :: Complete Appointment</title>
    </head>
     <header>
        <h1 style="text-align:center;">Complete Appointment</h1>
    </header>
    <body>
        <div id="leftcolumn" >
            <ul>
                <li><a href="dentistInfo.jsp">Dentist Information</a></li>
            </ul>
        </div>
        <div id="rightcolumn" >
            <% Dentist c1 = (Dentist)request.getSession().getAttribute("dentist"); %>
            <h1>Please complete and appointment, <%= c1.getFirstName() %> <%=c1.getLastName() %></h1>
            <br>
            <br>
            <form name ="dentistCompleteAppt" method ="POST" action ="dentCompleteApptServlet">            <table id="t01">
                <table>
                    <% for(int i =1; i<=c1.getCount(); i++){ %>
                    <tr>
                        <td><input type = "radio" name = "complete" value = <%= c1.list.get(i-1).getPatientId() %> </td>
                        <td>Appointment Time:</td>
                        <td><%= c1.list.get(i-1).getApptDateTime() %></td>
                    </tr> 
                    <tr>
                        <td></td>
                        <td>Patient ID:</td>
                        <td><%= c1.list.get(i-1).getPatientId() %></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Procedure Code:</td>
                        <td><%= c1.list.get(i-1).getProcedureCode() %></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Procedure Name:</td>
                        <td><%= c1.list.get(i-1).getProcedureName() %></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Description:</td>
                        <td><%= c1.list.get(i-1).getProcedureDescription() %></td>
                    </tr>
                    <tr><td style="line-height:10px;" colspan=3>&nbsp;</td></tr>
                    <tr><td style="line-height:10px;" colspan=3>&nbsp;</td></tr>
                    <% } %>
                    <tr>
                        <td></td> 
                        <td><input type="submit" value="Submit"></td>
                        <td></td>
                    </tr>
                </table>
            </form>
            <img src="dentist.jpg" alt="Dentist Image" height ="500" width ="560"/>
        </div>
    </body>
</html>
