package AccountOwner;

import java.time.LocalDate;

import BankManager.BankManager;
import Person.Person;

public class AccountOwner extends Person{
	
	private Account account;
	private double monthlyIncome;
	public Credentials credentials;
	private BankManager bankManager;

	public double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	@Override
	public String toString() {
		return "AccountOwner [account=" + account + ", monthlyIncome=" + monthlyIncome + ", credentials=" + credentials
				+ ", bankManager=" + bankManager + "]";
	}

	public AccountOwner(String firstName, String lastName, int areaCode, float number, LocalDate bitrthDate,
			Account account, double monthlyIncome, Credentials credentials,BankManager bankManager) {
		super(firstName, lastName, areaCode, number, bitrthDate);
		this.setAccount(account);
		this.monthlyIncome = monthlyIncome;
		this.credentials = credentials;
		this.bankManager = bankManager;
	}
	
	public AccountOwner(String firstName, String lastName, int areaCode, float number, LocalDate bitrthDate,
			Account account, double monthlyIncome, Credentials credentials) {
		super(firstName, lastName, areaCode, number, bitrthDate);
		this.setAccount(account);
		this.monthlyIncome = monthlyIncome;
		this.credentials = credentials;
	}

	public BankManager getBankManager() {
		return bankManager;
	}

	public void setBankManager(BankManager bankManager) {
		this.bankManager = bankManager;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void checkBalance() {
		System.out.println("The Balance is:" + this.account.getBalance());
	}
	
	public void ProduceReport(LocalDate start) {
//		this.account.
		
	}
	

}
