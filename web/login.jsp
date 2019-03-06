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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chatt Dentistry :: Login</title>
    </head>
    <header>
        
    </header>
    <body>
        <div id="leftcolumn" >
            <ul>
                <li><a href="index.jsp">Home</a></li>
            </ul>
        </div>
        <div id="rightcolumn" >
            <h1>Please login to your account</h1>
            <form name ="LoginForm" method ="POST" action ="loginServlet">
                <table id="t01">
                    <tr>
                        <td>Customer ID</td>
                        <td>
                            <input type ="text" name ="idtb" />
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input type ="password" name ="pwtb" />
                        </td> 
                    </tr>
                    <tr>
                        <td>
                            <input type ="submit" name ="submitbtn" value ="Login"/>
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
