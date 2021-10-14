package dao;

import objects.examGradesJC;
import startup.JDBC2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class examgradeStuDAOJC {
    Connection connect = JDBC2.connection;

    final static String exams_BY_ID = "Select student_exam.student_ID, student.first_name, student.last_name, student_exam.exam_number, student_exam.exam_grade from student, student_exam where student.student_ID = ?;";
    final static String INSERT_STUDENT = "insert into student values(?, ?, ?, ?, ?, ?, ?);";
    final static String INSERT_EXAM = "insert into student values(?, ?, ?, ?, ?);";

    public List<examGradesJC> selectGradesforexams(int student_ID) {
        List<examGradesJC> examList = new ArrayList<>();

        try {
            Connection connection = JDBC2.connection;
            PreparedStatement ps = connection.prepareStatement(exams_BY_ID);
            ps.setInt(1, student_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int stuID = rs.getInt("student_exam.student_ID");
                String firstName = rs.getString("student.first_name");
                String lastName = rs.getString("student.last_name");

                int examNum = rs.getInt("student_exam.exam_number");
                int examGrade = rs.getInt("student_exam.exam_grade");


                examGradesJC exams = new examGradesJC(stuID,firstName, lastName, examNum, examGrade);
                examList.add(exams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return examList;
    }

//    public void insertGrade(examgradeStuJC grad) throws SQLIntegrityConstraintViolationException, SQLException {
//        Connection connection = JDBC2.connection;
//        PreparedStatement ps = connection.prepareStatement(INSERT_GRADE);
//        ps.setInt(1, prof.getProfessor_ID());
//        ps.setString(2, prof.getFirst_name());
//        ps.setString(3, prof.getLast_name());
//        ps.setString(4, prof.getEmail());
//        ps.setString(5,prof.getPhone());
//        ps.setInt(6,prof.getAdmin());
//        ps.setString(7,prof.getPassword());
//        ps.executeUpdate();
    }
//}
