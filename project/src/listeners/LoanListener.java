package com.project.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.project.AccountConstant;
import com.project.AccountVO;

public class LoanListener implements ActionListener{

	JFrame mobileApp;
	JPanel loginSuccPanel;
	
	public LoanListener(JFrame mobileApp,JPanel loginSuccPanel) {
		this.mobileApp =mobileApp;
		this.loginSuccPanel=loginSuccPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("You clicked Loan Request");
		getLoanPanel();
		loginSuccPanel.revalidate();
		loginSuccPanel.repaint();
	}

	
	public void getLoanPanel() {
		loginSuccPanel.removeAll();
		ArrayList<AccountVO> arlAccount = AccountConstant.getAccounts();
		
		//String[] vicecard = { "Classic", "Titanium", "Platinum" };
		String[] cardtype = { "House Loan", "Car Loan" };

		JLabel banner=new JLabel("Loan Application");
		banner.setBounds(120, 15,150, 20);
		
		JLabel lblCardType=new JLabel("Loan Type");
		lblCardType.setBounds(30, 45,150, 20);
		
		JComboBox<String> cardtypelist = new JComboBox(cardtype);
		cardtypelist.setBounds(140, 45,100, 20);
		
		JLabel lblNameOnCard=new JLabel("Loan Amount");
		lblNameOnCard.setBounds(30, 75,100, 20);
		
		JTextField amount=new JTextField(10);
		amount.setBounds(140, 75,100, 20);
		
		JButton submit=new JButton("Submit");
		submit.setBounds(100, 135,100, 20);
		
		JComboBox<String> accountList = new JComboBox<String>();
		for(AccountVO obj: arlAccount){
			accountList.addItem(obj.getAccNumber());
		}
		accountList.setBounds(140, 105,130, 20);
		
		JLabel accListLabel=new JLabel("Crediting Acc");
		accListLabel.setBounds(30, 105,100, 20);
		
		submit.addActionListener(new LoanCompleteListener(loginSuccPanel,cardtypelist,amount,accountList));
		
		loginSuccPanel.add(banner);
		loginSuccPanel.add(lblCardType);
		loginSuccPanel.add(cardtypelist);
		loginSuccPanel.add(lblNameOnCard);
		loginSuccPanel.add(amount);
		loginSuccPanel.add(accListLabel);
		loginSuccPanel.add(accountList);
		loginSuccPanel.add(submit);
	}
	
}
