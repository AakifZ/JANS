package servlets.Professor;

import dao.examListDAOJC;
import objects.exam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import dao.ExamDAO;
@WebServlet("/examList")
public class examListServletJC extends HttpServlet {
    examListDAOJC pDAO = new examListDAOJC();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        int user = 0;
//        if(session.getAttribute("user") != null) {
//            user = (int) session.getAttribute("user");
//
//        } else {
//            System.out.println("The user attribute is null");
//        }
//        try {
//            System.out.println("The logged in prof's id is: " + user);
//            List<exam> examList = pDAO.selectcoursesforexams(user);
//            for(int i = 0; i < examList.size(); i++) {
//                System.out.println(examList.get(i));
//            }
//            req.setAttribute("profExamList", examList);
//            RequestDispatcher dispatcher = req.getRequestDispatcher("profExamList.jsp");
//            dispatcher.forward(req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//            req.setAttribute("Error", "Invalid Login! Please try again.");
//            req.getRequestDispatcher("professorLoginPage.jsp").forward(req, resp);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int professor_ID = Integer.parseInt(String.valueOf(session.getAttribute("user")));

        System.out.println(req.getParameter("course_ID"));
        int course_ID = Integer.parseInt(req.getParameter("course_ID")) ;

        ExamDAO dao = new ExamDAO();
        List<exam> examList = dao.selectExamsByCourseIdAndProfId(course_ID, professor_ID);
        System.out.println(examList);
        req.setAttribute("StuExamList", examList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("profExamListJC.jsp");
        dispatcher.forward(req, resp);
    }
}
