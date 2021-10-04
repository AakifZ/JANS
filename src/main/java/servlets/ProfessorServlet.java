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
public class ProfessorServlet extends HttpServlet {
    professorDAO profDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            resp.sendRedirect("sysAdminLoginPage.jsp");
        } else {
            String action = req.getServletPath();
            switch (action) {
                case "/new":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    insertProfessor(req, resp);
                    break;
                case "/delete":
                    deleteProfessor(req, resp);
                    break;
                case "/edit":
                    editProfessor(req, resp);
                    break;
                case "/update":
                    updateProfessor(req, resp);
                    break;
                default:
                    listProfessors(req, resp);
                    break;
            }
        }
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("prof_form.jsp");
        dispatcher.forward(req,resp);
    }

    private void insertProfessor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int ID = Integer.parseInt(req.getParameter("ID"));
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int admin = Integer.parseInt(req.getParameter("sysAdmin"));
        Professor prof = new Professor(ID, first_name, last_name, email, phone, admin);
        profDAO.insertProfessor(prof);
        resp.sendRedirect("list");

    }

    private void deleteProfessor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ID = Integer.parseInt(req.getParameter("ID"));
        try {
            profDAO.deleteProfessor(ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("list");
    }

    private void editProfessor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ID = Integer.parseInt(req.getParameter("ID"));
        Professor prof;
        try {
            prof = profDAO.selectProfessorByID(ID);
            RequestDispatcher dispatcher = req.getRequestDispatcher("prof_form.jsp");
            req.setAttribute("prof", prof);
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateProfessor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ID = Integer.parseInt(req.getParameter("ID"));
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int admin = Integer.parseInt(req.getParameter("sysAdmin"));
        Professor prof = new Professor(ID, first_name, last_name, email, phone, admin);
        profDAO.updateProfessor(prof);
        resp.sendRedirect("list");
    }

    private void listProfessors(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
