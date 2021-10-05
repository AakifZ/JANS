package servlets;

import dao.professorDAO;

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
            e.printStackTrace();
        }
        resp.sendRedirect("profServ");
    }
}
