import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class JDBCTest {

    public void init() throws SQLException, ClassNotFoundException {
        JDBC.main(new String[0]);
    }
    @Test
    public void testAddStudent() {
        JDBC.addStudent("Marty", "McAnt", "mcmarty@gmail.com", 1.4);
    }
}