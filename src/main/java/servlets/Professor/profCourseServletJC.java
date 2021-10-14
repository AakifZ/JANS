package servlets.Professor;

import dao.CourseEnrollmentDAO;
import dao.profCourseDAOJC;
import objects.StudentCourses;
import objects.profCoursesJC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/profCourseList")
public class profCourseServletJC extends HttpServlet {
    profCourseDAOJC pDAO = new profCourseDAOJC();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int user = 0;
        if(session.getAttribute("user") != null) {
            user = Integer.parseInt(String.valueOf(session.getAttribute("user"))) ;

        } else {
            System.out.println("The user attribute is null");
        }
        try {
            System.out.println("The logged in prof's id is: " + user);
            List<profCoursesJC> courseList = pDAO.selectAllCoursesforprofessor(user);
            for(int i = 0; i < courseList.size(); i++) {
                System.out.println(courseList.get(i));
            }
            req.setAttribute("courseList", courseList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("profCourseListJC.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("Error", "Invalid Login! Please try again.");
            req.getRequestDispatcher("professorLoginPage.jsp").forward(req, resp);
        }
    }
}

