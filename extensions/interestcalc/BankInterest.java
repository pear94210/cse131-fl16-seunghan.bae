package interestcalc;

public class BankInterest {

	public static void main(String[] args) {

		double balance = 4000.0;
		double interestRate = 0.02;
		
		int day = 0;
		String type;
		
		System.out.println("Day" + "\t" + "Type    " + "\t" + "Amount" + "\t\t" + "Balance");
		
		for(int i = 0; i < 30; i++) {
			day++;
			double amount = 0.0;
			
			double random = Math.random();
			
			if(random < 0.5) {
				amount = 100.0;
				type = "Withdraw";
				balance = balance - amount;
			}
			else {
				amount = 200.5;
				type = "Deposit ";
				balance = balance + amount;
			}
			
			System.out.println(day + "\t" + type + "\t" + "$" + amount + "0" + "\t\t" + "$" + balance + "0");
		}
		
		double interest = balance * interestRate;
		double total = balance + interest;
		
		System.out.println();
		System.out.println("Interest earned: " + interest);
		System.out.println("Money after one month\'s interest: " + total);
	}

}
