package dao;

import objects.exam;
import startup.JDBC2;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class examListDAOJC {
    Connection connect = JDBC2.connection;

    final static String Exam_BY_Course_ID_AND_Prof_ID = "Select exam.exam_number,exam.name,student_exam.exam_grade,exam.feedback, course.course_ID\n" +
            "            from exam,student_exam,course,course_enrollment\n" +
            "            Where exam.exam_number = student_exam.exam_number && course.course_ID = course_enrollment.course_ID && course.course_ID = ?\n" +
            "            and course.professor_ID =?\n" +
            "            ";
    final static String Exam_BY_ID = "Select exam.exam_number,exam.name,student_exam.exam_grade,exam.feedback, course.course_ID\n" +
            "from exam,student_exam,course,course_enrollment\n" +
            "Where exam.exam_number = student_exam.exam_number && course.course_ID = course_enrollment.course_ID && course.course_ID = ?\n" +
            "and course_enrollment.student_ID = ?";


    public List<exam> selectcoursesforexams(int professor_ID) {
        List<exam> StudentexamList = new ArrayList<>();

        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(Exam_BY_ID);
            ps.setInt(1, professor_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                int examID = rs.getInt("Exam.exam_number");
//                String examName = rs.getString("Exam.name");
//                String feedb = rs.getString("Exam.feedback");
                int examNumber = rs.getInt("exam.exam_number");
                String examName = rs.getString("exam.name");
                double examGrade = rs.getDouble("student_exam.exam_grade");
                String examFeedback = rs.getString("exam.feedback");

                exam exams = new exam(examNumber, examName, examGrade, examFeedback );
                StudentexamList.add(exams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StudentexamList;
    }

//    public List<exam> selectExamsForCourse(int course_ID, int professor_ID){
//        List<exam> StudentexamList = new ArrayList<>();
//
//        try {
//            Connection connection = JDBC2.connection;
//            PreparedStatement ps = connection.prepareStatement(Exam_BY_Course_ID_AND_Prof_ID);
//            ps.setInt(1, course_ID);
//            ps.setInt(2, professor_ID);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int examID = rs.getInt("Exam.exam_number");
//                String examName = rs.getString("Exam.name");
//                String feedb = rs.getString("Exam.feedback");
//
//                exam exams = new exam(examID, examName, feedb);
//                StudentexamList.add(exams);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    return StudentexamList;
//    }
}
