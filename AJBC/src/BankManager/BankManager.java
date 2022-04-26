package BankManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.AccountProperties;
import AccountOwner.ActivityName;
import AccountOwner.Credentials;
import AppManager.AppManager;

public class BankManager extends AccountOwner{
	private AccountOwner[] usersToApprove;
	private int index = 0;
	private AccountProperties accProperties;
			
	public BankManager(String firstName, String lastName, int areaCode, float number, LocalDate bitrthDate,
			Account account, double monthlyIncome, Credentials credentials) {
		super(firstName, lastName, areaCode, number, bitrthDate, account, monthlyIncome, credentials);
		this.usersToApprove = new AccountOwner[100];
	}
	

	public void setUsersToApprove(AccountOwner accountOwner) {
		this.usersToApprove[index] = accountOwner;
		index++;
	}

	public AccountOwner[] getUsersToApprove() {
		return usersToApprove;
	}

	public void setAndApproveAcc() {
		for (int i = 0; this.usersToApprove[i]!=null; i++) {
			accProperties = AccountProperties.properties(this.usersToApprove[i].getMonthlyIncome());
			Account account = new Account(0,accProperties,null,accProperties.getIntresRateMax(),accProperties.getFeeMax());
			this.usersToApprove[i].setAccount(account);
		}
		usersToApprove = null;
	}
	/*
	 */
	@Override
	public String toString() {
		return super.toString() + "BankManager [usersToApprove=" + ", index=" + index
				+ ", accProperties=" + accProperties + "]";
	}
	
//	public void ProduceReport(LocalDate start) {
//		System.out.println("Enter a LocalDate");
//		LocalDate date =AppManager.addDate();
//		this.checkBalance();
//		this.account.activityData(date);
//	}

//	public void getLoan() {
//		System.out.println("Enter a LocalDate");
//		LocalDate date =AppManager.addDate();
//		this.checkBalance();
//		this.account.activityData(date);
//		
//	}
	
	}
