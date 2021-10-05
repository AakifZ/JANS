package startup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;

public class initServlet  extends HttpServlet {


    @Override
    public void init() throws ServletException {
        try {
            JDBC2.connector();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC2.DBCreationReader();

    }
}
