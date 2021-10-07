package servlets.Professor;

import dao.professorDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/professorLogin")
public class ProfessorLoginServlet extends HttpServlet {

    professorDAO profDAO = new professorDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
            case "/professorLogin":
                doPost(req, resp);
                break;
            case "/insertProfessor":

        }

    }

    public ProfessorLoginServlet() throws SQLException, ClassNotFoundException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user").trim();
        String pass = req.getParameter("pass").trim();

        try {
            if (profDAO.checkLogin(user, pass) || profDAO.checkLogin(Integer.parseInt(user), pass)) {
                resp.sendRedirect("index.jsp");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("There was an error");
            e.printStackTrace();
            req.setAttribute("Error", "Invalid Login! Try again.");
            req.getRequestDispatcher("professorLoginPage.jsp").forward(req, resp);
        }
    }

}