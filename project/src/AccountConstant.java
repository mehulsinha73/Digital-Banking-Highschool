package com.project;

import java.util.ArrayList;

public class AccountConstant {

	public static volatile long counter = 0L; 
	public static ArrayList<AccountVO> accounts = null;
	
	public static long getCounter() {
		return counter;
	}
	public static void setCounter(long counter) {
		AccountConstant.counter = counter;
	}
	public static ArrayList<AccountVO> getAccounts() {
		return accounts;
	}
	public static void setAccounts(ArrayList<AccountVO> accounts) {
		AccountConstant.accounts = accounts;
	}
	
	
	
}
