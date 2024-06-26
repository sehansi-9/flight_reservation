import java.io.File;
import java.util.*;
public class w2052049_PlaneManagement {
    public static Scanner input = new Scanner(System.in);
    public static String rowLetters[] = {"A", "B", "C", "D"};
    public static Ticket tickets[] = new Ticket[52];
    public static String rowPreference;
    public static int[][] seatingPlan = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    }; // initializing with all seats available or '0'
    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application");
        System.out.println("************************************************");
        System.out.println("*                MENU OPTIONS                  *");
        System.out.println("************************************************");
        System.out.println("   1) Buy a seat\n   2) Cancel a seat\n   3) Find first available seat\n   4) Show seating plan\n   5) Print tickets information and total sales\n   6) Search ticket\n   0) Quit ");
        System.out.println("************************************************");


        int userOption;
        do {
            try {
                System.out.println("Please select an option: ");
                userOption = input.nextInt();

                switch (userOption) {
                    case 1:
                        buy_seat();
                        break;
                    case 2:
                        cancel_seat();
                        break;
                    case 3:
                        find_first_available();
                        break;
                    case 4:
                        show_seating_plan();
                        break;
                    case 5:
                        print_tickets_info();
                        break;
                    case 6:
                        search_ticket();
                        break;
                    case 0:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Please enter a valid menu option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next();
                userOption = -1; // setting to a non zero value to continue the loop
            }
        }
        while (userOption != 0);
    }
    /**
     * This method validates the row letter user inputs by checking them against the valid list of row letters and assigns row index value and maximum seats per relevant row
     *  @param bookCancelAvail string type to modify the message the user sees before entering the seat details for each validating process
     * @return an array of two int elements consisting a value for a valid row letter and the relevant maximum seat number
     */
    private static int[] row_validator(String bookCancelAvail) { //method to validate user input for row
        int[] rowDetails = new int[2];
        boolean rowValid;

        while (true) {
            System.out.println("Please enter the row letter you would like to "+ bookCancelAvail + "(A/B/C/D): ");
            rowPreference = input.next();
            rowValid = false;

            for (String letter : rowLetters) {
                if (letter.equals(rowPreference)) {
                    rowValid = true;
                    break;
                }
            }
            if (!rowValid) {
                System.out.println("Please enter a valid row");
            } else {
                break;
            }
        }
        int rowIndex, maxSeatNum;
        switch (rowPreference) {
            case "A" -> {
                rowIndex = 0;
                maxSeatNum = 14;
            }
            case "B" -> {
                rowIndex = 1;
                maxSeatNum = 12;
            }
            case "C" -> {
                rowIndex = 2;
                maxSeatNum = 12;
            }
            default -> {
                rowIndex = 3;
                maxSeatNum = 14;
            }
        }
        rowDetails[0] = rowIndex;
        rowDetails[1] = maxSeatNum;

        return rowDetails;
    }
    /**
     * This validates the seat number user enters
     * @param rowDetails integer type array
     * @return validated seat number
     */
    private static int seatNum_validator(int[] rowDetails) {
        int maxSeatNum = rowDetails[1];
        while (true) {
            System.out.println("Please enter the seat number (1-" + maxSeatNum + "): ");
            try {
                int seatNumber = input.nextInt();
                if (!(seatNumber >= 1 && seatNumber <= maxSeatNum)) { // checking if the entered seat number is in range
                    System.out.println("Please enter a valid seat number");
                    continue;
                }
                return seatNumber;
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next();
            }
        }
    }
    /**
     * This method books or cancels a seat and returns the seat information
     * @param bookOrCancel String value for either "book" or "cancel"
     * @param rowIndex integer value for the row index or the number assigned based on the letter
     * @param seatNumber integer value  for the seat number
     * @return seat information as a string or null based on the availability of it to be booked or cancelled
     */
    private static String bookOrCancel(String bookOrCancel, int rowIndex, int seatNumber) {
        if (bookOrCancel.equals("book")) {
            if (seatingPlan[rowIndex][seatNumber - 1] == 0) {
                seatingPlan[rowIndex][seatNumber - 1] = 1;
                System.out.println("Your selected " + rowPreference + seatNumber + " seat has been successfully booked");
                return rowPreference + seatNumber;
            } else {
                System.out.println("Sorry, seat " + rowPreference + seatNumber + " is already booked");
                return "";
            }
        } else {
            if (seatingPlan[rowIndex][seatNumber - 1] == 1) {
                seatingPlan[rowIndex][seatNumber - 1] = 0;
                System.out.println("Your selected " + rowPreference + seatNumber + " seat has been successfully cancelled");
                return rowPreference + seatNumber;
            } else {
                System.out.println("Seat " + rowPreference + seatNumber + " is already unavailable");
                return "";
            }
        }
    }
    /**
     * This method combines a multiple methods declared to buy seat, record passenger details and save ticket information to an array and a text file
     */
    private static void buy_seat() {
        int[] rowDetails = row_validator("book");
        int seatNumber = seatNum_validator(rowDetails);
        String seatID = bookOrCancel("book", rowDetails[0], seatNumber);
        if (!(seatID.isEmpty())) { // if seatID hence returned is not a null value (successfully booked)
            char row = seatID.replaceAll("[^A-Za-z]", "").charAt(0); //separating the row information and seat number as char and int from the string
            int seat = Integer.parseInt(seatID.replaceAll("[^0-9]", ""));
            int price; //assigning the prices accordingly
            if (seat < 5) {
                price = 200;
            } else if ((seat < 10) && (seat > 5)) {
                price = 150;
            } else {
                price = 180;
            }
            System.out.println("Please enter your name: ");
            String name = input.next();
            System.out.println("Please enter your Surname: ");
            String surName = input.next();
            System.out.println("Please enter your Email: ");
            String eMail = input.next();
            System.out.println("Your information has been successfully recorded for seat "+seatID);

            Person passenger = new Person(name, surName, eMail);
            Ticket TicketInfo = new Ticket(row, seatNumber, price, passenger, name, surName, eMail);

            TicketInfo.save(); // saving ticket info to txt file

            for (int i = 0; i < tickets.length; i++) { //adding ticket info object to a tickets array
                if (tickets[i] == null) { // finding the first empty slot in the array
                    tickets[i] = TicketInfo;
                    break;
                }
            }

        }
    }
    /**
     * This method combines a multiple methods declared to cancel a seat and removes that ticket from the tickets array
     */
    private static void cancel_seat() {
        int[] rowDetails = row_validator("cancel");
        int seatNumber = seatNum_validator(rowDetails);
        String seatID = bookOrCancel("cancel", rowDetails[0], seatNumber);
        if (!(seatID.isEmpty())) {
            char row = seatID.replaceAll("[^A-Za-z]", "").charAt(0);


            for (int i = 0; i < tickets.length; i++) { // in ticket info array
                Ticket ticket = tickets[i];
                if ((ticket.getRow()==row) && (ticket.getSeat() == seatNumber)) {  //finding the ticket with the relevant seat info
                    delete(row,seatNumber); //deleting the ticket text file
                    for (int j = i; j < tickets.length - 1; j++) { // shifting elements after index i of that ticket to the left to overwrite the canceled ticket
                        tickets[j] = tickets[j + 1];
                    }
                    tickets[tickets.length - 1] = null;
                    break;
                }
            }
        }
    }
    /**
     * This method finds the first available seat from the seating plan
     */
    private static void find_first_available() {
        int searchValue = 0;
        int index;
        char row;
        for (int i = 0; i < seatingPlan.length; i++) {
            for (index = 0; index < seatingPlan[i].length; index++) {
                if (seatingPlan[i][index] == searchValue) {
                    if (i == 0) {
                        row = 'A';
                    }
                    else if (i == 1) {
                        row = 'B';
                    }
                    else if (i == 2) {
                        row = 'C';
                    }
                    else {
                        row = 'D';
                    }
                    System.out.println("First seat found in: " + row + (index + 1));
                    return;
                }
            }
        }
        System.out.println("No seat available.");
    }
    /**
     * This method prints the seating plan
     */
    private static void show_seating_plan() {
        System.out.println("Seating Plan");
        int rowIndex = 0;
        for (int[] row : seatingPlan) {
            for (int seat : row) {
                if (seat == 0) {
                    System.out.print('O' + " ");
                } else {
                    System.out.print('X' + " ");
                }
            }
            System.out.println(); // Print a new line after each row
            if (rowIndex == 1) {
                System.out.println(); // another blank line after row B (index 1)
            }
            rowIndex++;
        }
    }
    /**
     * This method prints the ticket info stored in ticket array
     */
    private static void print_tickets_info() {
        int total_price = 0;
        for (Ticket ticket : tickets) {
            if (ticket!=null){ // accessing the assigned price values of the non-null tickets
                total_price += ticket.getPrice();
                ticket.printTicketInfo();
                System.out.println("--------------");
            }
            else {
                break;
            }
        }
        System.out.println("Total price of tickets sold: $"+total_price);
    }
    /**
     * This method searches for the availability of a ticket and prints the passenger information if already booked
     */
    private static void search_ticket() {
        int[] rowDetails = row_validator("check the availability of");
        int seatNumber = seatNum_validator(rowDetails);
        int row_value = rowDetails[0]; // getting the row and seat number by validating them
        char row_let;
        if (row_value == 0) {
            row_let = 'A';
        } else if (row_value == 1) {
            row_let = 'B';
        } else if (row_value == 2) {
            row_let = 'C';
        } else  {
            row_let = 'D';
        }
        if (seatingPlan[row_value][seatNumber-1] == 0) { // checking availability
            System.out.println("The seat is available");
        } else {
            for (Ticket ticket : tickets) {
                if (ticket != null) {
                    if ((ticket.getRow() == row_let) && (ticket.getSeat() == seatNumber)) {
                        System.out.println("The seat is unavailable");
                        ticket.printTicketInfo(); // if not printing the details of the booked passenger
                        break;
                    }
                }
            }
        }
    }
    /**
     * This method deletes the text file of ticket information created when cancelling a seat booking
     * @param row char value of validated row letter
     * @param seat integer value of validated seat number
     */
    public static void delete(char row, int seat){
        File file =new File(row + String.valueOf(seat) + ".txt");
        if (file.exists()){
            file.delete();
            System.out.println("Ticket deleted successfully");
        }
        else{
            System.out.println("File does not exist.");
        }
    }
}