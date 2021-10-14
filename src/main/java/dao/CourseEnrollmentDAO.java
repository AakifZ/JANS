package dao;
//User:Aakif
import objects.Student;
import objects.StudentCourses;
import startup.JDBC2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CourseEnrollmentDAO {
    Connection con = JDBC2.connection;

    final static String StudentCourses_BY_ID = "Select course.course_ID,course.course_name,course.course_description,course.professor_ID from course, course_enrollment Where course.course_ID = course_enrollment.course_ID and student_ID = ?;";

    public List<StudentCourses> selectAllCoursesforStudent(int student_ID) {
        List<StudentCourses> StudentCourseList = new ArrayList<>();

        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(StudentCourses_BY_ID);
            ps.setInt(1,student_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int courseID = rs.getInt("course.course_ID");
                String courseName = rs.getString("course.course_name");
                String courseDescription = rs.getString("course.course_description");
                int professorID = rs.getInt("course.professor_ID");
                StudentCourses StudCourses = new StudentCourses(courseID, courseName, courseDescription, professorID);
                StudentCourseList.add(StudCourses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StudentCourseList;
    }

}


