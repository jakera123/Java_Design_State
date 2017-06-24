package com.zxp.design.concretestate;

public class RedState extends State{

	private double serviceFee;
	
	public RedState(State state) {
       this.balance=state.getBalance();
       this.account=state.getAccount();
       initialize();
	}

	private void initialize() {
		interest=0.0;
		lowerLimit=-100.0;
		upperLimit=0.0;
		serviceFee=15.00;
	}

	public void deposit(double amount) {
		balance+=amount;
		stateChangeCheck();
		
	}

	private void stateChangeCheck() {
		if(balance>upperLimit){
			account.setState(new SilverState(this));
		}
		
	}

	public void withdraw(double amount) {
		amount=amount-serviceFee;
		System.out.println("No funds available for withdrawal!");
		
	}

	public void payInterest() {
		
	}

}
