package dao;

import objects.courseList;
import startup.JDBC2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseListDAO {
    Connection con = JDBC2.connection;
    final static String INSERT_COURSE = "insert into course values(?, ?, ?, ?, ?, ?, ?);";
    final static String SELECT_COURSE_ID = "select * from course where course_ID = ?;";
    final static String SELECT_ALL_COURSE = "select * from course";
    final static String UPDATE_COURSELIST = "update course set course_ID = ?, professor_ID = ?, course_name = ?, course_description=?, sysAdmin =?;";
    final static String DELETE_COURSELIST = "delete from course where course_ID = ?;";

    public CourseListDAO() throws SQLException, ClassNotFoundException {
    }

    public void insertCourseList(courseList cl) throws SQLIntegrityConstraintViolationException, SQLException{
        Connection connection = JDBC2.connection;
        PreparedStatement ps = connection.prepareStatement(INSERT_COURSE);
        ps.setInt(1, cl.getCourse_ID());
        ps.setInt(2, cl.getProfessor_ID());
        ps.setString(3, cl.getCourse_name());
        ps.setString(4, cl.getCourse_description());
        ps.setInt(5,cl.getSysAdmin());

        ps.executeUpdate();
    }
    public courseList selectcourseByID(int ID) {
        courseList cl = null;
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(SELECT_COURSE_ID);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int course_ID = rs.getInt("course_ID");
                int professor_ID = rs.getInt("professor_ID");
                String course_Name = rs.getString("course_Name");
                String course_desc = rs.getString("course_desc");
                int sysAdmin = rs.getInt("SysAdmin");

                cl = new courseList(course_ID, professor_ID, course_Name, course_desc, sysAdmin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cl;
    }

    public List<courseList> selectAllCourseList() {
        List<courseList> courList = new ArrayList<>();
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_COURSE);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int course_ID = rs.getInt("course_ID");
                int professor_ID = rs.getInt("professor_ID");
                String course_Name = rs.getString("course_Name");
                String course_desc = rs.getString("course_desc");
                int sysAdmin = rs.getInt("SysAdmin");

                courseList cl = new courseList(course_ID, professor_ID, course_Name, course_desc, sysAdmin);
                courList.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courList;
    }

    public boolean updateCourseList(courseList cl) {
        boolean updated = false;
        try {
            Connection connect = JDBC2.connection;
            PreparedStatement ps = connect.prepareStatement(UPDATE_COURSELIST);
            ps.setInt(1,cl.getCourse_ID());
            ps.setInt(2,cl.getProfessor_ID());
            ps.setString(3,cl.getCourse_name());
            ps.setString(4,cl.getCourse_description());
            ps.setInt(5,cl.getSysAdmin());
            updated = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }

    public boolean deleteCourseList(int ID) {
        boolean deleted = false;
        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(DELETE_COURSELIST);
            ps.setInt(1, ID);
            deleted = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
