package servlets;

import dao.StudentDAO;
import objects.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet("/studInsert")
public class StudentInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        StudentDAO studDAO = null;
        try {
            studDAO = new StudentDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String first_name = req.getParameter("first_name").trim();
            String last_name = req.getParameter("last_name").trim();
            String email = req.getParameter("email").trim();
            Double gpa = Double.parseDouble(req.getParameter("gpa").trim());
            int sysAdmin = Integer.parseInt(req.getParameter("admin").trim());
            String password = req.getParameter("password").trim();
            Student stud = new Student(first_name, last_name, email, gpa, sysAdmin, password);
            studDAO.insertStudent(stud);
            resp.sendRedirect("studServ");
        } catch (NumberFormatException num) {
            req.setAttribute("Error", "Please enter a valid number for Admin ID");
            RequestDispatcher rd = req.getRequestDispatcher("stud_form.jsp");
            rd.forward(req, resp);
        }
        catch (NullPointerException n){
            System.out.println("in the null pointer error");
            req.setAttribute("Error", "Please fill in all the fields!");
            RequestDispatcher rd = req.getRequestDispatcher("stud_form.jsp");
            rd.forward(req, resp);
        }catch (Exception e) {
            System.out.println("Error here: default exception e in studinsertserv");
            e.printStackTrace();
            resp.sendRedirect("/studInsert");
        }

    }
}
