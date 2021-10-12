package servlets.Professor;

import dao.profCourseDAOJC;
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
    profCourseDAOJC procourseDAO = new profCourseDAOJC();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int user = 0;
        if (session.getAttribute("user") == null) {
            resp.sendRedirect("professorLoginPage.jsp");
        } else {
            try {
                List<profCoursesJC> courseList = procourseDAO.selectAllCoursesforprofessor(1);
                req.setAttribute("courseList", courseList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("profCourseListJC.jsp");
                dispatcher.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

