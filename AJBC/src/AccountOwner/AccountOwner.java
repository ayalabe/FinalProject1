package AccountOwner;

import java.time.LocalDate;

import BankManager.BankManager;
import Person.Person;

public class AccountOwner extends Person{
	
	private Account account = null;
	private double monthlyIncome;
	private Credentials credentials;
	private BankManager bankManager;

	public AccountOwner(String firstName, String lastName, int areaCode, float number, LocalDate bitrthDate,
			Account account, double monthlyIncome, Credentials credentials) {
		super(firstName, lastName, areaCode, number, bitrthDate);
		this.account = account;
		this.monthlyIncome = monthlyIncome;
		this.credentials = credentials;
	}
	

}
