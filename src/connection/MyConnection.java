package connection;


import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


/**
 * @author Boban Jevtic
 * @verison 1.2
 * Wir brauchen eine Connection von SQL
 */

public class MyConnection {
	
	private Connection con = null;
	
	
	/**
	 * Aufbauen den Connection auf zwei Arten:
	 * entweder ueber DataSource oder ich nehme den DriverMananger
	 */
	
	
	/**
	 * Methode, die eine Connection zur Datenbank aufbaut
	 * Wirf eine Exception, falls die keine Verbindung zur Datenbank hergestellt werden kann
	 * @param hostname
	 * @param username
	 * @param password
	 * @param dbName
	 * @return con
	 *
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection connect(String hostname, String username, String password, String dbName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			/**
			 * DataSource, die man für die Verbindung braucht
			 */
			MysqlDataSource ds = new MysqlDataSource();
			
			/**
			 * wir brauchen einen Hostnamen und Datanbanknamen
			 */
			ds.setServerName(hostname);
			ds.setDatabaseName(dbName);
			
			/**
			 * Diese SQL Verbindung bekommt eine MYSQL-Connection
			 * getConnection braucht Username und Passwort
			 */
			con = ds.getConnection(username, password);
				
			return con;
	}
	
	
	/**
	 * 
	 * @return....... Als Resultat wird Connection zurueckgeliefert
	 */
	public Connection getConnection() {
		return this.con;
	}
	
}