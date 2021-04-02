package com.project;

import java.math.BigDecimal;
/**
 * Write a description of class AccountVO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AccountVO
{
    // instance variables - replace the example below with your own
    private String accNumber;
    private BigDecimal balance;
    private String currency;
    
    public void setAccNumber(String accNumber){
        this.accNumber = accNumber;
    }
    
    public String getAccNumber(){
        return this.accNumber;
    }
   
    public void setCurrency(String currency){
        this.currency = currency;
    }
    
    public String getCurrency(){
        return this.currency;
    }
    
    public void setBalance(BigDecimal balance){
        this.balance= balance;
    }
    
    public BigDecimal getBalance(){
        return this.balance;
    }
}
