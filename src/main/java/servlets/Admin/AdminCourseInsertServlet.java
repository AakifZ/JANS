package servlets.Admin;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import dao.AdminCourseDAO;
import objects.AdminCourse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet("/adminCourseInsertServlet")
public class AdminCourseInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminCourseDAO adao = new AdminCourseDAO();
        AdminCourse ad = new AdminCourse();
        try {
        int course_ID = Integer.parseInt(req.getParameter("course_ID"));
        int professor_ID = Integer.parseInt(req.getParameter("professor_ID"));
        String course_name = req.getParameter("course_name");
        String course_desc = req.getParameter("course_desc");
        int admin_ID = Integer.parseInt(req.getParameter("admin"));
        ad = new AdminCourse(course_ID, professor_ID, course_name, course_desc, admin_ID);

            adao.insertCourse(ad);
            resp.sendRedirect("adminCourseListServlet");
        } catch(MysqlDataTruncation t) {
                req.setAttribute("currentInfo", ad);
                req.setAttribute("Error","The description cannot surpass 250 characters.");
                RequestDispatcher rd = req.getRequestDispatcher("admin_course_insert_form.jsp");
                rd.forward(req, resp);
        } catch (SQLIntegrityConstraintViolationException s) {
            if(s.getMessage().substring(0,9).equals("Duplicate")) {
                req.setAttribute("Error", "This course already exists");
                RequestDispatcher rd = req.getRequestDispatcher("admin_course_insert_form.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("Error", "Professor or Admin does not exist");
                RequestDispatcher rd = req.getRequestDispatcher("admin_course_insert_form.jsp");
                rd.forward(req, resp);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("The message is: " + e.getMessage());
            System.out.println("The cause is: " + e.getCause());
        }

    }
}
