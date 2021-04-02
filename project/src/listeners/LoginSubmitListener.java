package com.project.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.project.AccountConstant;
import com.project.AccountVO;
import com.project.validations.Authenticate;

public class LoginSubmitListener implements ActionListener {

	JTextField userName;
	JPasswordField password;
	public ArrayList<AccountVO> accounts = null;
	JFrame mobileApp;
	JLabel  lblError;
	JPanel loginPanel;

	public LoginSubmitListener(JTextField userName, JPasswordField password,
			JFrame mobileApp,JLabel lblError,JPanel loginPanel) {
		this.userName = userName;
		this.password = password;
		this.lblError = lblError;
		this.mobileApp=mobileApp;
		this.loginPanel=loginPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JMenuBar jmenubar = new JMenuBar();

		System.out.println(userName.getText());
		System.out.println(password.getText());
		Authenticate objAuthenticate = new Authenticate();
		accounts = objAuthenticate.authenticateUser(userName.getText(), password.getText(), false);
		AccountConstant.setAccounts(accounts);
		
		if (null != accounts && accounts.size() > 0) {
			JPanel loginSuccPanel = objAuthenticate.drawSuccessPanel(userName.getText());
			loginSuccPanel.setBackground(new Color(163, 191, 237));
			mobileApp.setJMenuBar(jmenubar);
			mobileApp.getJMenuBar().setBackground(new Color(99, 146, 221));
			JMenu home = new JMenu("Home");
			JMenuItem accSummary = new JMenuItem("Account Summary");
			accSummary.addActionListener(new AccSummaryListener(userName.getText(),loginSuccPanel));
			
			JMenuItem logout = new JMenuItem("Log Out");
			logout.addActionListener(new LogoutListener(mobileApp,loginSuccPanel,jmenubar));
			home.add(accSummary);
			home.add(logout);
			jmenubar.add(home);
			
			
			JMenu trans = new JMenu("Transactions");
			JMenuItem fundsTransfer = new JMenuItem("Funds Transfer");
			fundsTransfer.addActionListener(new FundsTransferListener(loginSuccPanel));
			
			JMenuItem bills = new JMenuItem("Bill Payment");
			bills.addActionListener(new BillPaymentListener(loginSuccPanel));
			
			trans.add(bills);
			trans.add(fundsTransfer);
			jmenubar.add(trans);
			
			JMenu app = new JMenu("Applications");
			JMenuItem creditcard = new JMenuItem("Credit Application");
			creditcard.addActionListener(new CreditCardListener(loginSuccPanel));
			
			JMenuItem loan = new JMenuItem("Loan Request");
			loan.addActionListener(new LoanListener(mobileApp, loginSuccPanel));
			
			
			//JMenuItem chequebook = new JMenuItem("Cheque Request");
			//chequebook.addActionListener(new ChequeListener(mobileApp, loginSuccPanel));

			app.add(creditcard);
			app.add(loan);
			//app.add(chequebook);
			jmenubar.add(app);
			
			mobileApp.remove(loginPanel);
			loginSuccPanel.setLayout(null);
			mobileApp.add(loginSuccPanel);
			mobileApp.setLocationRelativeTo(null);
			mobileApp.invalidate();
			mobileApp.validate();
			
		} else {
			lblError.setText("Invalid UserName and Password ..!");
		}

	}

}
