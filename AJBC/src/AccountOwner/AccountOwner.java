package AccountOwner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import AppManager.AppManager;
import BankManager.BankManager;
import Person.Person;
import Person.Phone;

public class AccountOwner extends Person{

	protected Account account;
	public void setAccount(Account account) {
		this.account = account;
	}

	private double monthlyIncome;
	public Credentials credentials;
	private BankManager bankManager;
	private LocalDateTime lock = null;



	@Override
	public String toString() {
		return "AccountOwner [account=" + account + ", monthlyIncome=" + monthlyIncome + ", credentials=" + credentials
				+ ", bankManager=" + bankManager + "]";
	}

	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	public BankManager getBankManager() {
		return bankManager;
	}

	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	/**
	 * before the AccountOwner
	 * @param firstName
	 * @param lastName
	 * @param areaCode
	 * @param number
	 * @param bitrthDate
	 * @param account
	 * @param monthlyIncome
	 * @param credentials
	 * @param bankManager
	 */
	public AccountOwner(String firstName, String lastName, int areaCode, float number, LocalDate bitrthDate,
			Account account, double monthlyIncome, Credentials credentials,BankManager bankManager) {
		super(firstName, lastName, areaCode, number, bitrthDate);
		this.account = account;
		this.monthlyIncome = monthlyIncome;
		this.credentials = credentials;
		this.bankManager = bankManager;
	}

	/**
	 * before the manager
	 * @param firstName
	 * @param lastName
	 * @param areaCode
	 * @param number
	 * @param bitrthDate
	 * @param account
	 * @param monthlyIncome
	 * @param credentials
	 */
	public AccountOwner(String firstName, String lastName, int areaCode, float number, LocalDate bitrthDate,
			Account account, double monthlyIncome, Credentials credentials) {
		super(firstName, lastName, areaCode, number, bitrthDate);
		this.account = account;
		this.monthlyIncome = monthlyIncome;
		this.credentials = credentials;
	}
	/**
	 * print the balance
	 */
	public void checkBalance() {
		System.out.println("The Balance is:" + this.account.getBalance());
	}

	/**
	 * Displays from a certain date all the actions taken in the account
	 * @param start 
	 */
	public void ProduceReport(LocalDate start) {
		this.checkBalance();
		this.account.activityData(start);

	}

	private String authenticationCode() {
		Random rand = new Random();
		String codRand = "";
		for (int i = 0; i < 4; i++) {
			int rand_int = rand.nextInt(10);
			codRand += rand_int;
		}
		return codRand;
	}

	private void setFee(double rate, double mony) {
		double fee = (rate/100) * mony;
		this.account.setBalance(-fee);
		this.bankManager.account.setBalance(fee);
	}

	/**
	 * User makes a deposit directly to an ATM box using
	 *	the app authentication code.
	 */
	public void MakeDeposit() {
		String code = authenticationCode();
		double mony;
		System.out.println("Enter the code that appears on the screen" + code);
		String codeUser = AppManager.scan.nextLine();
		if(code.equals(codeUser)) {
			System.out.println("Enter a amount of funds to deposit:");
			mony = Double.parseDouble(AppManager.scan.nextLine());
			setFee(this.account.getAccountProperties().getFeeMax(), mony);
			this.account.setBalance(mony);
			updateActiviti(ActivityName.DEPOSIT,mony,LocalDateTime.now(),"Make Deposit");
		}

	}

	/**
	 * User makes a withdrawal request through the app and get the funds when authenticated in an ATM.
	 */
	public void Withdrawal() {
		System.out.println("Enters the amount of funds to withdraw");
		double withdraw = Double.parseDouble(AppManager.scan.nextLine());
		if(withdraw + this.account.WithdrawalDaly(LocalDate.now()) > this.account.getAccountProperties().getMaxWithdrawalAmount() && this.account.getBalance() < withdraw)
			System.out.println("You can not withdraw this amount");
		else {
			this.account.setBalance(-withdraw);
			setFee(this.account.getAccountProperties().getFeeMax(), withdraw);
			System.out.println("successful withdrawal");
			updateActiviti(ActivityName.WITHDRAWAL,withdraw,LocalDateTime.now(),"Make Withdrawal");
		}
	}
/**
 * User makes a fast transfer to another user by providing a phone number and an amount
 */
	public void TransferFunds()
	{
		System.out.println("Enters the receiving user phone number and amount to transfer");
		int areaCode = Integer.parseInt(AppManager.scan.nextLine());
		float number = Float.parseFloat(AppManager.scan.nextLine());;
		Phone phone = new Phone(areaCode, number);
		double transfer = Double.parseDouble(AppManager.scan.nextLine());
		AccountOwner userTransfer = AppManager.getOwnerByPhoneNum(phone);
		if(transfer > 2000)
			System.out.println("Only an amount smaller than 2000 can be transferred");
		else {
			userTransfer.account.setBalance(transfer);
			this.account.setBalance(-transfer);
			setFee(this.account.getAccountProperties().getFeeMax(), transfer);
			System.out.println("successful Transfe");
			updateActiviti(ActivityName.TRANSFER,transfer,LocalDateTime.now(),"Make Transfer Funds");
		}

	}

	public void TransferFunds(BankManager bankManager, double transfer)
	{
		if(transfer > 500) {
			System.out.println("Only an amount smaller than 2000 can be transferred");
		}
		else {
			bankManager.account.setBalance(transfer);
			setFee(this.account.getAccountProperties().getFeeMax(), transfer);
			System.out.println("successful Transfe");
			updateActiviti(ActivityName.PAY_BILL,transfer,LocalDateTime.now(),"Transfer Funds to the bankManager");
		}

	}
/**
 * User makes a payment to a payee
 */
	public void PayBill() {
		System.out.println("Select\r\n 1. AJBC bank itself (loan return) and the 2. phone, 3. water\r\n"
				+ "or 4.electric company");
		int op = Integer.parseInt(AppManager.scan.nextLine());
		System.out.println("Enters amount to transfer");
		double transfer = Double.parseDouble(AppManager.scan.nextLine());
		System.out.println();
		switch(op) {
		case 1:
			TransferFunds(this.bankManager, transfer);
			this.account.setBalance(-transfer);
			break;
		case 2,3,4:
			TransferFunds(this.bankManager, transfer);
		this.account.setBalance(-transfer);
		updateActiviti(ActivityName.PAY_BILL,transfer,LocalDateTime.now(),"Transfer Funds to the phone water or electric company");
		break;

		}

	}
/**
 * User makes a fast transfer to another user by
 */
	public void getLoan() {
		System.out.println("Enter the requested loan amount and number of monthly payments.");
		double getLoan = Double.parseDouble(AppManager.scan.nextLine());
		int numberOfMonthly = Integer.parseInt(AppManager.scan.nextLine());
		if(getLoan > this.account.getAccountProperties().getMaxLoanAmount())
			System.out.println("requested loan amount is bigger whith requested loan amount you can get");
		else {
			if(numberOfMonthly > 60)
				System.out.println("mount exceeds the max loan amount");
			else {
				this.account.setBalance(getLoan);
				setFee(this.account.getAccountProperties().getFeeMax(), getLoan);
				double rate = this.account.getAccountProperties().getIntresRateMax()/100;
				this.bankManager.account.setBalance(-getLoan + rate);
				System.out.println("The amount of the monthly return: " + (getLoan+rate)/numberOfMonthly + "\r\n"
						+ "successful deposit to the account.\r\n"
						+ "successful withdrawal from the main bank account.");
				updateActiviti(ActivityName.GET_LOAN,getLoan,LocalDateTime.now(),"The rate is: " + rate + " monthly payment: "+ (getLoan+rate)/numberOfMonthly);
			}
		}
	}
/**
 * A function that receives a type of action and updates it in the list of actions of the same user and also updates it in the list of actions of the administrator
 * @param activityName
 * @param balanceChange
 * @param timeStamp
 * @param info
 */
	private void updateActiviti(ActivityName activityName, Double balanceChange, LocalDateTime timeStamp, String info) {
		ActivityData activityData = new ActivityData(activityName, balanceChange, timeStamp, info);
		this.account.setActivityData(activityData);
		this.bankManager.account.setActivityData(activityData);
	}
/**
 * Updates the time the user is locked
 */
	public void lock() {
		this.lock = LocalDateTime.now();
	}
/**
 * Checks if the user is locked
 * @return
 */
	public boolean isLoack() {
		if(this.lock == null)
			return false;
		if(this.lock.getMinute()+30 > LocalDateTime.now().getMinute())
			return true;
		return false;
	}

}
