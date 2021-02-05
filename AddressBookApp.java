import java.util.Scanner;

public class AddressBookApp {
    // Constants
    public static final int MAX_CONTACTS_LIMIT = 10;

    public static void main(String[] args) throws Exception {
        // Scanner for input
        Scanner scanner = new Scanner(System.in);
        AddressBookStorage addressBookStorage[] = new AddressBookStorage[MAX_CONTACTS_LIMIT];
        // Variables
        int i = 0;
        int choice = 2;

        System.out.println("Welcome to AddressBook!\n");
        while (i < MAX_CONTACTS_LIMIT) {
            System.out.println("Choice: 1] Add Contact \t2] Display Contacts \t3] Edit Conact \t4] Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(
                            "Please Write in Format.\nFirst_Name Last_Name Adderss City State Zip Phone_Number");
                    addressBookStorage[i] = new AddressBookStorage(scanner.next(), scanner.next(), scanner.next(),
                            scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt());
                    i++;
                    break;
                case 2:
                    for (int j = 0; j < i; j++) {
                        try {
                            addressBookStorage[j].displayContact();
                        } catch (Exception e) {
                            System.out.println("Deleted Contact.");
                        }
                    }
                    break;
                case 3:
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
                            if (addressBookStorage[k].firstName.equals(fname)
                                    && addressBookStorage[k].lastName.equals(lname)) {
                                addressBookStorage[k].editContact(option, value);
                                break;
                            }
                        } catch (Exception e) {
                            continue;
                        }
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
