package atm;

import java.util.Scanner;

public class ATM {
 private int balance;
 private int pin;
 
 public ATM(int balance, int pin)
 {
	 this.balance=balance;
	 this.pin=pin;
 }
 
 public void displayMenu()
 {
	 System.out.println("1.check balance");
	 System.out.println("2. deposit");
	 System.out.println("3. Withdraw");
	 System.out.println("4. Change Pin");
	 System.out.println(" 5. Exit");
	 
 }
 
 public void deposit(int amount)
 {
	 balance+=amount;
 }
 
 public void withdraw(int amount)
 {
	 if(balance<amount)
	 {
		 System.out.println(" Insufficent Balance");
		 return;
	 }
	 balance-=amount;
 }
 
 public int getBalance()
 {
	 return balance;
	 
 }
 
 public boolean validatePin(int pin)
 {
	 return this.pin==pin;
 }
	
 public void changePin(int newPin)
 {
	 pin=newPin;
 }
 
 public static void main(String[] args) {
		ATM atm=new ATM(1000,1234);
		atm.displayMenu();
		
		System.out.println("Enter the pin");
		Scanner sc=new Scanner(System.in);
		int pin=sc.nextInt();
		if(atm.validatePin(pin))
		{
			atm.displayMenu();
			int option=0;
			while(option!=5)
			{
				atm.displayMenu();
				System.out.println("Enter the option=");
				option=sc.nextInt();
				switch(option)
				{
				case 1:
					System.out.println(" Balance="+atm.getBalance());
					break;
				case 2:
					System.out.print("Enter the Amount");
					int amount=sc.nextInt();
					atm.deposit(amount);
					break;
				case 3:
					System.out.print("Enter the Amount");
					amount=sc.nextInt();
					atm.withdraw(amount);
					break;
				case 4:
					System.out.println("Enter the new Pin");
					int newPin=sc.nextInt();
					atm.changePin(newPin);
					break;
				case 5:
					System.out.println("Thank You for using ATM..");
					break;
				default:System.out.println("done");
				}
				
				
			}
		}
		else
		{
			System.out.println(" Invalid pin...");
		}
		

	}

}
