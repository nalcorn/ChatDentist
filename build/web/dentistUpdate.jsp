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
        <title>Chatt Dentistry :: Dentist Update</title>
    </head>
    <header>
        <h1 style="text-align:center;">Update Information</h1>
    </header>
    <body>
        <div id="leftcolumn" >
            <ul>
                <li><a href="dentistInfo.jsp">Dentist Information</a></li>
            </ul>
        </div>
        <div id="rightcolumn" >
            <% Dentist c1 = (Dentist)request.getSession().getAttribute("dentist"); %>
            <form name ="dentistUpdate" method ="POST" action ="dentUpdateServlet">
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
                        <td>Office</td>
                        <td>
                            <input type ="text" name ="office" value = <%= c1.getOffice() %> />
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
