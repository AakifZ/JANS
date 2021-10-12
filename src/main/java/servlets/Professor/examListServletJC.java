package servlets.Professor;

import dao.examListDAOJC;
import dao.profCourseDAOJC;
import objects.examListJC;
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

@WebServlet("/examList")
public class examListServletJC extends HttpServlet {
    examListDAOJC pDAO = new examListDAOJC();

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
            List<examListJC> examList = pDAO.selectcoursesforexams(user);
            for(int i = 0; i < examList.size(); i++) {
                System.out.println(examList.get(i));
            }
            req.setAttribute("profExamList", examList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("profExamList.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("Error", "Invalid Login! Please try again.");
            req.getRequestDispatcher("professorLoginPage.jsp").forward(req, resp);
        }
    }
}
