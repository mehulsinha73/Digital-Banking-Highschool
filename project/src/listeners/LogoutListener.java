package com.project.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class LogoutListener implements ActionListener{

	JFrame mobileApp;
	JPanel loginSuccPanel;
	JMenuBar jmenubar;
	
	public LogoutListener(JFrame mobileApp,JPanel loginSuccPanel,JMenuBar jmenubar) {
		this.mobileApp =mobileApp;
		this.loginSuccPanel=loginSuccPanel;
		this.jmenubar=jmenubar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("logging out");
		JPanel logoutPanel = new JPanel();
		logoutPanel.setBackground(new Color(163, 191, 237));
		JLabel logout = new JLabel("THANK YOU FOR CHOOSING DIGI BANK");
		logout.setBounds(100, 100, 200, 20);
		logoutPanel.setLayout(null);
		logoutPanel.add(logout);
		mobileApp.remove(loginSuccPanel);
		mobileApp.getJMenuBar().removeAll();
		mobileApp.add(logoutPanel);
		mobileApp.setLocationRelativeTo(null);
		mobileApp.invalidate();
		mobileApp.validate();
	}

}
