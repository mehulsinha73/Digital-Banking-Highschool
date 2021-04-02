package com.project.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.project.AccountConstant;
import com.project.AccountVO;

public class ChequeListener implements ActionListener{

	JFrame mobileApp;
	JPanel loginSuccPanel;
	
	public ChequeListener(JFrame mobileApp,JPanel loginSuccPanel) {
		this.mobileApp =mobileApp;
		this.loginSuccPanel=loginSuccPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("You clicked Loan Request");
		drawCheque();
		loginSuccPanel.revalidate();
		loginSuccPanel.repaint();
	}

	public void drawCheque() {
		loginSuccPanel.removeAll();
		ArrayList<AccountVO> arlAccount = AccountConstant.getAccounts();
		JLabel welcome = new JLabel("Hello please enter your account number");
		welcome.setBounds(20, 50, 150, 20);
		JTextField accno = new JTextField(15);
		accno.setBounds(160, 50, 30, 20);
		JLabel getleaves = new JLabel("Please enter the number of cheque leaves required");
		getleaves.setBounds(20, 80, 150, 20);
		JTextField leaves = new JTextField(10);
		leaves.setBounds(160, 80, 10, 20);
		
		loginSuccPanel.add(welcome);
		loginSuccPanel.add(accno);
		loginSuccPanel.add(leaves);
		
	}
	
}
