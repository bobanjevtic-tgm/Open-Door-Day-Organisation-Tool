package view;

import code.QRCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Boban Jevtic
 * @version 1.2
 */
public class GUI extends JFrame{
	private JLabel name;
	private JComponent qr;

	private static String QRPath;

	private QRCode myqrcode;

	public GUI() {
		this(false);
	}

	public GUI(boolean fullScreen) {
		QRPath = "img/qr.png";

		JPanel container = new JPanel();
		JLabel titel = new JLabel("TDOTO - Anmeldung");
		name = new JLabel("");
		qr = new JLabel("Gib mir deine EDU-Card!");

		/* container layout */
		container.setLayout(new GridLayout(2, 1));
		container.add(titel);
		container.add(name);

		/* main layout */
		this.setLayout(new BorderLayout());
		this.add(container, BorderLayout.NORTH);
		this.add(qr);

		/* frame-configuration */
		this.setTitle("TDOTO - Anmeldung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if(fullScreen){
			this.setUndecorated(true);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}else{
			this.setLocation(10, 10);
			this.setSize(460, 550);
			this.setResizable(false);
		}

		this.setVisible(true);

		myqrcode = new QRCode();
		myqrcode.setFilePath(QRPath);
	}
	
	public void update(String sid) {
		if(sid.isEmpty()){
			return;
		}

		name.setText(sid);

		this.update(this.generateQRLabel("http://ip/login?mode=plain&sid=" + sid));
	}
	
	public void update(JLabel l) {
		System.out.println("update(JLabel l)");

		if(qr != null){
			this.remove(qr);
		}
		qr = l;
		this.add(qr);
	}

	private JLabel generateQRLabel(String text){
		myqrcode.generateCode(text, myqrcode.getFilePath());

		try {
			JLabel temp = new JLabel("",SwingConstants.CENTER);
			temp.setIcon(new ImageIcon(ImageIO.read(new File(QRPath))));
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
