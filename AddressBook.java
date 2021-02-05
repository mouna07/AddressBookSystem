public class AddressBook {

    public String firstName, lastName, address, city, state;
    public String zip, phoneNumber;

    public AddressBook(String firstName, String lastName, String address, String city, String state, String zip,
            String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    public void displayContact() {
        System.out.println("Name: " + firstName + "\t" + lastName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip Code: " + zip);
        System.out.println("Phone Number: " + phoneNumber);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to AddressBook!\n");
        AddressBook addressBook = new AddressBook(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        addressBook.displayContact();
    }
}
