package dao;

import objects.examListJC;
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

    public List<examListJC> selectcoursesforexams(int exam_number) {
        List<examListJC> StudentexamList = new ArrayList<>();

        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(exams_BY_ID);
            ps.setInt(1, exam_number);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int examID = rs.getInt("Exam.exam_number");
                String examName = rs.getString("Exam.name");
                String feedb = rs.getString("Exam.feedback");

                objects.examListJC exams = new objects.examListJC(examID, examName, feedb);
                StudentexamList.add(exams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StudentexamList;
    }
}
