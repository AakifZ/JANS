import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    static Connection connection = null;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while (true) {
            try {
                connector();
                break;
            } catch (SQLException e) {
                System.out.println("Could not connect to database. ");
                continue;
            }
        }
        reader(connection);
    }


    public static void connector() throws ClassNotFoundException, SQLException {

            // establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/gradingsystem";
            String user = "root";
            String password = "Chocolate123";
            connection = DriverManager.getConnection(url, user, password);

        }


    public static void reader(Connection connection1) throws IOException {
        try {
            Statement statement = connection1.createStatement();

            String strCurrentLine = null;

            BufferedReader sqlReader = new BufferedReader(new FileReader(
                    "...\\sql\\gsdatbase.sql"));
            while ((strCurrentLine = sqlReader.readLine()) != null) {
                statement.executeUpdate(strCurrentLine);
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
