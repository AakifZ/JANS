package servlets.Admin;

import dao.AdminCourseDAO;
import dao.professorDAO;
import objects.AdminCourse;
import objects.Professor;

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

@WebServlet("/adminCourseListServlet")
public class AdminCourseListServlet extends HttpServlet {

    AdminCourseDAO adminCourseDAO = new AdminCourseDAO();

    public AdminCourseListServlet() throws SQLException, ClassNotFoundException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            resp.sendRedirect("sysAdminLoginPage.jsp");
        } else {
            try {
                List<AdminCourse> adminCourseList = adminCourseDAO.selectAllCourses();
                for(int i = 0; i < adminCourseList.size(); i++) {
                    System.out.println(adminCourseList.get(i).getCourse_ID());
                }
                req.setAttribute("adminCourseList", adminCourseList);
                for (AdminCourse ad: adminCourseList) {
                    System.out.println(ad);
                }
                RequestDispatcher dispatcher = req.getRequestDispatcher("admin_course_list.jsp");
                dispatcher.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}

