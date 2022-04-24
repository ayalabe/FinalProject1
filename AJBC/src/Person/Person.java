package Person;

import java.time.LocalDate;

public class Person {
	private String firstName;
	private String lastName;
	private Phone phone;
	private LocalDate bitrthDate;
	private double monthlyIncome;
	
	public Person(String firstName, String lastName, int areaCode, float number, LocalDate bitrthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone.setAreaCode(areaCode);
		this.phone.setNumber(number);
		this.bitrthDate = bitrthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public LocalDate getBitrthDate() {
		return bitrthDate;
	}

	public void setBitrthDate(LocalDate bitrthDate) {
		this.bitrthDate = bitrthDate;
	}

	public double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	
	
	

}         
