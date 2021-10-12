package dao;

import objects.examgradeStuJC;
import startup.JDBC2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class examgradeStuDAOJC {
    Connection connect = JDBC2.connection;

    final static String exams_BY_ID = "Select student.first_name, student.last_name, student_exam.student_ID, student_exam.exam_number, student_exam.exam_grade from student, student_exam Where student.student_ID = student_exam.student_ID and student_exam.exam_grade = ?;";

    public List<examgradeStuJC> selectcoursesforexams(int student_ID) {
        List<examgradeStuJC> examList = new ArrayList<>();

        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(exams_BY_ID);
            ps.setInt(1, student_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String firstName = rs.getString("student.first_name");
                String lastName = rs.getString("student.last_name");
                int stuID = rs.getInt("student_exam.student_ID");
                int examNum = rs.getInt("student_exam.exam_number");
                double examGrade = rs.getInt("student_exam.exam_grade");


                examgradeStuJC exams = new examgradeStuJC(firstName, lastName, stuID, examNum, examGrade);
                examList.add(exams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return examList;
    }
}
