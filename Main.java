import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ReservationSystem system = new ReservationSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Train Reservation System ====");
            System.out.println("1. Add Train");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View Train Details");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Train ID: ");
                    int trainId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Train Name: ");
                    String trainName = sc.nextLine();

                    System.out.print("Enter Total Seats: ");
                    int totalSeats = sc.nextInt();

                    system.addTrain(trainId, trainName, totalSeats);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Passenger Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Train ID: ");
                    int bookTrainId = sc.nextInt();

                    system.bookTicket(name, age, bookTrainId);
                    break;

                case 3:
                    System.out.print("Enter Ticket ID to Cancel: ");
                    int ticketId = sc.nextInt();
                    system.cancelTicket(ticketId);
                    break;

                case 4:
                    System.out.print("Enter Train ID: ");
                    int viewTrainId = sc.nextInt();
                    system.viewTrain(viewTrainId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}