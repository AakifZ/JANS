package servlets.Professor;

import dao.examgradeStuDAOJC;
import dao.profCourseDAOJC;
import objects.examgradeStuJC;
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

@WebServlet("/examGradeList")
public class examgradeStuServletJC extends HttpServlet {
    examgradeStuDAOJC pDAO = new examgradeStuDAOJC();

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
            System.out.println("The logged in prof's id is: " + user);
            List<examgradeStuJC> exList = pDAO.selectcoursesforexams(user);
            for(int i = 0; i < exList.size(); i++) {
                System.out.println(exList.get(i));
            }
            req.setAttribute("examList", exList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("proExamGradeJC.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("Error", "Invalid Login! Please try again.");
            req.getRequestDispatcher("professorLoginPage.jsp").forward(req, resp);
        }
    }



}
