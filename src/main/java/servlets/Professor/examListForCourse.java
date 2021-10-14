package servlets.Professor;

import dao.examListDAOJC;
import objects.exam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/examListForCourse")
public class examListForCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println(req.getParameter("course_ID"));
        int course_ID = Integer.parseInt(req.getParameter("course_ID")) ;
        String course_name = req.getParameter("course_Name");
        String course_description = req.getParameter("course_description");
        List<exam> StudentexamList = examListDAOJC.selectExamsForCourse(course_ID);
        System.out.println(StudentexamList);
        req.setAttribute("StuExamList", StudentexamList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("profExamListJC.jsp");
        dispatcher.forward(req, resp);

    }
}
