package dao;

import objects.Professor;
import startup.JDBC2;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class professorDAO {
    Connection con = JDBC2.connection;
    final static String INSERT_PROFESSOR = "insert into professor values(?, ?, ?, ?, ?, ?, ?);";
    final static String SELECT_PROFESSOR_BY_ID = "select * from professor where professor_ID = ?;";
    final static String SELECT_ALL_PROFESSORS = "select * from professor";
    final static String DELETE_PROFESSOR = "delete from professor where professor_ID = ?;";

    public professorDAO() throws SQLException, ClassNotFoundException {
    }
    public boolean checkLogin(int ID, String password) throws SQLException {
        ResultSet rs = null;
        try {
            String query = "select * from professor where professor_ID = ? and password = ?;";
            PreparedStatement ps = JDBC2.connection.prepareStatement(query);
            ps.setInt(1,ID);
            ps.setString(2,password);
            rs = ps.executeQuery(); }
        catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return rs.next() == true;
    }
    public boolean checkLogin(String email, String password) throws SQLException {
        ResultSet rs = null;
        try {
            String query = "select * from professor where email = ? and password = ?";
            PreparedStatement ps = JDBC2.connection.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2,password);
            rs = ps.executeQuery(); }
        catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return rs.next() == true;
    }

    public void insertProfessor(Professor prof) throws SQLIntegrityConstraintViolationException, SQLException{
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(INSERT_PROFESSOR);
            ps.setInt(1, prof.getProfessor_ID());
            ps.setString(2, prof.getFirst_name());
            ps.setString(3, prof.getLast_name());
            ps.setString(4, prof.getEmail());
            ps.setString(5,prof.getPhone());
            ps.setInt(6,prof.getAdmin());
            ps.setString(7,prof.getPassword());
            ps.executeUpdate();
    }
    public Professor selectProfessorByID(int ID) {
        Professor prof = null;
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(SELECT_PROFESSOR_BY_ID);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int admin = rs.getInt("sysAdmin");
                String password = rs.getString("password");
                prof = new Professor(ID, first_name, last_name, email, phone, admin, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prof;
    }

    public List<Professor> selectAllProfessors() {
        List<Professor> profList = new ArrayList<>();
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PROFESSORS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int ID = rs.getInt("professor_ID");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int admin = rs.getInt("sysAdmin");
                String password = rs.getString("password");
                Professor prof = new Professor(ID, first_name, last_name, email, phone, admin, password);
                profList.add(prof);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return profList;
    }


    public boolean deleteProfessor(int ID) throws SQLException {
        boolean deleted = false;

            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(DELETE_PROFESSOR);
            ps.setInt(1, ID);
            deleted = ps.executeUpdate() > 0;

        return deleted;
    }
}
