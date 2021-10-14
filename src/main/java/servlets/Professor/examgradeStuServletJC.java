package servlets.Professor;

import dao.examgradeStuDAOJC;
import objects.examGradesJC;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/examGradeList")
public class examgradeStuServletJC extends HttpServlet {
    examgradeStuDAOJC grades = new examgradeStuDAOJC();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("student_ID"));
        int student_ID = Integer.parseInt(req.getParameter("student_ID")) ;
        String first_name = req.getParameter("first_Name");
        String last_name = req.getParameter("last_Name");
        int examNum = Integer.parseInt(req.getParameter("exam_grade")) ;
        int examGrade = Integer.parseInt(req.getParameter("exam_grade")) ;
        List<examGradesJC> StudentgList = grades.selectGradesforexams(student_ID);
        System.out.println(StudentgList);
        req.setAttribute("gradeList", StudentgList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("profExamGradeJC.jsp");
        dispatcher.forward(req, resp);
    }
}
