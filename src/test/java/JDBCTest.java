import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class JDBCTest {

    @BeforeClass
    public static void init() throws SQLException, ClassNotFoundException {
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
     * @throws SQLException
     */
    @Test
    public void testAddStudentTwo() throws SQLException {
        Statement statement = JDBC.connection.createStatement();

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

    /**
     * This tests the addClass method.
     * @throws SQLException
     */
    @Test
    public void testAddClass() throws SQLException {
        Statement statement = JDBC.connection.createStatement();
        JDBC.addCourse(123, 111,"Softeware Engineering", "This is a required course");
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
        assertEquals(new String[]{"123", "111", "Software Engineering", "This is a required"}, result);
    }

    /**
     * This tests the deleteStudent method. When the student has been deleted, his/her ID number would be 0. Upon deletion of
     * the first student, it checks whether the ID is still the original (1) or changed to 0 (implying deletion).
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

}

