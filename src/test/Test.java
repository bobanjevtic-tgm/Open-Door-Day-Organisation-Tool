package test;


import static org.junit.Assert.*;

import javax.swing.JLabel;

import view.ImageImporter;



public class Test {

	/**
	 * @author Boban Jevtic
	 * @version 1.0
	 */
	
	@org.junit.Test
	public void testAddImage() {
		ImageImporter im = new ImageImporter();
		assertEquals(new JLabel(),im.addExistingImage("C:/Users/Jevtic/workspace/OpenDoorDay/QRCode.png"));
	}
	
	

}

