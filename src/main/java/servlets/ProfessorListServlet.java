package servlets;

import dao.professorDAO;
import objects.Professor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/profServ")
public class ProfessorListServlet extends HttpServlet {
    professorDAO profDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            resp.sendRedirect("sysAdminLoginPage.jsp");
        } else {
            try {
                List<Professor> profList = profDAO.selectAllProfessors();
                for(int i = 0; i < profList.size(); i++) {
                    System.out.println(profList.get(i).getFirst_name());
                }
                req.setAttribute("profList", profList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("prof_list.jsp");
                dispatcher.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            profDAO = new professorDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
