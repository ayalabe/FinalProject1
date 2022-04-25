package AccountOwner;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import AppManager.AppManager;
import BankManager.BankManager;
import Person.Person;
import Person.Phone;

public class AccountOwner extends Person{
	
	private static Scanner scan = new Scanner(System.in);
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
		this.account.activityData(start);
		
	}
	
	public String authenticationCode() {
		Random rand = new Random();
		String codRand = "";
		for (int i = 0; i < 4; i++) {
			int rand_int = rand.nextInt(10);
			codRand += rand_int;
		}
		return codRand;
	}
	
	public void MakeDeposit() {
		String code = authenticationCode();
		int mony;
		System.out.println("Enter the code that appears on the screen" + code);
		String codeUser = scan.nextLine();
		if(code.equals(codeUser)) {
			System.out.println("Enter a amount of funds to deposit:");
			mony = scan.nextInt();
			this.account.setBalance(mony);
		}
		
	}
	
	
	
	public void Withdrawal() {
		System.out.println("Enters the amount of funds to withdraw");
		float withdraw = scan.nextFloat();
		if(withdraw + this.account.WithdrawalDaly(LocalDate.now()) > this.account.getAccountProperties().getMaxWithdrawalAmount())
			System.out.println("You can not withdraw this amount");
		else {
			this.account.setBalance(-withdraw);
			System.out.println("successful withdrawal");
		}
	}
	
	public void TransferFunds()
	{
		System.out.println("Enters the receiving user phone number and amount to transfer");
		int areaCode = scan.nextInt();
		float number = scan.nextFloat();
		Phone phone = new Phone(areaCode, number);
		float transfer = scan.nextFloat();
		AccountOwner userTransfer = AppManager.getOwnerByPhoneNum(phone);
		if(transfer > 2000)
			System.out.println("Only an amount smaller than 2000 can be transferred");
		else {
			userTransfer.account.setBalance(transfer);
			this.account.setBalance(-transfer);
		}
		
	}

}
