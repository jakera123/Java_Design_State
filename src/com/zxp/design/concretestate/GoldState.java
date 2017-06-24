package com.zxp.design.concretestate;

import com.zxp.design.context.Account;

public class GoldState extends State{
	
	public GoldState(State state){
		this(state.balance,state.account);
	}

	public GoldState(double balance, Account account) {
		this.balance=balance;
		this.account=account;
		initialize();
	}

	private void initialize() {
		interest=0.05;
		lowerLimit=1000.0;
		upperLimit=10000000.0;
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
		if(balance<0.0){
			account.setState(new RedState(this));
		}else if(balance<lowerLimit){
			account.setState(new SilverState(this));
		}
	}
	
	

}
