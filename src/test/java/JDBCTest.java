import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class JDBCTest {

    @Before
    public void init() throws SQLException, ClassNotFoundException {
        JDBC.connector();
        JDBC.DBCreationReader();
    }

    /**
     * This tests the addStudent method. It calls the addStudent method and then searches for that student in the database
     * using the student_ID. It then compares all of that student's information with the information that was just added.
     *
     * @throws SQLException
     */
    @Test
    public void testAddStudent() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.addStudent("Marty", "McAnt", "mcmarty@gmail.com", 1.4);
        String query = "select * from student where student_ID = 1";
        ResultSet rs = statement.executeQuery(query);
        String[] result = new String[5];
        while (rs.next()) {
            result[0] = "" + rs.getInt(1);
            result[1] = rs.getString(2);
            result[2] = rs.getString(3);
            result[3] = rs.getString(4);
            result[4] = "" + rs.getDouble(5);
        }
        assertEquals(new String[]{"1", "Marty", "McAnt", "mcmarty@gmail.com", "1.4"}, result);
    }

    /**
     * This is a second test adding another student.
     *
     * @throws SQLException
     */
    @Test
    public void testAddStudentTwo() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.addStudent("temp", "student", "tempstudent@gmail.com", 0.4);
        JDBC.addStudent("Jose", "Lopez", "mexico123@gmail.com", 2.6);

        String query = "select * from student where student_ID = 2";
        ResultSet rs = statement.executeQuery(query);
        String[] result = new String[5];
        while (rs.next()) {
            result[0] = "" + rs.getInt(1);
            result[1] = rs.getString(2);
            result[2] = rs.getString(3);
            result[3] = rs.getString(4);
            result[4] = "" + rs.getDouble(5);
        }
        assertEquals(new String[]{"2", "Jose", "Lopez", "mexico123@gmail.com", "2.6"}, result);
    }

    @Test
    public void testAddSysAdmin() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.addSysAdmin(1, "Abdul", "Jerry", "abduljerry@gmail.com");
        String query = "select * from sysadmin where admin_ID = 1";
        ResultSet rs = statement.executeQuery(query);
        String[] result = new String[4];
        while(rs.next()) {
            result[0] = "" + rs.getInt(1);
            result[1] = rs.getString(2);
            result[2] = rs.getString(3);
            result[3] = rs.getString(4);
        }
        assertEquals(new String[]{"1","Abdul", "Jerry", "abduljerry@gmail.com"},result);
    }

    @Test
    public void testAddProfessor() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.addSysAdmin(1,"temp","admin","tempadmin@gmail.com");
        JDBC.addProfessor(1, "Nathan", "Drake", "Uncharted@gmail.com", "6305552222", 1);

        String query = "select * from professor where professor_ID = 1";
        ResultSet rs = statement.executeQuery(query);
        String[] result = new String[6];
        while (rs.next()) {
            result[0] = "" + rs.getInt(1);
            result[1] = rs.getString(2);
            result[2] = rs.getString(3);
            result[3] = rs.getString(4);
            result[4] = "" + rs.getString(5);
            result[5] = "" + rs.getInt(6);
        }
        assertEquals(new String[]{"1", "Nathan", "Drake", "Uncharted@gmail.com", "6305552222", "1"}, result);
    }

    /**
     * Tests the DeleteProfessor Method
     * @throws SQLException
     */
    @Test
    public void testDeleteProfessor() throws SQLException{
        Statement statement = JDBC.connection.createStatement();
        JDBC.deleteProfessor(1);
        String query = "select * from professor where professor_ID = 1";
        ResultSet rs = statement.executeQuery(query);
        int result = 0;
        while (rs.next()) {
            result = rs.getInt("professor_ID");
        }
        assertEquals(0, result);

    }

    /**
     * This tests the addClass method.
     *
     * @throws SQLException
     */
    @Test
    public void testAddClass() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.addSysAdmin(1, "temp", "admin", "tempadmin@gmail.com");
        JDBC.addProfessor(1, "temp", "professor", "tempprof@gmail.com", "1231231234", 1);
        JDBC.addCourse(1, 1, "Software Engineering", "This is a required course");

        String query = "select * from course where course_ID = 1";
        ResultSet rs = statement.executeQuery(query);
        String[] result = new String[4];
        while (rs.next()) {
            result[0] = "" + rs.getInt(1);
            result[1] = "" + rs.getInt(2);
            result[2] = rs.getString(3);
            result[3] = rs.getString(4);
        }
        assertEquals(new String[]{"1", "1", "Software Engineering", "This is a required course"}, result);
    }

    /**
     * This tests the deleteStudent method. When the student has been deleted, his/her ID number would be 0. Upon deletion of
     * the first student, it checks whether the ID is still the original (1) or changed to 0 (implying deletion).
     *
     * @throws SQLException
     */
    @Test
    public void testDeleteStudent() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.deleteStudent(1);
        String query = "select * from student where student_ID = 1";
        ResultSet rs = statement.executeQuery(query);
        int result = 0;
        while (rs.next()) {
            result = rs.getInt("student_ID");
        }
        assertEquals(0, result);
    }

    /**
     * This delete method allows for the previous addStuentTwo method to run constantly.
     *
     * @throws SQLException
     */
    @Test
    public void testDeleteStudentTwo() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.deleteStudent(2);
        String query = "select * from student where student_ID = 2";
        ResultSet rs = statement.executeQuery(query);
        int result = 0;
        while (rs.next()) {
            result = rs.getInt("student_ID");
        }
        assertEquals(0, result);
    }

    /**
     * This deletes the class to continue to run constantly
     *
     * @throws SQLException
     */
    @Test
    public void testDeleteClass() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.deleteCourse(111);
        String query = "select * from student where student_ID = 111";
        ResultSet rs = statement.executeQuery(query);
        int result = 0;
        while (rs.next()) {
            result = rs.getInt("course_ID");
        }
        assertEquals(0, result);
    }


    @Test
    public void testCreateExam() throws SQLException{
        Statement statement = JDBC.connection.createStatement();
        JDBC.createExam(1, "Exam1");
        String query = "select exam_number from Exam where name = 'Exam1'";
        ResultSet rs = statement.executeQuery(query);
        int result = 0;
        while (rs.next()){
            result = rs.getInt("exam_number");
        }
        assertEquals(1, result);
    }

    @Test
    public void testCreateExam2() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.createExam(2, "Exam2");
        String query = "select exam_number from Exam where name = 'Exam2'";
        ResultSet rs = statement.executeQuery(query);
        int result = 0;
        while (rs.next()){
            result = rs.getInt("exam_number");
        }
        assertEquals(1, result);
    }

//    @Test
//    public void testAddSysAdmin() throws SQLException {
//        Statement statement = JDBC.connection.createStatement();
//        JDBC.addSysAdmin(1,"Ben", "Stan", "bstan@gmail.com");
//        String query = "select * from sysadmin where admin_ID = 1";
//        ResultSet rs = statement.executeQuery(query);
//        String[] result = new String[4];
//        while (rs.next()) {
//            result[0] = "" + rs.getInt(1);
//            result[1] = rs.getString(2);
//            result[2] = rs.getString(3);
//            result[3] = rs.getString(4);
//        }
//        assertEquals(new String[]{"1", "Ben", "Stan", "bstan@gmail.com"}, result);
//    }

    @Test
    public void testAddExamScore() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.addStudent("John","Ziauddin","Ziauddin@gmail.com", 3.5);
        JDBC.createExam(1, "Test 1", "This is the first test");
        JDBC.addExamScore(1,1,85.5);
        String query = "select exam_grade from student_exam where student_ID = 1";
        ResultSet rs = statement.executeQuery(query);
        double result = 0;
        while (rs.next()) {
            result = rs.getDouble("exam_grade");
        }
        assertEquals(85.5, result, 0);
    }

    @Test
    public void testGetStudentExamScore() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.getStudentExamScore(1,1);
        String query = "select exam_grade from student_exam where student_ID = 1";
        ResultSet rs = statement.executeQuery(query);
        double result = 0.0;
        while (rs.next()){
            result = rs.getInt(3);
        }
        assertEquals(0.0, result, 0.01);
    }

}

