package servlets.Admin;

import dao.professorDAO;
import helper.passwordHelper;
import objects.Professor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet("/profInsert")
public class ProfessorInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        professorDAO profDAO = null;
        boolean validPass = true;
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
            String password_confirm = req.getParameter("password-confirm").trim();
            if(!password.equals(password_confirm)) {
                throw new Exception();
            }
            if(!passwordHelper.validPassword(password)) {
                validPass = false;
                throw new Exception();
            }
            //password = "" + password.hashCode();

            Professor prof = new Professor(first_name, last_name, email, phone, admin, password);
            profDAO.insertProfessor(prof);
            resp.sendRedirect("profServ");
        } catch (SQLIntegrityConstraintViolationException s) {
            System.out.println("In the sqlintegrity error");
            req.setAttribute("Error", "Please enter an existing Admin ID");
            RequestDispatcher rd = req.getRequestDispatcher("prof_form.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error here: default exception e in profinsertserv");
            e.printStackTrace();
            System.out.println("the pass is valid: " + validPass);
            if(!validPass) {
                req.setAttribute("Error", "The password should have at least one uppercase, one lowercase, one digit, and be 8 characters long");
                RequestDispatcher rd = req.getRequestDispatcher("prof_form.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("Error", "The passwords do not match");
                RequestDispatcher rd = req.getRequestDispatcher("prof_form.jsp");
                rd.forward(req, resp);
            }
        }
    }
}
