package servlets;

import dao.professorDAO;
import objects.Professor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profInsert")
public class ProfessorInsertServlet extends HttpServlet {
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
        try {
            String first_name = req.getParameter("first_name").trim();
            String last_name = req.getParameter("last_name").trim();
            String email = req.getParameter("email").trim();
            String phone = req.getParameter("phone").trim();
            int admin = Integer.parseInt(req.getParameter("admin").trim());
            String password = req.getParameter("password").trim();
            Professor prof = new Professor(first_name, last_name, email, phone, admin, password);
            profDAO.insertProfessor(prof);
            resp.sendRedirect("profServ");
        } catch (NullPointerException n){
            req.setAttribute("Error", "Please fill in all the fields!");
            RequestDispatcher rd = req.getRequestDispatcher("prof_form.jsp");
            rd.forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/profInsert");
        }
    }
}
