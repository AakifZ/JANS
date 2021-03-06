package servlets.Admin;

import dao.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/studDelete")
public class StudentDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        StudentDAO studDAO = null;
        try {
            studDAO = new StudentDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        int ID = Integer.parseInt(req.getParameter("ID").trim());
        System.out.println("The id number is: " + ID);
        try {
            studDAO.deleteStudent(ID);
        } catch (Exception e) {
            req.setAttribute("Error", "A student cannot be deleted if they are already in a class");
            RequestDispatcher rd = req.getRequestDispatcher("studServ");
            rd.forward(req, resp);
            e.printStackTrace();
        }
        resp.sendRedirect("studServ");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
