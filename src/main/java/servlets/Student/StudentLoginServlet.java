package servlets.Student;

import dao.StudentDAO;
import dao.professorDAO;
import objects.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/studentLogin")
public class StudentLoginServlet extends HttpServlet {

    StudentDAO StudDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();

        switch (action) {
            case "/studentLogin":
                doPost(req, resp);
                break;
            case "/insertStudent":

        }

    }

    public StudentLoginServlet() throws SQLException, ClassNotFoundException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int user = Integer.parseInt(req.getParameter("user").trim());
        String pass = req.getParameter("pass").trim();
        System.out.println("the user's id is " + user);
        try {
            if (StudDAO.checkLogin(user, pass)) {
                 HttpSession session = req.getSession();
                 session.setAttribute("user",user);
                resp.sendRedirect("studentindex.jsp");
            } else {
                System.out.println("Exception Message");
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("There was an error");
            e.printStackTrace();
            req.setAttribute("Error", "Invalid Login! Try again.");
            req.getRequestDispatcher("studentLoginPage.jsp").forward(req, resp);
        }
    }

}