package com.amittaigames.ludumgl.graphics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AlertWindow {

	private JFrame frame;
	
	// Create an AlertWindow
	public AlertWindow(String title, String message, boolean closable) {
		frame = new JFrame(title);
		frame.setSize(350, 150);
		frame.setResizable(false);
		if (closable) {
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} else {
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel text = new JLabel(message, SwingConstants.CENTER);
		panel.add(text, BorderLayout.CENTER);
		
		frame.setContentPane(panel);
	}
	
	// Show that alert window
	public void show() {
		frame.setVisible(true);
	}
	
	// Destroy that alert window (necessary if the alert cannot be user closed)
	public void destroy() {
		frame.dispose();
	}
	
}