import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcJava {
    public static void main(String args[]) throws SQLException {

        int ch = Integer.parseInt(JOptionPane.showInputDialog(
                "SQL OPERATIONS !!! \n 1. Create \n 2. Insert \n 3. Select \n 4. Update \n 5. Delete \n 6. Quit \n \n Enter your Option  : "));

        switch (ch) {

            case 1:
                create();
                break;
            case 2:
                insert();
                break;
            case 3:
                select();
                break;
            case 4:
                update();
                break;
            case 5:
                delete();
                break;
            case 6:
                System.exit(0);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid Choice !!");
        }

        // select();
        // create();
        // insert();

    }

    public static void select() throws SQLException {
        try {
            String url = "jdbc:postgresql://localhost/postgres";
            String user = "postgres";
            String pw = "root";
            Connection conn = DriverManager.getConnection(url, user, pw);
            Statement st = conn.createStatement();

            String selectQuery = JOptionPane.showInputDialog("Enter the Select query ");

            ResultSet rs = st.executeQuery(selectQuery);

            while (rs.next()) {
                JOptionPane.showMessageDialog(null,
                        "ROLLNO   " + rs.getInt(1) + "   NAME   " + rs.getString(2) + "   BCODE   " + rs.getInt(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public static void create() throws SQLException {
        try {
            String url = "jdbc:postgresql://localhost/postgres";
            String user = "postgres";
            String pw = "root";
            Connection conn = DriverManager.getConnection(url, user, pw);
            Statement st = conn.createStatement();

            String createQuery = JOptionPane.showInputDialog("Enter the create query ");

            st.executeUpdate(createQuery);

            JOptionPane.showMessageDialog(null, " Table Created !!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public static void insert() throws SQLException {
        try {
            String url = "jdbc:postgresql://localhost/postgres";
            String user = "postgres";
            String pw = "root";
            Connection conn = DriverManager.getConnection(url, user, pw);
            Statement st = conn.createStatement();

            String insertQuery = JOptionPane.showInputDialog("Enter the insert query ");

            int insert = st.executeUpdate(insertQuery);

            JOptionPane.showMessageDialog(null, insert + " row Affected !");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public static void update() throws SQLException {
        try {
            String url = "jdbc:postgresql://localhost/postgres";
            String user = "postgres";
            String pw = "root";
            Connection conn = DriverManager.getConnection(url, user, pw);
            Statement st = conn.createStatement();

            String updateQuery = JOptionPane.showInputDialog("Enter the update query ");

            int update = st.executeUpdate(updateQuery);

            JOptionPane.showMessageDialog(null, update + " row Affected !");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public static void delete() throws SQLException {
        try {
            String url = "jdbc:postgresql://localhost/postgres";
            String user = "postgres";
            String pw = "root";
            Connection conn = DriverManager.getConnection(url, user, pw);
            Statement st = conn.createStatement();

            String deleteQuery = JOptionPane.showInputDialog("Enter the delete query ");

            int delete = st.executeUpdate(deleteQuery);

            JOptionPane.showMessageDialog(null, delete + " row Affected !");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
