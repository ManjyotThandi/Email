package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPassLength = 10;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String email;
	private String companySuffix = "company.com";
	
	// constructor for class. Receive first name and last name
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName; 
		this.department = setDepartment();
		System.out.println("Department is " + this.department);
		this.password = randomPassword(defaultPassLength);
		System.out.println("Your password is " + this.password);
		
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
		System.out.println("Your email is " + email);
		
		// get a random password
	}
	// ask for the department as well
	private String setDepartment() {
		System.out.print("Enter the department\n1 for sale\n2 for accounting\n3 for devlopment\n0 for none\nEnter Department Code:");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if(deptChoice == 1) {
			return "sales";
		}
		else if (deptChoice == 2) {
			return "accounting";
		}
		else if (deptChoice == 3) {
			return "dev";
		}
		else {
			return "";
		}
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$@";
		// create an array of characters
		char[] password = new char[length];
		for (int i=0; i < length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Set mailbox capacity 
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set alternate email
	public void setAltEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	// since variables are private, need getters to retrieve them
	public int getMailboxCapacity() {
		return this.mailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return this.alternateEmail;
	}
	
	public String getPassword() {
		return this.password;
	}
}
