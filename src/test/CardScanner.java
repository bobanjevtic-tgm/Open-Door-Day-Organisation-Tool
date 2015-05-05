package test;

import view.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CardScanner extends JFrame implements ActionListener {

	private JLabel l;
	private JTextField t;
	private JButton b;
	
	private GUI gui;
	
	public CardScanner(GUI gui) {
		this.gui = gui;

		l = new JLabel("Schueler-ID:");
		t = new JTextField(30);
		b = new JButton("scan");
		b.addActionListener(this);

		this.setLayout(new GridLayout(3, 1));
		this.add(l);
		this.add(t);
		this.add(b);

		/* frame config */
		this.setTitle("Cardscanner Emulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(300, 100);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		gui.update(t.getText());
	}
}
