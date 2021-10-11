package servlets.Student;

import dao.CourseEnrollmentDAO;
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
            HttpSession session = req.getSession();
            int user = 0;
            if(session.getAttribute("user") != null) {
                user = (int) session.getAttribute("user");
            } else {
                System.out.println("The user attribute is null");
            }
            try {
                List<StudentCourses> studCourseList = CDAO.selectAllCoursesforStudent(user);
                req.setAttribute("studCourseList", studCourseList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("stud_CourseList.jsp");
                dispatcher.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
                req.setAttribute("Error", "Invalid Login! Please try again.");
                req.getRequestDispatcher("studentLoginPage.jsp").forward(req, resp);
            }
        }
    }
