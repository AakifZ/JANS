package dao;

import objects.exam;
import startup.JDBC2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class examListDAOJC {
    Connection connect = JDBC2.connection;

    final static String exams_BY_ID = "select course.course_ID, Exam.exam_number, Exam.name, Exam.feedback\n" +
            "from Exam, course where course.professor_ID = ?;";

    final static String exams_BY_Course_ID = "select course.course_ID, Exam.exam_number, Exam.name, Exam.feedback\n" +
            "from Exam, course where course.course_ID = ?;";


    public List<exam> selectcoursesforexams(int professor_ID) {
        List<exam> StudentexamList = new ArrayList<>();

        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(exams_BY_ID);
            ps.setInt(1, professor_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int examID = rs.getInt("Exam.exam_number");
                String examName = rs.getString("Exam.name");
                String feedb = rs.getString("Exam.feedback");

                exam exams = new exam(examID, examName, feedb);
                StudentexamList.add(exams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StudentexamList;
    }

    public static List<exam> selectExamsForCourse(int course_ID){
        List<exam> StudentexamList = new ArrayList<>();

        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(exams_BY_Course_ID);
            ps.setInt(1, course_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int examID = rs.getInt("Exam.exam_number");
                String examName = rs.getString("Exam.name");
                String feedb = rs.getString("Exam.feedback");

                exam exams = new exam(examID, examName, feedb);
                StudentexamList.add(exams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return StudentexamList;
    }
}
