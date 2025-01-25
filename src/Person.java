public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Accessor methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // toString method to represent a Person
    @Override
    public String toString() {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}

