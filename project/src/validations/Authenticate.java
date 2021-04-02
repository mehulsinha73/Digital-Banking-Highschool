package com.project.validations;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

import com.project.AccountConstant;
import com.project.AccountVO;
public class Authenticate
{
    public ArrayList<AccountVO> authenticateUser(String userName,String password,boolean connectToDB){
        ArrayList<AccountVO> accounts = null;        
        if(!connectToDB){
        if(userName.equals("12345678") && 
                password.equals("12345678")){
                    accounts = new ArrayList<AccountVO>();
                    
                    AccountVO account1 = new AccountVO();
                    account1.setAccNumber("0720012345623");
                    account1.setCurrency("INR");
                    account1.setBalance(new BigDecimal(5003.78));                    
                    accounts.add(account1);
                    
                    AccountVO account2 = new AccountVO();
                    account2.setAccNumber("0720012345624");
                    account2.setCurrency("INR");
                    account2.setBalance(new BigDecimal(5003.78));                    
                    accounts.add(account2);
                    
                    return accounts;
            }else if(userName.equals("sasi12") && 
                password.equals("password123")){
                    accounts = new ArrayList<AccountVO>();
                    
                    AccountVO account2 = new AccountVO();
                    account2.setAccNumber("0720012345645");
                    account2.setCurrency("INR");
                    account2.setBalance(new BigDecimal(5003.78));   
                    accounts.add(account2);
                    
                    return accounts;
            }else{
                return accounts;
            }
        }else{
            return accounts;
        }
    }
    
      public JPanel drawSuccessPanel(String userName){
    	ArrayList<AccountVO> arlAccount = AccountConstant.getAccounts();
    	JPanel loginSuccPanel = new JPanel();
    	loginSuccPanel.setName("LoginSuccPanel");
    	JLabel  lblError = new JLabel(greetingMsg()+" "+userName+" ..!");
    	lblError.setBounds(30, 30, 200, 20);
    	loginSuccPanel.add(lblError);
    	int yaxis = 60;
    	for(AccountVO objAccountVO: arlAccount){
    		JLabel accNumber = new JLabel();
    		accNumber.setText(objAccountVO.getAccNumber() + " "+ objAccountVO.getCurrency() + " "+objAccountVO.getBalance().setScale(2, BigDecimal.ROUND_UP));
    		accNumber.setBounds(30, yaxis, 200, 20);
    		yaxis = yaxis + 30;
    		loginSuccPanel.add(accNumber);
    	}	
    	return loginSuccPanel;
    }
    
    @SuppressWarnings("deprecation")
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