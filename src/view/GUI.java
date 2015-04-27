package view;


import code.QRCode;

import javax.swing.*;
import java.awt.*;


/**
 * @author Boban Jevtic
 * @version 1.2
 */

public class GUI extends JFrame{
	/** Wichtiste Kompomenten für die GUI definieren */
	private JLabel titel, name, qr;
	private JPanel container;

	private static String QRPath;

	private QRCode myqrcode;
	
	/**
	 * 
	 * @param l
	 * Durch den Aufruf waehrend des Erzeugens von ein Objekt, wird ein Platz im Fenster verlangt,
	 * wo das Bild positioniert werden soll im Parameter
	 */
	public GUI() {
		QRPath = "/img/qr.png";

		container = new JPanel();
		titel = new JLabel("TDOTO - Anmeldung");
		name = new JLabel("");
		qr = new JLabel("");

		/* layout setzen */
		this.setLayout(new BorderLayout());
		container.setLayout(new GridLayout(2, 1));

		/* components hinzufügen */
		this.add(container, BorderLayout.SOUTH);
		container.add(titel);
		container.add(name);
		this.add(qr);

		/* frame-configuration */
		this.setTitle("TDOTO - Anmeldung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(460, 550);
		this.setResizable(false);
		this.setVisible(true);

		myqrcode = new QRCode();
	}
	
	public void update(String sid){
		name.setText(sid);

		myqrcode.setFilePath(QRPath);
		myqrcode.generateCode(sid, myqrcode.getFilePath());

		update(ImageImporter.imageToLabel(QRPath));
	}
	
	public void update(JLabel l) {
		System.out.println("update(JLabel l)");

		this.remove(qr);
		qr = l;
		this.add(qr);

		this.repaint();
	}

}
