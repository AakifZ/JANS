package servlets.Student;

import dao.CourseEnrollmentDAO;
import dao.ExamDAO;
import objects.StudentCourses;
import objects.StudentExam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudExamList")
public class StudentExamList extends HttpServlet {

    ExamDAO EDAO = new ExamDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int user = 0;
        if (session.getAttribute("user") != null) {
            user = (int) session.getAttribute("user");
        } else {
            System.out.println("The user attribute is null");
        }
        int course_ID = Integer.parseInt(req.getParameter("course_ID").trim());
        try {
            List<StudentExam> studExamList = EDAO.selectAllStudentExams(user, course_ID);
            req.setAttribute("studExamList", studExamList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("student_exam_list.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
