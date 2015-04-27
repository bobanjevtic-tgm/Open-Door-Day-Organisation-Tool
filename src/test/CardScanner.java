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

		this.setLayout(new GridLayout(2, 1));
		this.add(l);
		this.add(t);
		this.add(b);

		this.setTitle("Cardscanner Emulator");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(200, 300);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		gui.update(t.getText());
	}
}
