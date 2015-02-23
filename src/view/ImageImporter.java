package view;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



/**
 * 
 * @author Boban Jevtic
 * @version 1.1
 *
 */


public class ImageImporter {
	
        /**
         * 
         * @param Angabe des Dateipfades
         * @return label
         * Methode, die ein Bild in die GUI einbinden kann, welches schon im System existiert
         */
        public JLabel addExistingImage(String text) {
        	ImageIcon icon = new ImageIcon(text);
        	JLabel label = new JLabel(icon);
        	return label;
        }
}
