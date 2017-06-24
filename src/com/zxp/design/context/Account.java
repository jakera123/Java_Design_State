package com.zxp.design.context;

import com.zxp.design.concretestate.SilverState;
import com.zxp.design.concretestate.State;

public class Account {
	
	private State state;
	private String owner;
	
    
	
	public Account(String owner) {
		//新开的帐户为Silver状态
		this.owner = owner;
		this.state=new SilverState(0.0,this);
	}

	public State getState(){
		return state;
	}


	public void setState(State state) {
		this.state=state;
	}
	
	public void deposit(double amount){
		state.deposit(amount);
		System.out.println(owner+"deposit"+amount);
		System.out.println(owner+"Balance="+state.getBalance());
		System.out.println("Status="+state.getClass().getSimpleName());
		System.out.println("==============================");
	}
	public void withdraw(double amount){
		state.withdraw(amount);
		System.out.println(owner+"Withdrew"+amount);
		System.out.println(owner+"Balance="+state.getBalance());
		System.out.println("Status="+state.getClass().getSimpleName());
		System.out.println("==============================");
	}
	public void payInterest(){
		state.payInterest();
		System.out.println(owner+"Interest Paid");
		System.out.println(owner+"Balance="+state.getBalance());
		System.out.println("Status="+state.getClass().getSimpleName());
		System.out.println("==============================");
	}
	
	
	

}
