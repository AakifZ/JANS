import java.sql.*;

public class AdminDAO {

    public static void main(String[] args) throws SQLException {
        AdminDAO ad = new AdminDAO();
        ad.checkLogin(1,"pass");
    }

    public boolean checkLogin(int ID, String password) throws SQLException {
        ResultSet rs = null;
        try {
        String query = "select * from sysadminlogins where ID = ? and password = ?";
        PreparedStatement ps = JDBC2.connection.prepareStatement(query);
        ps.setInt(1,ID);
        ps.setString(2,password);
        rs = ps.executeQuery(); }
        catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return rs.next() == true;
    }

    public boolean checkLogin(String email, String password) throws SQLException {
        ResultSet rs = null;
        try {
            String query = "select * from sysadminlogins where email = ? and password = ?";
            PreparedStatement ps = JDBC2.connection.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2,password);
            rs = ps.executeQuery(); }
        catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return rs.next() == true;
    }


}
