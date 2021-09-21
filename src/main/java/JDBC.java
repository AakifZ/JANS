import java.io.*;
import java.math.BigDecimal;
import java.sql.*;

public class JDBC {
    static Connection connection = null;

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            connector();
            DBCreationReader();
        } catch (SQLException e) {
            System.out.println("Could not connect to database.\n   Please try again later.");
        }

        System.out.println(addStudent("Berry", "Johnson", "berJo@gmail.com", 4));
        System.out.println(addStudent("Jimmy", "Neutron", "brainblast@gmail.com", 4));
        System.out.println(deleteStudent(1));
        System.out.println(addStudent("Barney", "The big red dog", "berensteinbears@gmail.com", 4));
        System.out.println(addStudent("Fred", "Fazbear", "FredF123@aol.com", 3.5));
        System.out.println(addStudent("Johnny", "Appleseed", "JApple@gmail.com", 3.2));
        System.out.println("Student 1's gpa is: " + getStudentGPA(1));
        System.out.println("Student 5's gpa is: " + getStudentGPA(5));
    }

    public static void connector() throws ClassNotFoundException, SQLException {
        // establish connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "Marshallaw1";
        connection = DriverManager.getConnection(url, user, password);
    }

    public static void DBCreationReader() {
        try {
            Statement statement = connection.createStatement();
            String strCurrentLine;
            StringBuilder fileString = new StringBuilder();

            BufferedReader sqlReader = new BufferedReader(new FileReader("src\\main\\sql\\gsdatabase.sql"));

            while ((strCurrentLine = sqlReader.readLine()) != null) {
                if (strCurrentLine.length() < 1 || strCurrentLine.startsWith("--")) {
                    continue;
                }
                fileString.append(strCurrentLine);
            }

            String[] queries = fileString.toString().split(";");
            for (String q : queries) {
                statement.executeUpdate(q);
            }

            sqlReader.close();

        } catch (SQLException a) {
            System.out.println("Issue with reading through the queries.");
            a.printStackTrace();
        } catch (FileNotFoundException b) {
            System.out.println("File is not found, please get another file.");
        } catch (Exception e) {
            System.out.println("Unexpected Error has Occurred.");
        }
    }

    /**
     * Adds a student to the database and auto assigns the student an ID number
     *
     * @param firstName The student's first name
     * @param lastName  The student's last name
     * @param email     The student's email address
     * @param gpa       The student's semester gpa
     * @return true if the student was added to the database
     * false if the student could not be added to the database
     */
    public static boolean addStudent(String firstName, String lastName, String email, double gpa) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("insert into student(first_name, last_name, email, gpa) values('%s', '%s', '%s', '%f')", firstName, lastName, email, gpa);
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("There was a problem adding the student. Please try again.");
        }
        return result > 0;
    }

    public static boolean deleteStudent(int IDNumber) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("delete from student where student_ID = %d", IDNumber);
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("There was a problem deleting the student. Please try again.");
        }
        return result > 0;
    }

    public static BigDecimal getStudentGPA(int IDNumber) {
        BigDecimal gpa = new BigDecimal("0.0");
        try {
            Statement statement = connection.createStatement();
            String query = String.format("select gpa from student where student_ID = %d", IDNumber);
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                //gpa = rs.getDouble("gpa");
                //gpa = rs.getFloat("gpa");
                gpa = rs.getBigDecimal("gpa");

            }
        } catch (SQLException e) {
            System.out.println("There was a problem locating the student's GPA");


        }
        return gpa;
    }
}