package com.project.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CCCompleteListener implements ActionListener {

	
	JPanel loginSuccPanel;
	JComboBox<String> cardType;
	JTextField nameOnCard;
	JComboBox<String> accountList;
	
	public CCCompleteListener(JPanel loginSuccPanel,JComboBox<String> cardType,JTextField nameOnCard,JComboBox<String> accountList) {
		this.loginSuccPanel = loginSuccPanel;
		this.cardType = cardType;
		this.nameOnCard = nameOnCard;
		this.accountList = accountList;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		loginSuccPanel.removeAll();

		JLabel banner=new JLabel("Credit Card Application");
		banner.setBounds(120, 15,150, 20);
		
		JLabel lblCardType=new JLabel("Card Type");
		lblCardType.setBounds(30, 45,150, 20);
		
		JLabel cardtypelist = new JLabel(cardType.getSelectedItem().toString());
		cardtypelist.setBounds(140, 45,100, 20);
		
		JLabel lblNameOnCard=new JLabel("Name on Card");
		lblNameOnCard.setBounds(30, 75,100, 20);
		
		JLabel nameOnCard=new JLabel(this.nameOnCard.getText());
		nameOnCard.setBounds(140, 75,100, 20);
		
		JLabel accountList = new JLabel(this.accountList.getSelectedItem().toString());
		accountList.setBounds(140, 105,130, 20);
		
		JLabel accListLabel=new JLabel("Reference Acc");
		accListLabel.setBounds(30, 105,100, 20);
		
		
		loginSuccPanel.add(banner);
		loginSuccPanel.add(lblCardType);
		loginSuccPanel.add(cardtypelist);
		loginSuccPanel.add(lblNameOnCard);
		loginSuccPanel.add(nameOnCard);
		loginSuccPanel.add(accListLabel);
		loginSuccPanel.add(accountList);
		loginSuccPanel.revalidate();
		loginSuccPanel.repaint();
	}

}
