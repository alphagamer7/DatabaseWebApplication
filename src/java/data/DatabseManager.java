/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kosala
 */
public class DatabseManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection con;
        Statement st;

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        try {

            String URL = "jdbc:derby://localhost:1527/myData";
            String USER = "athif";
            String PASS = "athif";
            con = DriverManager.getConnection(URL, USER, PASS);
            st = con.createStatement();
            int i = st.executeUpdate("insert into Student(name,id) values('" + name + "','" + id + "')");
            out.println("Data is successfully inserted!");

            //housekeeping
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print(e);
        }

        response.sendRedirect("home.jsp");
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
        processRequest(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection cn;
        Statement statement;
        ResultSet rs;
        HttpSession session = request.getSession();
        String str = new String();
        try {
            String URL = "jdbc:derby://localhost:1527/myData";
            String USER = "athif";
            String PASS = "athif";
            cn = DriverManager.getConnection(URL, USER, PASS);
            statement = cn.createStatement();
            rs = statement.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                out.println("ID : " + rs.getString("id") + " - Name : " + rs.getString("name") + "<BR>");
                str = str + "ID : " + rs.getString("id") + " - Name : " + rs.getString("name") + "<BR>";
            }
            session.setAttribute("str", str);
            //housekeeping
            cn.close();
            statement.close();
            rs.close();
        } catch (Exception e) {
            System.out.print(e);
        }
        //response.sendRedirect("results2.jsp");
    }
}
