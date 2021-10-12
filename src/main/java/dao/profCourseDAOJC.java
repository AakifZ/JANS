package dao;
import objects.profCoursesJC;
import startup.JDBC2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class profCourseDAOJC {
    Connection connect = JDBC2.connection;

    final static String ProfessorCourses_BY_ID = "select course.course_ID, course.course_name, course.course_description\n" +
            "from course where course.professor_ID = ?;";

    public List<profCoursesJC> selectAllCoursesforprofessor(int professor_ID) {
        List<profCoursesJC> ProfCourseList = new ArrayList<>();

        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(ProfessorCourses_BY_ID);
            ps.setInt(1, professor_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int courseID = rs.getInt("course.course_ID");
                String courseName = rs.getString("course.course_name");
                String courseDescription = rs.getString("course.course_description");
                profCoursesJC profCourses = new profCoursesJC(courseID, courseName, courseDescription);
                ProfCourseList.add(profCourses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ProfCourseList;
    }
}
