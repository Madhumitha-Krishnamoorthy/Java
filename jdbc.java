import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class jdbc {

	private final String url = "jdbc:postgresql://localhost/postgres";
	private final String user = "postgres";
	private final String password = "root";

	public Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			JOptionPane.showMessageDialog(null, "Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return conn;
	}

	public static void main(String[] args) {
		jdbc app = new jdbc();
		app.connect();
	}
}
