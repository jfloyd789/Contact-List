
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // ArrayList to store contacts
    private ArrayList<Person> contacts;

    // Constructor to initialize contacts
    public ContactList() {
        contacts = new ArrayList<>();
    }

    // Prints menu options
    public void printMenuOptions() {
        System.out.println("Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. List All Teachers");
        System.out.println("7. Search By First Name");
        System.out.println("8. Search By Last Name");
        System.out.println("9. Search By Phone Number");
        System.out.println("0. Exit");
    }

    // Returns the contacts ArrayList
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Adds a contact based on user input
    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Contact Type (1 for Student, 2 for Teacher): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Collect common attributes
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter Grade: ");
            int grade = scanner.nextInt();
            scanner.nextLine();
            contacts.add(new Student(firstName, lastName, phoneNumber, grade));
        } else if (choice == 2) {
            System.out.print("Enter Subject: ");
            String subject = scanner.nextLine();
            contacts.add(new Teacher(firstName, lastName, phoneNumber, subject));
        } else {
            System.out.println("Invalid Contact Type. Contact not added.");
        }
    }

    // Prints all contacts
    public void printContacts() {
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    // Bubble sort by attribute
    public void sort(int sortBy) {
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                boolean swapNeeded = false;
                if (sortBy == 0) {
                    swapNeeded = contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0;
                } else if (sortBy == 1) {
                    swapNeeded = contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0;
                } else if (sortBy == 2) {
                    swapNeeded = contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0;
                }
                if (swapNeeded) {
                    swap(j);
                }
            }
        }
    }

    // Swaps two contacts in the ArrayList
    public void swap(int index) {
        Person temp = contacts.get(index);
        contacts.set(index, contacts.get(index + 1));
        contacts.set(index + 1, temp);
    }

    // Searches for a contact by first name
    public Person searchByFirstName(String firstName) {
        for (Person contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null;
    }

    // Searches for a contact by last name
    public Person searchByLastName(String lastName) {
        for (Person contact : contacts) {
            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }

    // Searches for a contact by phone number
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    // Lists all students in the contact list
    public void listStudents() {
        for (Person contact : contacts) {
            if (contact instanceof Student) {
                System.out.println(contact);
            }
        }
    }

    // Lists all teachers in the contact list
    public void listTeachers() {
        for (Person contact : contacts) {
            if (contact instanceof Teacher) {
                System.out.println(contact);
            }
        }
    }

    // Runs the program
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("Welcome to your Contacts List");
        while (choice != 0) {
            printMenuOptions();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addContact();
            } else if (choice >= 2 && choice <= 4) {
                sort(choice - 2);
                printContacts();
            } else if (choice == 5) {
                listStudents();
            } else if (choice == 6) {
                listTeachers();
            } else if (choice >= 7 && choice <= 9) {
                System.out.print("Enter search term: ");
                String term = scanner.nextLine();
                Person result = (choice == 7) ? searchByFirstName(term) :
                                 (choice == 8) ? searchByLastName(term) :
                                 searchByPhoneNumber(term);
                if (result == null) {
                    System.out.println("No match found.");
                } else {
                    System.out.println(result);
                }
            } else if (choice == 0) {
                System.out.println("Exiting program.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ContactList cl = new ContactList();
        cl.run();
    }
}
