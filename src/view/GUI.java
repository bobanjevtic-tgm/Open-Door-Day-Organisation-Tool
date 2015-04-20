package view;



import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import test.CardScanner;
import code.QRCode;


/**
 * @author Boban Jevtic
 * @version 1.2
 */

public class GUI {
	
	/** Wichtiste Kompomenten für die GUI definieren */
	private JFrame f;
	private Container c;
	private JTextField name;
	private JTextArea text;
	private JLabel l1;
	private CardScanner cs;
	private QRCode myqrcode;
	
	/**
	 * 
	 * @param l
	 * Durch den Aufruf waehrend des Erzeugens von ein Objekt, wird ein Platz im Fenster verlangt,
	 * wo das Bild positioniert werden soll im Parameter
	 */
	public GUI() {
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
		

	
		
		this.f.setSize(460, 550);
		
		this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.f.setVisible(true);
		myqrcode = new QRCode();
    	
 		
	}
	
	public void update(String sid){

	}
	
	public void update(JLabel l) {
		System.out.println("update(JLabel l)");
		
		this.f.add(l);
		this.f.repaint();
	}

}
