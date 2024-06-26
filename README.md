# Plane Management System

Welcome to the Plane Management System, a Java-based application for managing the seating and ticketing of a plane. This application allows users to buy and cancel seats, view the seating plan, and search for tickets, among other features.

## Features

1. **Buy a seat**: Book a seat and record passenger details.
2. **Cancel a seat**: Cancel a previously booked seat and remove passenger details.
3. **Find the first available seat**: Locate the first available seat in the seating plan.
4. **Show seating plan**: Display the current seating plan with booked and available seats.
5. **Print tickets information and total sales**: View all booked tickets and the total sales.
6. **Search ticket**: Search for a ticket to check its availability and view passenger details.
7. **Quit**: Exit the application.

## How to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/plane-management-system.git
    ```

2. Navigate to the project directory:
    ```bash
    cd plane-management-system
    ```

3. Compile the Java program:
    ```bash
    javac w2052049_PlaneManagement.java Ticket.java Person.java
    ```

4. Run the program:
    ```bash
    java w2052049_PlaneManagement
    ```

## Usage

Once you run the program, you will see a menu

Enter the number corresponding to the option you want to select and follow the on-screen instructions.

### Buying a Seat

When buying a seat, you will be prompted to enter the row letter and seat number. After booking the seat, you will need to provide passenger details (name, surname, and email). The ticket information will be saved, and you will see a confirmation message.

### Canceling a Seat

To cancel a seat, you will be prompted to enter the row letter and seat number. If the seat is currently booked, the booking will be canceled, and the ticket information will be removed.

### Finding the First Available Seat

This option will search for the first available seat and display its location.

### Showing the Seating Plan

The seating plan will be displayed, showing 'O' for available seats and 'X' for booked seats.

### Printing Tickets Information and Total Sales

This option will print the details of all booked tickets and display the total sales amount.

### Searching for a Ticket

Enter the row letter and seat number to check the availability of a seat and view the passenger details if the seat is booked.

## Classes and Methods

### w2052049_PlaneManagement

- `main(String[] args)`: Main method that displays the menu and handles user input.
- `buy_seat()`: Handles seat booking and passenger detail recording.
- `cancel_seat()`: Handles seat cancellation and ticket removal.
- `find_first_available()`: Finds and displays the first available seat.
- `show_seating_plan()`: Displays the current seating plan.
- `print_tickets_info()`: Prints all booked tickets and total sales.
- `search_ticket()`: Searches for a specific ticket and displays its details.
- `delete(char row, int seat)`: Deletes the ticket file for a canceled booking.

### Ticket

- `Ticket(char row, int seat, int price, Person person, String Name, String surName, String eMail)`: Constructor to initialize ticket details.
- `getRow()`: Returns the row of the ticket.
- `getSeat()`: Returns the seat number of the ticket.
- `getPrice()`: Returns the price of the ticket.
- `getPerson()`: Returns the person associated with the ticket.
- `setRow(char newRow)`: Sets a new row for the ticket.
- `setSeat(int newSeat)`: Sets a new seat number for the ticket.
- `setPerson(Person newPerson)`: Sets a new person for the ticket.
- `printTicketInfo()`: Prints the ticket information.
- `save()`: Saves the ticket information to a file.

### Person

- `Person(String Name, String surName, String eMail)`: Constructor to initialize person details.
- `getName()`: Returns the name of the person.
- `getSurName()`: Returns the surname of the person.
- `getEMail()`: Returns the email of the person.
- `setName(String newName)`: Sets a new name for the person.
- `setSurName(String newSurName)`: Sets a new surname for the person.
- `setEMail(String newEMail)`: Sets a new email for the person.
- `printPersonInfo()`: Prints the person information.

## Dependencies

- Java SE Development Kit (JDK)

