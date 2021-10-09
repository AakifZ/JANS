package servlets.Admin;

import dao.AdminCourseDAO;
import dao.professorDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adminCourseDeleteServlet")
public class AdminCourseDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminCourseDAO adminCourseDAO = new AdminCourseDAO();

        int course_ID = Integer.parseInt(req.getParameter("course_ID").trim());
        int prof_ID = Integer.parseInt(req.getParameter("prof_ID").trim());

        try {
            adminCourseDAO.deleteCourse(course_ID, prof_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("adminCourseListServlet");
    }
}
