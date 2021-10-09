package servlets.Admin;

import dao.professorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profDelete")
public class ProfessorDeleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        professorDAO profDAO = null;
        try {
            profDAO = new professorDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int ID = Integer.parseInt(req.getParameter("ID").trim());
        System.out.println("The id number is: " + ID);
        try {
            profDAO.deleteProfessor(ID);
        } catch (Exception e) {

            req.setAttribute("Error", "A professor cannot be deleted if they are currently teaching a class");
            RequestDispatcher rd = req.getRequestDispatcher("profServ");
            rd.forward(req, resp);
            e.printStackTrace();
        }
        resp.sendRedirect("profServ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
