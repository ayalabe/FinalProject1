package AppManager;

import java.time.LocalDate;
import java.util.Scanner;  // Import the Scanner class
import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.Credentials;
import BankManager.BankManager;
import Person.Phone;


/**
 * Class AppManager controller all the other class
 * and simulator bank account application where transactions can be done
 */
public class AppManager {

	public static AccountOwner[] AccountOwner = new AccountOwner[100];
	private static AccountOwner currUser;
	private int index = 0;
	public static Scanner scan = new Scanner(System.in);
	private BankManager manager;
	private boolean flageManager = false;

	public int runner() {
		while(true) {
			showMenu();
			int opt = Integer.parseInt(scan.nextLine());
			if(opt == 0)
				break;
			callAppManager(opt);
		}
		return 0;

	}

	public void showMenu() {
		System.out.println("Please select a action you want to perform:");
		System.out.println("0. logout\n" + "1. Open Account\n" + "2. Login Use\n" +"3. Check Balance\n" + "4. Produce Activity Report\n"
				+ "5. Make a deposit\n" + "6. Withdrawal\n" + "7. Transfer funds\n" + "8. Pay bill\n" + "9. Get Loan");
	}


	public void callAppManager(int opt) {
		switch(opt){
		case 0: 
			logout();
		case 1:
			OpenAccount();
			break;
		case 2: 
			login();
		case 3: 
			currUser.checkBalance();
			break;
		case 4: 
			System.out.println("Enter a LocalDate");
			LocalDate date =addDate();
			currUser.ProduceReport(date);
			break;
		case 5: 
			currUser.MakeDeposit();
			break;
		case 6: 
			currUser.Withdrawal();
			break;
		case 7: 
			currUser.TransferFunds();
			break;
		case 8: 
			currUser.PayBill();
			break;
		case 9: 
			currUser.getLoan();
			break;
		}
	}


/**
 * Login of an existing user by username and password
 */
	private void login() {
		int tim = 0;
		System.out.println("Enter a user name: {letters and digits only}");
		String userName = scan.nextLine();
		for (int i = 0; AccountOwner[i]!=null; i++) {
			System.out.println(AccountOwner[i].credentials.getUsername());
			if(AccountOwner[i].credentials.getUsername().equals(userName)) {
				if(AccountOwner[i].isLoack()) {
					System.out.println("Your account is locked for 30 minutes");
				}
				else {
					while(tim < 3) {
						tim++;
						System.out.println("Enter a password:  {4-8 chars, must contain digit and letter}");
						String password = scan.nextLine();
						if(AccountOwner[i].credentials.getPassword().equals(password)) {
							currUser = AccountOwner[i];
							if(AccountOwner[i].credentials.getUsername().equals("manager")) {
								if(this.manager.getUsersToApprove()!=null)
									this.manager.setAndApproveAcc();
							}
							break;
						}
					}
					if(tim == 3) {
						AccountOwner[i].lock();
					}
				}
			}


		}

	}
/**
 * Login of an existing user by phone
 * 
 */
	private void login(Phone phoneNumber) {

		for (int i = 0; AccountOwner[i]!=null; i++) {
			if(AccountOwner[i].getPhone().getAreaCode() == phoneNumber.getAreaCode() && AccountOwner[i].getPhone().getNumber() == phoneNumber.getNumber()) {
				currUser = AccountOwner[i];
			}
		}
	}
/**
 * @param phoneNumber for user
 * @return the user with this phone number
 */
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
		System.out.println("Enter a new password:  {4-8 chars, must contain digit and letter}");
		String newPassword = scan.nextLine();
		Credentials credentials = new Credentials(newUserName, newPassword);
		return credentials;
	}
/**
 * scan from the user the LocalDate
 * @return 
 */
	public static LocalDate addDate() {
		int day = Integer.parseInt(scan.nextLine());
		int month = Integer.parseInt(scan.nextLine());
		int year = Integer.parseInt(scan.nextLine());
		LocalDate ld = LocalDate.of(year, month, day);
		return ld;
	}

	/**
	 * create new user and add to the list manager to apruve
	 */
	public void OpenAccount() {

		if(!flageManager) {
			Account account = new Account(70000);
			Credentials credential = new Credentials("manager", "man123");
			this.manager = new BankManager("Manager", "man", 052, 5051524, LocalDate.now(), account, 70000, credential);
			AccountOwner[index++] = this.manager;
			this.flageManager = true;
		}

		System.out.println("Enter a firstName:\r\n"
				+ "lastName:\r\n"
				+ "Phone Number{areaCode, number}\r\n"
				+ "bitrthDate:LocalDate\r\n"
				+ "monthly Income");
		String firstName = scan.nextLine();
		String lastName = scan.nextLine();
		int areaCode = Integer.parseInt(scan.nextLine());
		float number = Float.parseFloat(scan.nextLine());
		LocalDate date =addDate();
		double monthlyIncome = Double.parseDouble(scan.nextLine());
		Credentials credentials = createUserNameAndPassword();

		AccountOwner newOwner = new AccountOwner(firstName, lastName, areaCode, number, date, null, monthlyIncome, credentials,this.manager);
		newOwner.getBankManager().setUsersToApprove(newOwner);
		AccountOwner[index++] = newOwner;
		System.out.println(newOwner);

	}
	private void logout() {
		currUser = null;
	}


}