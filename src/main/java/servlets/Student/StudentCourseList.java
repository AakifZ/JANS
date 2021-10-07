package servlets.Student;

import dao.CourseEnrollmentDAO;
import dao.CourseListDAO;
import objects.Professor;
import objects.StudentCourses;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet ("/StudCourseList")
public class StudentCourseList extends HttpServlet {
    CourseEnrollmentDAO CDAO = new CourseEnrollmentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            try {
                List<StudentCourses> studList = CDAO.selectAllCoursesforStudent(1);
                req.setAttribute("studList", studList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("stud_CourseList.jsp");
                dispatcher.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
