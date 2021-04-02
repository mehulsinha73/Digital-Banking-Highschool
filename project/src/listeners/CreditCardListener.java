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

public class CreditCardListener implements ActionListener{

	JPanel loginSuccPanel;
	
	public CreditCardListener(JPanel loginSuccPanel) {
		this.loginSuccPanel=loginSuccPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("You clicked on Credit card Application");
		creditCardPanel();
		loginSuccPanel.revalidate();
		loginSuccPanel.repaint();
	}

	public void creditCardPanel() {
		loginSuccPanel.removeAll();
		ArrayList<AccountVO> arlAccount = AccountConstant.getAccounts();
		
		//String[] vicecard = { "Classic", "Titanium", "Platinum" };
		String[] cardtype = { "Visa", "Master Card" };

		JLabel banner=new JLabel("Credit Card Application");
		banner.setBounds(120, 15,150, 20);
		
		JLabel lblCardType=new JLabel("Card Type");
		lblCardType.setBounds(30, 45,150, 20);
		
		JComboBox<String> cardtypelist = new JComboBox(cardtype);
		cardtypelist.setBounds(140, 45,100, 20);
		
		JLabel lblNameOnCard=new JLabel("Name on Card");
		lblNameOnCard.setBounds(30, 75,100, 20);
		
		JTextField nameOnCard=new JTextField(10);
		nameOnCard.setBounds(140, 75,100, 20);
		
		JButton submit=new JButton("Submit");
		submit.setBounds(100, 135,100, 20);
		
		JComboBox<String> accountList = new JComboBox<String>();
		for(AccountVO obj: arlAccount){
			accountList.addItem(obj.getAccNumber());
		}
		accountList.setBounds(140, 105,130, 20);
		
		JLabel accListLabel=new JLabel("Reference Acc");
		accListLabel.setBounds(30, 105,100, 20);
		
		submit.addActionListener(new CCCompleteListener(loginSuccPanel,cardtypelist,nameOnCard,accountList));
		
		loginSuccPanel.add(banner);
		loginSuccPanel.add(lblCardType);
		loginSuccPanel.add(cardtypelist);
		loginSuccPanel.add(lblNameOnCard);
		loginSuccPanel.add(nameOnCard);
		loginSuccPanel.add(accListLabel);
		loginSuccPanel.add(accountList);
		loginSuccPanel.add(submit);
	}
	
	
	
}
