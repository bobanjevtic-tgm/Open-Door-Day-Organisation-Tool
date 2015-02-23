package view;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import code.QRCode;


/**
 * @author Boban Jevtic
 * @version 1.1
 */

public class GUI {
	
	/** Wichtiste Kompomenten f�r die GUI definieren */
	private JFrame f;
	private Container c;
	private JTextField name;
	private JTextArea text;
	private JLabel l1;
	
	
	/**
	 * 
	 * @param l
	 * Durch den Aufruf waehrend des Erzeugens von ein Objekt, wird ein Platz im Fenster verlangt,
	 * wo das Bild positioniert werden soll im Parameter
	 */
	public GUI(JLabel l) {	
		this.f = new JFrame("Anmeldung");
		this.c =  new Container();
		this.l1 = new JLabel("Name: ");
		this.name = new JTextField(15);
		this.text = new JTextArea(20,30);
		/** Layouts setzen */
		this.c.setLayout(new GridLayout(2,2));
		this.f.setLayout(new FlowLayout());
		
		
		/** Components hinzufuegen */
		
		this.c.add(this.l1);
		this.c.add(this.name);
		

		
		/** Components zu JFrame hinzufuegen */
		
		this.f.add(this.c);
		this.f.add(l);
		
		
		this.f.setSize(460, 550);
		
		this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.f.setVisible(true);
		
	}
	
	/**
	 * Testmethode
	 * @param args
	 */

	public static void main(String [] args) {
		
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
		
		
		
	}

	
}
