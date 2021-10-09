package dao;

import objects.AdminCourse;
import objects.Professor;
import startup.JDBC2;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminCourseDAO {
    Connection con = JDBC2.connection;
    final static String INSERT_COURSE = "insert into course values(?, ?, ?, ?, ?);";
    final static String SELECT_COURSE_BY_ID = "select * from course where course_ID = ?;";
    final static String SELECT_ALL_COURSE = "select * from course";
    final static String UPDATE_COURSE = "update course set course_ID = ?, professor_ID = ?, course_name = ?, course_description=?, sysAdmin =? where course_ID = ?;";
    final static String DELETE_COURSE = "delete from course where course_ID = ? and professor_ID = ?;";

    public AdminCourseDAO() {
    }

    public void insertCourse(AdminCourse adminCourse) throws SQLException {
       Connection connection = JDBC2.connection;
        PreparedStatement ps = connection.prepareStatement(INSERT_COURSE);
        ps.setInt(1, adminCourse.getCourse_ID());
        ps.setInt(2, adminCourse.getProfessor_ID());
        ps.setString(3, adminCourse.getCourse_name());
        ps.setString(4, adminCourse.getCourse_description());
        ps.setInt(5,adminCourse.getSysAdmin());
        ps.executeUpdate();
    }




    public List<AdminCourse> selectAllCourses() {
        List<AdminCourse> adminCourseList = new ArrayList<>();
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_COURSE);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int ID = rs.getInt("course_ID");
                int professor_ID = rs.getInt("professor_ID");
                String course_name = rs.getString("course_name");
                String course_description = rs.getString("course_description");
                int sysAdmin = rs.getInt("sysAdmin");
                AdminCourse adminCourse = new AdminCourse(ID, professor_ID, course_name, course_description, sysAdmin);
                adminCourseList.add(adminCourse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminCourseList;
    }


    public boolean deleteCourse(int course_ID, int prof_ID) {
        boolean deleted = false;
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(DELETE_COURSE);
            ps.setInt(1, course_ID);
            ps.setInt(2,prof_ID);
            deleted = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
