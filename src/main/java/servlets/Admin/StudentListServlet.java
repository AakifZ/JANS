package servlets.Admin;


import dao.StudentDAO;
import objects.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/studServ")
public class StudentListServlet extends HttpServlet {
   StudentDAO studDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            resp.sendRedirect("sysAdminLoginPage.jsp");
        } else {
            try {
                List<Student> studList = studDAO.selectAllStudents();
//                for (int i = 0; i < studList.size(); i++) {
//                    System.out.println(studList.get(i).getFirst_name());
//                }
                req.setAttribute("studList", studList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("stud_list.jsp");
                dispatcher.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            studDAO = new StudentDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
