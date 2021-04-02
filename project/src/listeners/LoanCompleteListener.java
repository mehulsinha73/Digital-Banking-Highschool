package com.project.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.project.AccountConstant;
import com.project.AccountVO;

public class LoanCompleteListener implements ActionListener {

	
	JPanel loginSuccPanel;
	JComboBox<String> cardType;
	JTextField nameOnCard;
	JComboBox<String> accountList;
	
	public LoanCompleteListener(JPanel loginSuccPanel,JComboBox<String> cardType,JTextField nameOnCard,JComboBox<String> accountList) {
		this.loginSuccPanel = loginSuccPanel;
		this.cardType = cardType;
		this.nameOnCard = nameOnCard;
		this.accountList = accountList;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		loginSuccPanel.removeAll();
		ArrayList<AccountVO> arlAccount = AccountConstant.getAccounts();
		
		JLabel banner=new JLabel("Loan Application");
		banner.setBounds(120, 15,150, 20);
		
		JLabel lblCardType=new JLabel("Loan Type");
		lblCardType.setBounds(30, 45,150, 20);
		
		JLabel cardtypelist = new JLabel(cardType.getSelectedItem().toString());
		cardtypelist.setBounds(140, 45,100, 20);
		
		JLabel lblNameOnCard=new JLabel("Loan Amount");
		lblNameOnCard.setBounds(30, 75,100, 20);
		
		JLabel amount=new JLabel(nameOnCard.getText());
		amount.setBounds(140, 75,100, 20);
		
		JLabel accountList = new JLabel(this.accountList.getSelectedItem().toString());
		accountList.setBounds(140, 105,130, 20);
		
		JLabel accListLabel=new JLabel("Crediting Acc");
		accListLabel.setBounds(30, 105,100, 20);
		
		loginSuccPanel.add(banner);
		loginSuccPanel.add(lblCardType);
		loginSuccPanel.add(cardtypelist);
		loginSuccPanel.add(lblNameOnCard);
		loginSuccPanel.add(amount);
		loginSuccPanel.add(accListLabel);
		loginSuccPanel.add(accountList);
		loginSuccPanel.revalidate();
		loginSuccPanel.repaint();
	}

}
