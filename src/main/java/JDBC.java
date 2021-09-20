import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    static Connection connection = null;

    public static void main(String[] args) throws ClassNotFoundException {

            try {
                connector();
                DBCreationReader();
            } catch (SQLException e) {
                System.out.println("Could not connect to database.\n   Please try again later.");
            }

        System.out.println(addStudent("Berry", "Johnson", "berJo@gmail.com"));
        System.out.println(addStudent("Jimmy", "Neutron", "brainblast@gmail.com"));
        System.out.println(deleteStudent(1));
        System.out.println(addStudent("Barney", "The big red dog", "berensteinbears@gmail.com"));
    }

    public static void connector() throws ClassNotFoundException, SQLException {
        // establish connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "Chocolate123";
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
     * @param lastName The student's last name
     * @param email The student's email address
     * @return true if the student was added to the database
     * false if the student could not be added to the database
     */
    public static boolean addStudent(String firstName, String lastName, String email) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("insert into student(first_name, last_name, email) values('%s', '%s', '%s')", firstName, lastName, email);
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
}
