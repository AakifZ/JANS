package servlets.Professor;

import dao.CourseListDAO;
import objects.courseList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class course_listServlet {
    CourseListDAO courseLDAO;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            resp.sendRedirect("courselist.jsp");
        } else {
            try {
                List<courseList> courList = courseLDAO.selectAllCourseList();
                for(int i = 0; i < courList.size(); i++) {
                    System.out.println(courList.get(i).getCourse_ID());
                }
                req.setAttribute("courseList", courList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("courselist.jsp");
                dispatcher.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    public void init() throws ServletException {
        try {
            courseLDAO = new CourseListDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
