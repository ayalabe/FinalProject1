package AccountOwner;

import java.time.LocalDateTime;

public enum AccountProperties {
	BRONZE(4.5,6,5,7.5,10000,2500),
	SILVER(3,4.5,3.8,5,20000, 4000),
	GOLD(1.5,3,1.75,3.8,50000,6000),
	TITANIUM(0,0,0,0,0,0);
	
	private double intresRateMin;
	private double intresRateMax;
	private double feeMin;
	private double feeMax;
	private double MaxLoanAmount;
	public double getMaxLoanAmount() {
		return MaxLoanAmount;
	}

	private double MaxWithdrawalAmount;
	
	AccountProperties(double intresRateMin, double intresRateMax,double feeMin,double feeMax,double MaxLoanAmount,double MaxWithdrawalAmount) {
		
		this.intresRateMin = intresRateMin;
		this.intresRateMax = intresRateMax;
		this.feeMin = feeMin;
		this.setFeeMax(feeMax);
		this.MaxLoanAmount = MaxLoanAmount;
		this.setMaxWithdrawalAmount(MaxWithdrawalAmount);
		
	}
	
	public static AccountProperties properties(double monthlyIncome) {
		if(monthlyIncome<5000)
			return BRONZE;
		if(monthlyIncome<8000)
			return SILVER;
		if(monthlyIncome<10000)
			return GOLD;
		return TITANIUM;
	}

	public double getIntresRateMin() {
		return intresRateMin;
	}

	public void setIntresRateMin(double intresRateMin) {
		this.intresRateMin = intresRateMin;
	}

	public double getIntresRateMax() {
		return intresRateMax;
	}

	public void setIntresRateMax(double intresRateMax) {
		this.intresRateMax = intresRateMax;
	}

	public double getFeeMax() {
		return feeMax;
	}

	public void setFeeMax(double feeMax) {
		this.feeMax = feeMax;
	}

	public double getMaxWithdrawalAmount() {
		return MaxWithdrawalAmount;
	}

	public void setMaxWithdrawalAmount(double maxWithdrawalAmount) {
		MaxWithdrawalAmount = maxWithdrawalAmount;
	}

	
}
