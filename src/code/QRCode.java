package code;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
 
/** Diesen Code habe ich von der folgenden Quelle uebernommen:
 * http://crunchify.com/java-simple-qr-code-generator-example/
 * @author Boban Jevtic
 * @version 1.1
 * 
 */
 
public class QRCode {
	
	
	private int size;
	private String fileType;
	private String filePath;
	
	
	public QRCode() {
		this.size = 300;
		this.fileType = "png";
	}
	
	/**
	 * 
	 * @param filePath: Dateipfad setzen
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * 
	 * @return filePath: Dateipfad zurueckliefern
	 */
	public String getFilePath() {
		return this.filePath;
	}
	
	/**
	 * @param textCode Den Code als Text eingeben
	 * @param filePath Den Dateipfad angeben, wo der QR Code erzeugt werden soll
	 */
	public void generateCode(String textCode, String filePath) {

		/* Datei erzeugen */
        File myFile = new File(filePath);
        try {
            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            
            /* Erzeuge einen neuen Codeschreiber */
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            
            /* Ein CodeWriter, der den verschluesselten Code wieder entschluesselt */
            BitMatrix byteMatrix = qrCodeWriter.encode(textCode,BarcodeFormat.QR_CODE, size, size, hintMap);
            
            /* Laenge und Breite des Bildes ermitteln */
            BufferedImage image = new BufferedImage(byteMatrix.getWidth(), byteMatrix.getWidth(), BufferedImage.TYPE_INT_RGB);
            
            
            /*  Erzeuge eine Graphik von QR */
            image.createGraphics();
 
            /* Eine Grafik, die nur schwarz/weisse Farben hat *, Zeichnen und Färben des Rechtecks */
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, byteMatrix.getWidth(), byteMatrix.getWidth());
            graphics.setColor(Color.BLACK);
 
            /* Bild zeichnen, Groesse des Bildes in der Schleife durchlaufen */
            
            for (int i = 0; i < byteMatrix.getWidth(); i++) {
                for (int j = 0; j < byteMatrix.getWidth(); j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            /* falls das file existiert löschen, dann neu erstellen */
            if(myFile.exists()) myFile.delete();
            myFile.createNewFile();

            /* Image erstellen  */
            ImageIO.write(image, fileType, myFile);

            System.out.println("QR Code has been created successfully!");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
 
}