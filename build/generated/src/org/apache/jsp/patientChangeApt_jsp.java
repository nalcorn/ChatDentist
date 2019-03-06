package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class patientChangeApt_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"index.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Chatt Dentistry :: Patient Update</title>\n");
      out.write("    </head>\n");
      out.write("    <header>\n");
      out.write("        <h1 style=\"text-align:center;\">Update Appointment</h1>\n");
      out.write("    </header>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"leftcolumn\" >\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"patientInfo.jsp\">Patient Information</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"rightcolumn\" >\n");
      out.write("            <form name =\"patientChangeApt\" method =\"POST\" action =\"patChangeAptServlet\">\n");
      out.write("                <table id=\"t01\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Appointment Date</td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"date\" name=\"myDate\" placeholder=\"\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Appointment Time</td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"time\" name=\"myDate\" placeholder=\"\">\n");
      out.write("                        </td> \n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Procedure Name</td>\n");
      out.write("                        <td>\n");
      out.write("                            <select>\n");
      out.write("                                <option value=\"P122\">Whitening</option>\n");
      out.write("                                <option value=\"P780\">Crown</option>\n");
      out.write("                                <option value=\"P321\">Cavity</option>\n");
      out.write("                                <option value=\"P790\">Root Canal</option>\n");
      out.write("                                <option value=\"P650\">Top Dentures</option>\n");
      out.write("                                <option value=\"P660\">Bottom Dentures</option>\n");
      out.write("                                <option value=\"P119\">Xrays</option>\n");
      out.write("                                <option value=\"P114\">Cleaning/Exam</option>\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <input type =\"submit\" name =\"submitbtn\" value =\"Submit\"/>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type =\"reset\" name =\"clearbtn\" value =\"Clear\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
