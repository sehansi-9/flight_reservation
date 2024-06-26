public class Person {
    private String Name;
    private String surName;
    private String eMail;

    //constructor method
    public Person(String Name,String surName,String eMail)
    {
        this.Name= Name;
        this.surName=surName;
        this.eMail=eMail;
    }
    //Getter Methods : Retrieve information from attributes
    public String getName()
    {
        return Name;
    }
    public String getSurName()
    {
        return surName;
    }
    public String getEMail()
    {
        return eMail;
    }

    //Setter Methods : Modify or update existing attribute values
    public void setName(String newName){
        Name=newName;
    }
    public void setSurName(String newSurName){
        surName=newSurName;
    }
    public void setEMail(String newEMail){
        eMail=newEMail;
    }

    /**
     * This method prints person information
     */
    public void printPersonInfo() {
        System.out.println("Name: " + Name);
        System.out.println("Surname: " + surName);
        System.out.println("Email: " + eMail);

    }
}

