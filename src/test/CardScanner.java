package test;
import java.awt.FlowLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.GUI;
import view.ImageImporter;
import code.QRCode;


public class CardScanner {

	private JFrame f;
	private JTextField t;
	private JButton b;
	private JLabel l;
	private static String QRPath;
	private QRCode myqrcode;
	private ImageImporter im;
	
	private GUI gui;
	
	public CardScanner() {
		f = new JFrame();
		l = new JLabel("Id des Schuelers");
		t = new JTextField(30);
		
		QRPath = "C:/Users/Jevtic/workspace/OpenDoorDay/QRCode.png";

		b = new JButton("OK");
		b.addActionListener(new AddActionListener());
		f.setLayout(new FlowLayout());
		f.add(l);
		f.add(t);
		f.add(b);
		f.setVisible(true);
		f.setSize(550,430);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
    	myqrcode = new QRCode();
    	
		
		im = new ImageImporter();
		
		gui = new GUI();
		
		gui.update(new JLabel("test"));

	}
	


	
	private class AddActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			
	    	/** 
	    	 * Setze den Dateipfad
	    	 */
	    	myqrcode.setFilePath(QRPath);
	    	
	        /** Die Id steht im QR-Code drin */
	    	myqrcode.generateCode(t.getText(), myqrcode.getFilePath());
	    	t.repaint();
			
			/**
			 * Fuege ein Bild hinzu im Fenster
			 */
			JLabel l = im.addExistingImage(QRPath);
			gui.update(l);
			gui.update("");
			

		}
	}
	
	
}
