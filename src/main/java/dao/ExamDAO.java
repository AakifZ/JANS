package dao;


import objects.StudentCourses;
import objects.StudentExam;
import startup.JDBC2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ExamDAO {
    Connection con = JDBC2.connection;

    final static String Exam_BY_Course_ID_AND_Prof_ID = "Select exam.exam_number,exam.name,student_exam.exam_grade,exam.feedback, course.course_ID\n" +
            "            from exam,student_exam,course,course_enrollment\n" +
            "            Where exam.exam_number = student_exam.exam_number && course.course_ID = course_enrollment.course_ID && course.course_ID = ?\n" +
            "            and course.professor_ID =?\n" +
            "            ";
    final static String Exam_BY_ID = "Select exam.exam_number,exam.name,student_exam.exam_grade,exam.feedback, course.course_ID\n" +
            "from exam,student_exam,course,course_enrollment\n" +
            "Where exam.exam_number = student_exam.exam_number && course.course_ID = course_enrollment.course_ID && course.course_ID = ?\n" +
            "and course_enrollment.student_ID = ?";
    public List<StudentExam> selectAllStudentExams(int student_ID, int course_ID) {
        List<StudentExam> StudentExamList = new ArrayList<>();

        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(Exam_BY_ID);
            ps.setInt(1, course_ID);
            ps.setInt(2, student_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int examNumber = rs.getInt("exam.exam_number");
                String examName = rs.getString("exam.name");
                double examGrade = rs.getDouble("student_exam.exam_grade");
                String examFeedback = rs.getString("exam.feedback");
                StudentExam StudExam = new StudentExam(examNumber, examName, examGrade, examFeedback);
                StudentExamList.add(StudExam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StudentExamList;
    }

}


