package servlets;

import dao.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/studentLogin")
public class StudentLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("user").trim();
        String pass = req.getParameter("pass").trim();
        AdminDAO ad = new AdminDAO();
        try {
            if (ad.checkLogin(user, pass) || ad.checkLogin(Integer.parseInt(user), pass)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                RequestDispatcher rd = req.getRequestDispatcher("profServ");
                rd.forward(req, resp);

                //resp.sendRedirect("prof_list.jsp");
            } else {
                System.out.println("An exception was thrown.");
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("Error", "Invalid Login! Please try again.");
            req.getRequestDispatcher("sysAdminLoginPage.jsp").forward(req, resp);
        }

    }
}
