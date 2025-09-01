package Assignments.Polymorphism;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read TicketBooking details (CSV format)
        String[] bookingDetails = sc.nextLine().trim().split("\\s*,\\s*");
        String stageEvent = bookingDetails[0].trim();
        String customer = bookingDetails[1].trim();
        Integer noOfSeats = Integer.parseInt(bookingDetails[2].trim());

        TicketBooking booking = new TicketBooking(stageEvent, customer, noOfSeats);

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1: // Cash
                double amountCash = sc.nextDouble();
                System.out.println("Stage event:" + booking.getStageEvent());
                System.out.println("Customer:" + booking.getCustomer());
                System.out.println("Number of seats:" + booking.getNoOfSeats());
                booking.makePayment(amountCash);
                break;

            case 2: // Wallet
                double amountWallet = sc.nextDouble();
                sc.nextLine(); // consume newline
                String walletNumber = sc.nextLine();
                System.out.println("Stage event:" + booking.getStageEvent());
                System.out.println("Customer:" + booking.getCustomer());
                System.out.println("Number of seats:" + booking.getNoOfSeats());
                booking.makePayment(walletNumber, amountWallet);
                break;

            case 3: // Credit Card
                String holderName = sc.nextLine();
                double amountCard = sc.nextDouble();
                sc.nextLine(); // consume newline
                String creditCard = sc.nextLine();
                String ccv = sc.nextLine();
                System.out.println("Stage event:" + booking.getStageEvent());
                System.out.println("Customer:" + booking.getCustomer());
                System.out.println("Number of seats:" + booking.getNoOfSeats());
                booking.makePayment(creditCard, ccv, holderName, amountCard);
                break;

            default: // Invalid choice
                System.out.println("Stage event:" + booking.getStageEvent());
                System.out.println("Customer:" + booking.getCustomer());
                System.out.println("Number of seats:" + booking.getNoOfSeats());
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
