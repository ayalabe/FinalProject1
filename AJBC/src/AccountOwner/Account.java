package AccountOwner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Account{
	
	private int count = 0;
	private final long accountNumber;
	private double balance;
	private AccountProperties accountProperties;
	private ActivityData[] activityData;
	private double intresRate;
	private double fee;
	private int index = 0;
	
	public Account(double balance, AccountProperties accountProperties,
			ActivityData[] activityData, double intresRate, double fee) {
		this.accountNumber = count++;
		this.balance = balance;
		this.accountProperties = accountProperties;
		this.activityData = new ActivityData[100];
		this.intresRate = intresRate;
		this.fee = fee;
	}
	
	@Override
	public String toString() {
		return "Account [count=" + count + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", accountProperties=" + accountProperties + ", activityData=" + Arrays.toString(activityData)
				+ ", intresRate=" + intresRate + ", fee=" + fee + "]";
	}
	
	public void activityData(LocalDate start) {
		for (int i = 0; this.activityData[i]!=null; i++) {
			System.out.println();
			if(this.activityData[i].getTimeStamp().toLocalDate().isAfter(start) || this.activityData[i].getTimeStamp().toLocalDate().isEqual(start)) {
				System.out.println(this.activityData[i]);
			}
				
		}
	}
	
	
	public Account(double balance) {
		this.accountNumber = count++;
		this.balance = balance;
		this.activityData = new ActivityData[100];
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance += balance;
	}

	public AccountProperties getAccountProperties() {
		return accountProperties;
	}

	private void setAccountProperties(AccountProperties accountProperties) {
		this.accountProperties = accountProperties;
	}

	public ActivityData[] getActivityData() {
		return activityData;
	}

	public void setActivityData(ActivityData activityData) {
		this.activityData[index++] = activityData;
	}

	private double getIntresRate() {
		return intresRate;
	}

	private void setIntresRate(double intresRate) {
		this.intresRate = intresRate;
	}

	private double getFee() {
		return fee;
	}

	private void setFee(double fee) {
		this.fee = fee;
	}

	private long getAccountNumber() {
		return accountNumber;
	}
	
	public float WithdrawalDaly(LocalDate start) {
		float WithdrawalDaly = 0;
		for (int i = 0; this.activityData[i]!=null; i++) {
			if(this.activityData[i].getTimeStamp().toLocalDate().isEqual(start)) {
				if(this.activityData[i].getActivityName().equals(ActivityName.WITHDRAWAL)) {
					WithdrawalDaly += this.activityData[i].getBalanceChange();
				}
			}	
		}
		return WithdrawalDaly;
	}
	
}
