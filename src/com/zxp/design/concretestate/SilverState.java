package com.zxp.design.concretestate;

import com.zxp.design.context.Account;

public class SilverState extends State{
	
	public SilverState(State state){
		this(state.balance,state.account);
	}
	
	

	public SilverState(double balance, Account account) {
		this.balance=balance;
		this.account=account;
		initialize();
	}



	private void initialize() {
		interest=0.0;
		lowerLimit=0.0;
		upperLimit=1000.0;
	}



	public void deposit(double amount) {
		balance+=amount;
		stateChangeCheck();
	}

	public void withdraw(double amount) {
		balance-=amount;
		stateChangeCheck();
		
	}

	public void payInterest() {
		balance+=interest*balance;
		stateChangeCheck();
	}



	private void stateChangeCheck() {
		if(balance<lowerLimit){
			account.setState(new RedState(this));
		}
		else if(balance>upperLimit){
			account.setState(new GoldState(this));
		}
	}
	

}
