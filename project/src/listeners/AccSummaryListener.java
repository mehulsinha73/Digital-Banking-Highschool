package com.project.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.project.AccountConstant;
import com.project.AccountVO;

public class AccSummaryListener implements ActionListener{
	
	String userName;
	JPanel loginSuccPanel;
	
	public AccSummaryListener(String userName,JPanel loginSuccPanel) {
		this.userName=userName;
		this.loginSuccPanel=loginSuccPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("You clicked on Account  Summary");
		loginSuccPanel.removeAll();
		
		loginSuccPanel.setName("LoginSuccPanel");
    	JLabel  lblError = new JLabel(greetingMsg()+" "+userName+" ..!");
    	lblError.setBounds(30, 30, 200, 20);
    	loginSuccPanel.add(lblError);
    	int yaxis = 60;
    	ArrayList<AccountVO> accounts = AccountConstant.getAccounts();
    	for(AccountVO objAccountVO: accounts){
    		JLabel accNumber = new JLabel();
    		accNumber.setText(objAccountVO.getAccNumber() + " "+ objAccountVO.getCurrency() + " "+objAccountVO.getBalance().setScale(2, BigDecimal.ROUND_UP));
    		accNumber.setBounds(30, yaxis, 200, 20);
    		yaxis = yaxis + 30;
    		loginSuccPanel.add(accNumber);
    	}	
    	
    	loginSuccPanel.revalidate();
		loginSuccPanel.repaint();
	}
	
	
	private String greetingMsg(){
        Date dt = new Date();
        int hours = dt.getHours();
        int min = dt.getMinutes();
        if(hours>=1 || hours<=12)
            return "Good Morning";
        else if(hours>=12 || hours<=16)
            return "Good Afternoon";
        else if(hours>=16 || hours<=21)
           return "Good Evening";
        else if(hours>=21 || hours<=24)
            return "Good Night";
        else
        	return null;
        }
}
