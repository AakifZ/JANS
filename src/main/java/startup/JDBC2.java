package startup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC2 {

    public static Connection connection = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
connector();
DBCreationReader();
    }

    public static void connector() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306";
            String user = "root";
            String password = "Chocolate123";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("There was an error.");
        }
    }

    public static void DBCreationReader() {
        try {
            Statement statement = connection.createStatement();
            String strCurrentLine;
            StringBuilder fileString = new StringBuilder();

            BufferedReader sqlReader = new BufferedReader(new FileReader("C:\\Users\\ahmed\\IdeaProjects\\Project1\\src\\main\\sql\\gsdatabaseupdated.sql"));
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
        } catch (SQLException a) {
            System.out.println("Issue with reading through the queries.");
            a.printStackTrace();
        } catch (FileNotFoundException b) {
            System.out.println("File is not found, please get another file.");
            b.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unexpected Error has Occurred.");
            e.printStackTrace();
        }
    }

}
