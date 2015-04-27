package test;

import view.GUI;

/**
 * 
 * @author Boban Jevtic

 * @version 1.0
 */


/**
 * Diese Klasse ist fuer das Starten des Programmes zustaendig
 */
public class Main {
	private static GUI g;
	private static CardScanner cs;

	public static void main(String[] args) {
		g = new GUI();
		cs = new CardScanner(g);
	}
	
}
