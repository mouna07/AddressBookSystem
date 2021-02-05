import java.util.Scanner;

public class AddressBookApp {
    public static final int MAX_CONTACTS_LIMIT = 10;
    public static Scanner scanner = new Scanner(System.in);

    // Object array of Class storing Address book.
    AddressBookStorage addressBookStorage[] = new AddressBookStorage[MAX_CONTACTS_LIMIT];

    public static void main(String[] args) throws Exception {
        // Variables
        int i = 0;
        int choice;

        // Object
        AddressBookApp addressBook = new AddressBookApp();

        System.out.println("Welcome to AddressBook!\n");
        while (i < MAX_CONTACTS_LIMIT) {
            System.out.println(
                    "Choice: 1] Add Contact \t2] Display Contacts \t3] Edit Conact \t4] Delete Contact \t5] Exit");
            choice = scanner.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    addressBook.addContact(i);
                    System.out.println("New Contact has been Added.");
                    i++;
                    break;
                case 2:
                    addressBook.displayContacts(i);
                    System.out.println("");
                    break;
                case 3:
                    addressBook.editContact(i);
                    System.out.println("Contact has been Edited.\n");
                    break;
                case 4:
                    addressBook.deleteContact(i);
                    System.out.println("Contact has been Deleted.\n");
                    i--;
                    break;
                default:
                    System.out.println("Exiting....");
                    scanner.close();
                    System.exit(0);
                    break;
            }// End case
        } // End while
    } // End Main

    public void addContact(int i) {
        System.out.println("Please Write in Format.\nFirst_Name Last_Name Adderss City State Zip Phone_Number");
        addressBookStorage[i] = new AddressBookStorage(scanner.next(), scanner.next(), scanner.next(), scanner.next(),
                scanner.next(), scanner.nextInt(), scanner.nextInt());
    } // End addContact

    public void displayContacts(int i) {
        for (int j = 0; j < i; j++) {
            try {
                addressBookStorage[j].displayContact();
            } catch (Exception e) {
                System.out.println("Deleted Contact.");
            } // End catch
        } // End for
    }// End displayContact

    public void editContact(int i) {
        String fname, lname, value;
        int option;
        System.out.println("Enter First and last name: \n");
        fname = scanner.next();
        lname = scanner.next();
        System.out.println("Enter Field No (1-7) and New Value: \n");
        option = scanner.nextInt();
        value = scanner.next();
        for (int k = 0; k <= i; k++) {
            try {
                if (addressBookStorage[k].firstName.equals(fname) && addressBookStorage[k].lastName.equals(lname)) {
                    addressBookStorage[k].editContact(option, value);
                    break;
                } // end if
            } catch (Exception e) {
                continue;
            } // End catch
        } // End for
    }// End editContact

    public void deleteContact(int i) {
        String fname, lname, value;
        int option;
        System.out.println("Enter First and last name: \n");
        fname = scanner.next();
        lname = scanner.next();
        for (int k = 0; k <= i; k++) {
            try {
                if (addressBookStorage[k].firstName.equals(fname) && addressBookStorage[k].lastName.equals(lname)) {
                    for (int j = k; j < addressBookStorage.length - 1; j++) {
                        addressBookStorage[j] = addressBookStorage[j + 1];
                    } // end for
                    break;
                } // end if
            } catch (Exception e) {
                continue;
            } // end catch
        } // end for
    }// End deleteContact
}// End class AddressBookApp
