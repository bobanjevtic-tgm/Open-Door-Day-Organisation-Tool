package query;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;


import connection.MyConnection;


/**
 * Diese Klasse ist nur fuer den Zeitstempel zustaendig.
 * 
 * @author Boban Jevtic
 * @version 1.0
 *
 */

public class Timestamp {
	
	private MyConnection con;
	private Statement st;
	private ResultSet rs;
	
	public Timestamp(MyConnection c) {
		this.con = c;
	}
	
	

	/**
	 * Methode, die den aktuellen Datum und Uhrzeit in der Datenbank
	 * abfragt (ausliest)
	 * @return output
	 * @throws SQLException
	 */
	public String executeQuery() throws SQLException {
		String output = "";
		st = con.getConnection().createStatement();
		rs = st.executeQuery("SELECT NOW()");
		while(rs.next()) {
			output += rs.getString(1);
		}
		return output;
		
	}
	
	/**
	 * Methode, die den Zeitstempel in die Tabelle timer von der Datenbank als Eintrag speichert
	 * @throws SQLException
	 */
	public void insert() throws SQLException {
		st = con.getConnection().createStatement();
		String sql = "INSERT INTO timer VALUES" + "("+"'"+executeQuery()+"'"+")";
		st.executeUpdate(sql);
		
		
	}

	/**
	 * Methode, die alles von einer Tabelle loescht
	 * @param tableName
	 * @throws SQLException
	 */
	public void delete(String tableName) throws SQLException {
		st = con.getConnection().createStatement();
		String sql = "DELETE FROM " +tableName;
		st.executeUpdate(sql);
	}
	
	public static void main(String []args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		MyConnection con = new MyConnection();
		con.connect("localhost", "root", "1997", "tdot");
		Timestamp t = new Timestamp(con);
		t.insert();
		t.delete("timer");
	}
	
}
