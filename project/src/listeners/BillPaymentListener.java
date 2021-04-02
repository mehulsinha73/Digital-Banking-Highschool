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

public class BillPaymentListener implements ActionListener{

	
	JPanel loginSuccPanel;
	
	public BillPaymentListener(JPanel loginSuccPanel) {
		this.loginSuccPanel=loginSuccPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("You clicked on Bill Payment");
		drawBillPayment();
		loginSuccPanel.setLayout(null);
		loginSuccPanel.revalidate();
		loginSuccPanel.repaint();
	}

	private void drawBillPayment(){
		loginSuccPanel.removeAll();
		ArrayList<AccountVO> arlAccount = AccountConstant.getAccounts();
		
		JLabel banner=new JLabel("BillPayment(IMM)");
		banner.setBounds(120, 15,150, 20);
		
		JLabel welcome=new JLabel("Benificiary's name");
		welcome.setBounds(30, 45,150, 20);
		JTextField benificiary=new JTextField(25);
		benificiary.setBounds(140, 45,100, 20);
		JLabel amtinfo=new JLabel("Amount");
		amtinfo.setBounds(30, 75,100, 20);
		JTextField amount=new JTextField(10);
		amount.setBounds(140, 75,100, 20);
		
		JButton submit=new JButton("Submit");
		
		JComboBox<String> accountList = new JComboBox<String>();
		for(AccountVO obj: arlAccount){
			accountList.addItem(obj.getAccNumber());
		}
				
		accountList.setBounds(140, 105,130, 20);
		JLabel accListLabel=new JLabel("Debiting Account");
		accListLabel.setBounds(30, 105,100, 20);
		
		submit.setBounds(100, 135,100, 20);
		
		JLabel errMsg=new JLabel("");
		errMsg.setBounds(30, 155,100, 20);
		
		submit.addActionListener(new BPCompleteListener(loginSuccPanel,benificiary,amount,accountList,errMsg));
		loginSuccPanel.add(banner);
		loginSuccPanel.add(welcome);
		loginSuccPanel.add(benificiary);
		loginSuccPanel.add(amtinfo);
		loginSuccPanel.add(amount);
		loginSuccPanel.add(accListLabel);
		loginSuccPanel.add(accountList);
		loginSuccPanel.add(submit);
		loginSuccPanel.add(errMsg);
	}
}
