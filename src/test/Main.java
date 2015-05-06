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
		boolean fullScreen = false;

		g = new GUI(fullScreen);
		cs = new CardScanner(g);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		if(fullScreen){
			cs.setLocation((int)(screenSize.getWidth()-cs.getWidth()-10),(int)(screenSize.getHeight()-cs.getHeight()-50));
		}else{
			cs.setLocation(g.getWidth()+20,10);
		}
		cs.setAlwaysOnTop(true);
	}
}
