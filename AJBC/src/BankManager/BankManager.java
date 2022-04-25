package BankManager;

import java.time.LocalDate;
import java.util.Arrays;

import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.AccountProperties;
import AccountOwner.Credentials;

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


	private void setAndApproveAcc() {
		for (int i = 0; this.usersToApprove[i]!=null; i++) {
			accProperties = AccountProperties.properties(this.usersToApprove[i].getMonthlyIncome());
			Account account = new Account(0,accProperties,null,accProperties.getIntresRateMax(),accProperties.getFeeMax());
			this.usersToApprove[i].setAccount(account);
		}
		usersToApprove = null;
	}
	@Override
	public String toString() {
		return super.toString() + "BankManager [usersToApprove="  + Arrays.toString(usersToApprove) + ", index=" + index
				+ ", accProperties=" + accProperties + "]";
	}


	private void addUserToApprove(AccountOwner accountOwner) {
		
	}
	private void produceReport(LocalDate start) {
		
	}

}
