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
        <title>Chatt Dentistry :: Patient Update</title>
    </head>
    <header>
        <h1 style="text-align:center;">Update Appointment</h1>
    </header>
    <body>
        <div id="leftcolumn" >
            <ul>
                <li><a href="patientInfo.jsp">Patient Information</a></li>
            </ul>
        </div>
        <div id="rightcolumn" >
            <form name ="patientChangeApt" method ="POST" action ="patChangeAptServlet">
                <table id="t01">
                    <tr>
                        <td>Appointment Date</td>
                        <td>
                            <input type="date" name="date" placeholder="">
                        </td>
                    </tr>
                    <tr>
                        <td>Appointment Time</td>
                        <td>
                            <select name ="time">
                                <option value="8am">8am</option>
                                <option value="9am">9am</option>
                                <option value="10am">10am</option>
                                <option value="11am">11am</option>
                                <option value="12pm">12pm</option>
                                <option value="1pm">1pm</option>
                                <option value="2pm">2pm</option>
                                <option value="3pm">3pm</option>
                                <option value="4pm">4pm</option>
                                <option value="5pm">5pm</option>
                            </select>  
                        </td> 
                    </tr>
                    <tr>
                        <td>Dentist Name</td>
                        <td>
                            <select name ="dentist">
                                <option value="D201">Frank Martin</option>
                                <option value="D202">Susan Cassidy</option>
                                <option value="D203">Jerry York</option>
                                <option value="D204">Wayne Pattersen</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Procedure Name</td>
                        <td>
                            <select name ="procedure">
                                <option value="P122">Whitening</option>
                                <option value="P780">Crown</option>
                                <option value="P321">Cavity</option>
                                <option value="P790">Root Canal</option>
                                <option value="P650">Top Dentures</option>
                                <option value="P660">Bottom Dentures</option>
                                <option value="P119">Xrays</option>
                                <option value="P114">Cleaning/Exam</option>
                            </select>
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
