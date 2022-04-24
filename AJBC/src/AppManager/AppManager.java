package AppManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;  // Import the Scanner class
import AccountOwner.AccountOwner;
import BankManager.BankManager;
import Person.Person;
import Person.Phone;

public class AppManager {
	
	private AccountOwner currUser;
	static AccountOwner[] users;
	static Scanner scan = new Scanner(System.in);
	private BankManager bankManager;
	private Person person;
	private Phone phone;
	
	
	
	private void login(String username, String password) {
		
		if(username.equals("BankManager")) {
			
		}
		
	}
	private void login(Phone phoneNumber) {
		
	}
	
	public static LocalDate addDate() {
        
        LocalDate ld = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd. MMM. yyyy");
//        System.out.println(ld.format(dtf));
        scan.close();
        return ld;
    }
	
	private void OpenAccount() {
		System.out.println("Enter a monthly Income:");
		 int monthlyIncome = scan.nextInt();  // Read user input
		 System.out.println("Enter a firstName:\r\n"
		 		+ "lastName:\r\n"
		 		+ "Phone Number{areaCode, number}\r\n"
		 		+ "bitrthDate:LocalDate");
		 this.person.setFirstName(scan.nextLine());
		 this.person.setLastName(scan.nextLine());
		 this.phone.setAreaCode(scan.nextInt());
		 this.phone.setNumber(scan.nextInt());
		 this.person.setPhone(this.phone);
		 this.person.setBitrthDate(addDate());
		 bankManager.setUsersToApprove(this.person);
		
	}
	private void logout() {
		
	}
	private static AccountOwner getOwnerByPhoneNum(Phone phoneNumber) {
		return null;
		
	}


}
