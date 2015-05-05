package test;

import view.GUI;

import java.awt.*;

/**
 * Diese Klasse ist fuer das Starten des Programmes zustaendig
 * 
 * @author Boban Jevtic
 * @version 1.0
 */
public class Main {
	private static GUI g;
	private static CardScanner cs;

	public static void main(String[] args) {
		g = new GUI(true);
		cs = new CardScanner(g);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		cs.setLocation((int)(screenSize.getWidth()-cs.getWidth()-10),(int)(screenSize.getHeight()-cs.getHeight()-50));
		cs.setAlwaysOnTop(true);
	}
}
