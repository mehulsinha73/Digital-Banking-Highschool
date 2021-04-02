package com.project.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.project.AccountConstant;
import com.project.AccountVO;

public class BPCompleteListener implements ActionListener{

	JPanel loginSuccPanel;
	JTextField benificiary;
	JTextField amount;
	JComboBox<String> accountList;
	JLabel errMsg;
	
	public BPCompleteListener(JPanel loginSuccPanel,JTextField benificiary,JTextField amount,JComboBox<String> accountList,JLabel errMsg) {
		this.loginSuccPanel = loginSuccPanel;
		this.benificiary = benificiary;
		this.amount = amount;
		this.accountList = accountList;
		this.errMsg = errMsg;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<AccountVO> arlAccount = AccountConstant.getAccounts();
		Pattern pattern = Pattern.compile("\\d+.\\d+"); //correct pattern for both float and integer.
		boolean result = pattern.matcher(amount.getText()).matches();
        if(result){
        	loginSuccPanel.removeAll();
    		
    		JLabel banner=new JLabel("BillPayment(IMM)");
    		banner.setBounds(120, 15,150, 20);
    		
    		JLabel message=new JLabel("BillPayment has been completed successfully");
    		message.setBounds(30, 45,300, 20);
    		
    		JLabel welcome=new JLabel("Benificiary's Name");
    		welcome.setBounds(30, 75,150, 20);
    		
    		JLabel lblBenificiary=new JLabel(benificiary.getText());
    		lblBenificiary.setBounds(140, 75,100, 20);
    		
    		JLabel amtinfo=new JLabel("Amount");
    		amtinfo.setBounds(30, 105,100, 20);
    		
    		JLabel lblAmount=new JLabel(amount.getText());
    		lblAmount.setBounds(140, 105,100, 20);
    		
    		BigDecimal txnAmt = new BigDecimal(amount.getText());
    		String latestBalance ="";
    		for(AccountVO obj: arlAccount){
    			if(obj.getAccNumber().equalsIgnoreCase(accountList.getSelectedItem().toString())){
    				obj.setBalance(obj.getBalance().subtract(txnAmt));
    				latestBalance = obj.getBalance().setScale(2, BigDecimal.ROUND_UP).toString();
    			}
    		}
    		AccountConstant.setAccounts(arlAccount);
    		
    		JLabel lblAccountList = new JLabel(accountList.getSelectedItem().toString() + "  ("+latestBalance+")");
    		lblAccountList.setBounds(140, 135,200, 20);
    		
    		JLabel accListLabel=new JLabel("Debiting Account");
    		accListLabel.setBounds(30, 135,100, 20);
    		
    		loginSuccPanel.add(banner);
    		loginSuccPanel.add(message);
    		loginSuccPanel.add(welcome);
    		loginSuccPanel.add(lblBenificiary);
    		loginSuccPanel.add(amtinfo);
    		loginSuccPanel.add(lblAmount);
    		loginSuccPanel.add(accListLabel);
    		loginSuccPanel.add(lblAccountList);
        }else{
        	this.errMsg.setText("Invalid Amount ..!");
        }
		
		loginSuccPanel.revalidate();
		loginSuccPanel.repaint();
	}
	
}
