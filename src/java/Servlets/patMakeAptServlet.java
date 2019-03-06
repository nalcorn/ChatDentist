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
package Servlets;

import Business.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet creates an appointment with the current Appointment Object in the 
 * database.
 * @author nicho
 */
@WebServlet(name = "patMakeAptServlet", urlPatterns = {"/patMakeAptServlet"})
public class patMakeAptServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Patient c1 = (Patient) session.getAttribute("patient");
            String temp;
            String date = "";
            //System.out.println(request.getParameter("date"));
            temp = request.getParameter("date").substring(5,7);
            switch(temp){
                case "01": date = "Jan ";
                    break;
                case "02": date = "Feb ";
                    break;
                case "03": date = "Mar ";
                    break;
                case "04": date = "Apr ";
                    break;
                case "05": date = "May ";
                    break;
                case "06": date = "Jun ";
                    break;
                case "07": date = "Jul ";
                    break;
                case "08": date = "Aug ";
                    break;
                case "09": date = "Sep ";
                    break;
                case "10": date = "Oct ";
                    break;
                case "11": date = "Nov ";
                    break;
                case "12": date = "Dec ";
                    break;
            }
            temp = request.getParameter("date").substring(8,10);
            date = date+temp+", ";
            temp = request.getParameter("date").substring(0,4);
            date = date+temp+", ";
            //System.out.println(date);
            System.out.println(request.getParameter("time"));
            temp = request.getParameter("time");
            date = date + temp;
            System.out.println(request.getParameter("procedure"));
            System.out.println(date);
            c1.patientAppt.setApptDateTime(date);
            c1.patientAppt.setProcedureCode(request.getParameter("procedure"));
            c1.patientAppt.selectProcDb(request.getParameter("procedure"));
            c1.patientAppt.setPatientId(c1.getPatientId());
            c1.patientAppt.setDentistId(request.getParameter("dentist"));
            c1.patientAppt.insertApptDb();
            c1.updateDb();
           
            session.setAttribute("patient", c1);

            RequestDispatcher rs = request.getRequestDispatcher("patientInfo.jsp");
            rs.include(request,response);
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(patMakeAptServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(patMakeAptServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(patMakeAptServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(patMakeAptServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
