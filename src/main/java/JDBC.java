import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC {
    static Connection connection = null;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while (true) {
            try {
                connector();
                break;
            } catch (SQLException e) {
                System.out.println("Could not connect to database.");
                continue;
            }
        }
        reader(connection);
    }

    public static void connector() throws ClassNotFoundException, SQLException {
            // establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        }

    public static void reader(Connection connection1) throws IOException {
        try {
            Statement statement = connection1.createStatement();
            String strCurrentLine = null;
            String fileString = "";

            BufferedReader sqlReader = new BufferedReader(new FileReader("src\\main\\sql\\gsdatabase.sql"));

            while ((strCurrentLine = sqlReader.readLine()) != null) {
                if(strCurrentLine.length() < 1 || strCurrentLine.substring(0,2).equals("--")) {
                    continue;
                }
                fileString += strCurrentLine;
            }

            String[] queries = fileString.split(";");
            for (String q: queries) {
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
}
