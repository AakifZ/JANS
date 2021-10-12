package servlets.Professor;

import dao.examListDAOJC;
import objects.examListJC;

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
    examListDAOJC examlistDAO;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            resp.sendRedirect("profExamListJC.jsp");
        } else {
            try {
                List<examListJC> exList = examlistDAO.selectcoursesforexams(0);
                for(int i = 0; i < exList.size(); i++) {
                    System.out.println(exList.get(i).getExam_ID());
                }
                req.setAttribute("courseList", exList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("profExamListJC.jsp");
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
