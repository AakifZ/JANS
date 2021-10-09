package dao;

import objects.Student;
import startup.JDBC2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    Connection con = JDBC2.connection;
    final static String INSERT_STUDENT = "insert into STUDENT values(?, ?, ?, ?, ?, ?,?);";
    final static String SELECT_STUDENT_BY_ID = "select * from student where student_ID = ?;";
    final static String SELECT_ALL_STUDENTS = "select * from student";
    final static String UPDATE_STUDENTS = "update student set first_name = ?, last_name = ?, email = ?, gpa=?, sysAdmin =?,password=? where student_ID = ?;";
    final static String DELETE_STUDENTS = "delete from student where id = ?;";

    public StudentDAO() throws SQLException, ClassNotFoundException {
    }
    public boolean checkLogin(int ID, String password) throws SQLException {
        ResultSet rs = null;
        try {
            String query = "select * from student where student_ID = ? and password = ?;";
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

    public void insertStudent(Student Stud) {
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT);
            ps.setInt(1, Stud.getStudent_ID());
            ps.setString(2, Stud.getFirst_name());
            ps.setString(3, Stud.getLast_name());
            ps.setString(4, Stud.getEmail());
            ps.setDouble(5,Stud.getGpa());
            ps.setInt(6,Stud.getSysAdmin());
            ps.setString(7,Stud.getPassword());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Student selectStudentByID(int ID) {
        Student Stud = null;
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                double gpa = rs.getDouble("gpa");
                int admin = rs.getInt("sysAdmin");
                String password = rs.getString("password");
                Stud = new Student(ID, first_name, last_name, email, gpa, admin,password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Stud;
    }

    public List<Student> selectAllStudents() {
        List<Student> StudList = new ArrayList<>();
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_STUDENTS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int ID = rs.getInt("professor_ID");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                double gpa = rs.getInt("gpa");
                int admin = rs.getInt("sysAdmin");
                String password = rs.getString("password");
                Student Stud = new Student(ID, first_name, last_name, email, gpa, admin,password);
                StudList.add(Stud);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StudList;
    }

    public boolean updateStudent(Student Stud) {
        boolean updated = false;
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(UPDATE_STUDENTS);
            ps.setString(1,Stud.getFirst_name());
            ps.setString(2,Stud.getLast_name());
            ps.setString(3,Stud.getEmail());
            ps.setDouble(4,Stud.getGpa());
            ps.setInt(5,Stud.getSysAdmin());
            ps.setString(6, Stud.getPassword());
            updated = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }

    public boolean deleteStudent(int ID) {
        boolean deleted = false;
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(DELETE_STUDENTS);
            ps.setInt(1, ID);
            deleted = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
