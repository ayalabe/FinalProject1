package AccountOwner;

public class Credentials {
	
	private String username;
	private String password;
	
	public Credentials(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public String getUsername() {
		return username;
	}
	@Override
	public String toString() {
		return "Credentials [username=" + username + ", password=" + password + "]";
	}

	private void setUsername(String username) {
		if(UsernameIsDigitisLetter(username))
			this.username = username;
		else System.out.println("UserName anexcceptebol");
	}
	
	private boolean UsernameIsDigitisLetter(String username) {
		for (int i = 0; i < username.length(); i++) {
			if(!Character.isDigit(username.charAt(i))  && !Character.isLetter(username.charAt(i)))
				return false;
        }
		return true;
	}
	
	private boolean PasswordIsDigitisLetter(String password) {
		
		boolean flagIsDigit = false;
		boolean flagIsLetter = false;
		if(password.length() < 4 || password.length() > 8)  // password is short or long
			return false;
		for (int i = 0; i < password.length(); i++) {
			if(!Character.isDigit(password.charAt(i))  && !Character.isLetter(password.charAt(i))) // password don't contain other char
				return false;
			if(Character.isDigit(password.charAt(i)))
					flagIsDigit = true;	
			if(Character.isLetter(password.charAt(i)))
					flagIsLetter = true;	
        }
		return flagIsDigit && flagIsLetter;  // password contain digits and letter
	}
	
	public String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		if(PasswordIsDigitisLetter(password))
			this.password = password;
		else System.out.println("Password anexcceptebol");
	}
	

}
