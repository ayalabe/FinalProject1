package AppManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;  // Import the Scanner class

import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.Credentials;
import BankManager.BankManager;
import Person.Person;
import Person.Phone;
import Runner.Menu;

public class AppManager {
	
	private static AccountOwner[] AccountOwner = new AccountOwner[100];
	private static AccountOwner currUser;
	private int index = 0;
//	private AccountOwner[] users = new AccountOwner[100];
	private static Scanner scan = new Scanner(System.in);
	private BankManager manager;
	private Menu menu = new Menu();
	private boolean flageManager = false;
	
	public int runner() {
		
		Scanner sc = new Scanner(System.in);
		  while(true) {
		    showMenu();
		    int opt = Integer.parseInt(sc.next());
		    if(opt == 0)
		      break;
		    callAppManager(opt);
		  }
		return 0;
		
	}

	public void showMenu() {
		  System.out.println("Please select a action you want to perform:");
		  System.out.println("1. Open Account\n" + "2. Login Use\n" + "3. Check Balance\n" + "4. Produce Activity Report\n"
		+ "5. Make a deposit\n" + "6. Withdrawal\n" + "7. Transfer funds\n" + "8. Pay bill\n" + "9. Get Loan");
		}
	
	
	public void callAppManager(int opt) {
		  switch(opt){
		  case 0: 
			  System.out.println("by by");
		  case 1:
			  OpenAccount();
			  System.out.println(manager);
			  break;
		  case 2: 
			  login();
			  System.out.println(manager);
//		  case 3: 
//			  return new Coppuccino();
//		  case 4: 
//			  return new Latte();
//		  case 5: 
//			  return new Cola();
//		  case 6: 
//			  return new Sprit();
//		  case 7: 
//			  return new OrangeJuice();
//		  case 8: 
//			  return new AppleJuice();
		  }
		}
	
	
	
	private void login() {
		int tim = 0;
		System.out.println(AccountOwner.length);
		System.out.println("Enter a user name: {letters and digits only}");
		String userName = scan.nextLine();
		for (int i = 0; AccountOwner[i]!=null; i++) {
			System.out.println(AccountOwner[i].credentials.getUsername());
			if(AccountOwner[i].credentials.getUsername().equals(userName)) {
				while(tim < 3) {
				System.out.println("Enter a password:  {4-8 chars, must contain digit and letter}");
				String password = scan.nextLine();
				if(AccountOwner[i].credentials.getPassword().equals(password)) {
					currUser = AccountOwner[i];
				}
			}
				if(tim == 3) {
					//TODO - timer
				}
		}
				
			
	}
		
	}
	
	private void login(Phone phoneNumber) {
		
		for (int i = 0; AccountOwner[i]!=null; i++) {
			if(AccountOwner[i].getPhone().getAreaCode() == phoneNumber.getAreaCode() && AccountOwner[i].getPhone().getNumber() == phoneNumber.getNumber()) {
				currUser = AccountOwner[i];
			}
		}
	}
	
	public static AccountOwner getOwnerByPhoneNum(Phone phoneNumber) {
		for (int i = 0; AccountOwner[i]!=null; i++) {
			if(AccountOwner[i].getPhone().getAreaCode() == phoneNumber.getAreaCode() && AccountOwner[i].getPhone().getNumber() == phoneNumber.getNumber()) {
				return AccountOwner[i];
			}
		}
		return null;
	}
	
	private Credentials createUserNameAndPassword() {
		System.out.println("Enter a new user name: {letters and digits only}");
		String newUserName = scan.nextLine();
		scan.nextLine();
		System.out.println("Enter a new password:  {4-8 chars, must contain digit and letter}");
		String newPassword = scan.nextLine();
		Credentials credentials = new Credentials("ayala", "aya123");
		return credentials;
	}
	
	public LocalDate addDate() {
        
        LocalDate ld = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd. MMM. yyyy");
//        System.out.println(ld.format(dtf));
//        scan.close();
        return ld;
    }
	
	public void OpenAccount() {
		
		System.out.println("Enter a firstName:\r\n"
		 		+ "lastName:\r\n"
		 		+ "Phone Number{areaCode, number}\r\n"
		 		+ "bitrthDate:LocalDate\r\n"
		 		+ "monthly Income");
		 String firstName = scan.nextLine();
		 String lastName = scan.nextLine();
		 int areaCode = scan.nextInt();
		 float number = scan.nextFloat();
		 LocalDate date = addDate();
		 int monthlyIncome = scan.nextInt();
		 Credentials credentials = createUserNameAndPassword();
		 
		if(!flageManager) {
			Account account = new Account(70000);
			this.manager = new BankManager(firstName, lastName, areaCode, number, date, account, monthlyIncome, credentials);
			this.flageManager = true;
		}
		else {
			AccountOwner newOwner = new AccountOwner(firstName, lastName, areaCode, number, date, null, monthlyIncome, credentials,this.manager);
			newOwner.getBankManager().setUsersToApprove(newOwner);
			this.AccountOwner[index++] = newOwner;
			System.out.println(newOwner);
		}
		 
		
	}
	private void logout() {
		currUser = null;
	}


}
