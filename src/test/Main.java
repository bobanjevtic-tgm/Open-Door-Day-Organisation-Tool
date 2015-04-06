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
		
    	QRCode myqrcode = new QRCode();
    	
    	/** 
    	 * Setze den Dateipfad
    	 */
    	myqrcode.setFilePath("C:/Users/Jevtic/workspace/OpenDoorDay/QRCode.png");
    	
        /** Die Id steht im QR-Code drin */
    	myqrcode.generateCode("Hello World", myqrcode.getFilePath());
		
		ImageImporter im = new ImageImporter();
		
		/**
		 * Fuege ein Bild hinzu im Fenster
		 */
		JLabel l = im.addExistingImage("C:/Users/Jevtic/workspace/OpenDoorDay/QRCode.png");
		
		GUI gui = new GUI(l);
		
		MyConnection con = new MyConnection();
		con.connect("localhost", "root", "1997", "tdot");
		Timestamp t = new Timestamp(con);
		t.insert();
		
	}
	
}
