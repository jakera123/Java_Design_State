package com.zxp.design;

import com.zxp.design.context.Account;

public class StateClient {
	public static void main(String[] args){
		 
		Account account=new Account("zxp");
		
		account.deposit(500.0);
		account.deposit(300.0);
		account.deposit(550.0);
		account.payInterest();
		account.withdraw(2000.00);
		account.withdraw(1100.00);
		
	}

}
