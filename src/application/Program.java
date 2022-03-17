package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = scan.nextInt();
			scan.nextLine();
			System.out.print("Holder: ");
			String holder = scan.nextLine();
			System.out.print("Initial balance: ");
			double balance = scan.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = scan.nextDouble();

			Account acc1 = new Account(number, holder, balance, withdrawLimit);

			System.out.println();

			System.out.print("Enter amount for withdraw: ");
			double amount = scan.nextDouble();

			acc1.withdraw(amount);

			System.out.println("New balance: " + String.format("%.2f", acc1.getBalance()));

		} catch (InputMismatchException e) {
			System.out.println("Invalid account number");
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());

			scan.close();
		}

	}

}
