package test;




import java.sql.SQLException;


import javax.swing.JLabel;

import query.Timestamp;
import connection.MyConnection;
import view.GUI;
import view.ImageImporter;
import code.QRCode;


/**
 * 
 * @author Boban Jevtic

 * @version 1.0
 */


/**
 * Diese Klasse ist fuer das Starten des Programmes zustaendig
 */
public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
		
		
		new CardScanner();
		
	}
	
}
