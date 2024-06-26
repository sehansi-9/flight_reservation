import java.io.*;
public class Ticket {
    private char row;
    private int seat;
    private int price;
    private Person person;

// constructor method
    public Ticket (char row, int seat, int price, Person person,String Name, String surName, String eMail){
        this.row= row;
        this.seat= seat;
        this.price= price;
        this.person = person;
        this.person.setName(Name);
        this.person.setSurName(surName);
        this.person.setEMail(eMail);
    }

    //Getter Methods : Retrieve information from attributes
    public char getRow()
    {
        return row;
    }
    public int getSeat()
    {
        return seat;
    }
    public int getPrice()
    {
        return price;
    }
    public Person getPerson() {
        return person;
    }


    //Setter Methods : Modify or update existing attribute values
    public void setRow(char newRow){
        row=newRow;
    }
    public void setSeat(int newSeat){
        seat=newSeat;
    }
    public void setPerson(Person newPerson){
        person=newPerson;
    }


    /**
     * This method prints the ticket info
     */
    public void printTicketInfo() {
        System.out.println("Name: "+ person.getName());
        System.out.println("Surname: "+person.getSurName());
        System.out.println("Email: "+ person.getEMail());
        System.out.println("Row: "+ row);
        System.out.println("Seat: "+ seat);
        System.out.println("Price: "+ price);


    }
    /**
     * This method writes the ticket info to a text file during a successful booking
     */
    public void save() {
        File file = new File(row + String.valueOf(seat) + ".txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Name: " + person.getName() + "\n");
            writer.write("Surname: " + person.getSurName() + "\n");
            writer.write("Email: " + person.getEMail() + "\n");
            writer.write("Row: " + row + "\n");
            writer.write("Seat: " + seat + "\n");
            writer.write("Price: " + price + "\n");
            writer.close();
            System.out.println("Ticket information saved to file: " + file.getName());
        } catch (IOException e) {
            System.out.println("An error occurred while saving ticket information to file");
        }
    }




}