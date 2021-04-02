package com.project;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.project.listeners.LoginSubmitListener;

public class LaunchPage {
	
	public static JFrame mobileApp = new JFrame();
	public static JPanel loginPanel = new JPanel();
	//public static ArrayList<AccountVO> accounts = null;
	
	public static void main(String args[]){
		mobileApp.setTitle("Welcome to DIGI BANK");
		mobileApp.setUndecorated(true);
		mobileApp.getRootPane().setWindowDecorationStyle(3);
		mobileApp.getContentPane().setBackground(Color.BLUE);
		
		JLabel  lblUserName = new JLabel("UserName",SwingConstants.CENTER);
		lblUserName.setBounds(60, 5, 100, 20);
		JLabel  lblPassword = new JLabel("Password",SwingConstants.CENTER);
		lblPassword.setBounds(60, 35, 100, 20);
		JLabel  lblError = new JLabel();
			
		JTextField userName = new JTextField(10);
		userName.setBounds(190, 5, 120, 20);
		JPasswordField password = new JPasswordField(10);
		password.setBounds(190, 35, 120, 20);
		loginPanel.add(lblUserName);
		loginPanel.add(userName);
		loginPanel.add(lblPassword);
		loginPanel.add(password);
		loginPanel.setLayout(null);
		JButton loginSubmit = new JButton("Submit");
		loginSubmit.setBounds(150 ,70 ,110 ,20);
		lblError.setBounds(120, 100, 200, 20);
		loginSubmit.addActionListener(new LoginSubmitListener(userName, password,mobileApp,lblError,loginPanel));
		loginPanel.add(loginSubmit);
		loginPanel.add(lblError);
		loginPanel.setBackground(new Color(163, 191, 237));
		mobileApp.add(loginPanel);
		mobileApp.setSize(450, 350);
		mobileApp.setLocationRelativeTo(null);
		mobileApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mobileApp.setVisible(true); 
	}
}