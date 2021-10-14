package servlets.Professor;

import dao.examgradeStuDAOJC;
import objects.examGradesJC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/examInsert")
public class examGradeFormServletJC extends HttpServlet {
    examgradeStuDAOJC pDAO = new examgradeStuDAOJC();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        examgradeStuDAOJC gradeDAO = null;
        HttpSession session = req.getSession();
        int user = 0;
        if(session.getAttribute("user") != null) {
            user = (int) session.getAttribute("user");

        } else {
            System.out.println("The user attribute is null");
        }
        try {
            System.out.println("The logged in prof's id is: " + user);
            List<examGradesJC> exList = pDAO.selectGradesforexams(user);
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

//        try {
//            int stu_ID = req.getIntHeader("student_ID");
//            String first_name = req.getParameter("first_name").trim();
//            String last_name = req.getParameter("last_name").trim();
//            int examNum = req.getIntHeader("exam_number");
//            int examGrade = req.getIntHeader("exam_grade");
//
//
//            examgradeStuJC prof = new examgradeStuJC(stu_ID, first_name, last_name, examNum, examGrade);
////            gradeDAO.insertGrade(stu_ID,examNum, examGrade);
////            gradeDAO.insertStudent(stu_ID, first_name, last_name);
//            resp.sendRedirect("examGradeList");
////        } catch (SQLIntegrityConstraintViolationException s) {
////            System.out.println("There was an error");


      //  }
    }
}
