package servlets.Professor;

import dao.examgradeStuDAOJC;
import objects.examgradeStuJC;

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
    examgradeStuDAOJC examGraStuDAO;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            resp.sendRedirect("profExamGradeJC.jsp");
        } else {
            try {
                List<examgradeStuJC> studentList = examGraStuDAO.selectcoursesforexams(0);
                for(int i = 0; i < studentList.size(); i++) {
                    System.out.println(studentList.get(i).getExam_grade());
                }
                req.setAttribute("courseList", studentList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("profExamGradeJC.jsp");
                dispatcher.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
