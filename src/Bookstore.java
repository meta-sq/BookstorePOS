package BookStorePOS;

import java.util.ArrayList;

/**
 * Representation of the bookstore. Stores product and client information
 * and methods to manipulate them
 * @author ilir-meta
 * @version 1.0.0
 */
public class Bookstore {
    //Stores the entire Bookstores inventory(acts as temporary database)
    private ArrayList<Book> bookInventory = new ArrayList<>();
    private ArrayList<CD> CDInventory = new ArrayList<>();
    private ArrayList<DVD> DVDInventory = new ArrayList<>();
    
    //Stores customer orders
    private ArrayList<Book> bookOrders = new ArrayList<>();
    private ArrayList<CD> CDOrders = new ArrayList<>();
    private ArrayList<DVD> DVDOrders = new ArrayList<>();
    
    //Stores registered memebrs info(acts as temporary database)
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<PremiumMember> premiumList = new ArrayList<>();

    //ISBN Number or other unique code
    private int bookNumID;
    private int CDNumID;
    private int DVDNumID;
    
    //Current order total
    private double currentTotal = 0;


    /**
     * Adds book from inventory and adds it to customers order, then removes
     * book from inventory
     * @param numID ISBN code of book
     */
    public void addBookOrder(int numID) {
        //Copies a book from bookInventory arraylist to bookOrder arraylist
        Book bookToOrder;
        for (Book check : bookInventory) {
            if (check.getIDNum() == numID) {
                bookToOrder = new Book(check);
                bookOrders.add(bookToOrder);
                currentTotal += bookToOrder.getPrice();
            }
        }
        //Removes book from bookInventory arraylist
        for (int i = 0; i < bookInventory.size(); i++) {
            if (bookInventory.get(i).getIDNum() == numID) {
                bookInventory.remove(i);
                i++;
            }
        }
    }

    /**
     * Adds CD from inventory and adds it to customers order, then removes
     * CD from inventory
     * @param numID Unique code of CD
     */
    public void addCDOrder(int numID) {
        //Copies a CD from CDInventory arraylist to CDOrder arraylist
        CD CDToOrder;
        for (CD check : CDInventory) {
            if (check.getIDNum() == numID) {
                CDToOrder = new CD(check);
                CDOrders.add(CDToOrder);
                currentTotal += CDToOrder.getPrice();
            }
        }
        //Removes CD from CDInventory arraylist
        for (int i = 0; i < CDInventory.size(); i++) {
            if (CDInventory.get(i).getIDNum() == numID) {
                CDInventory.remove(i);
                i++;
            }
        }
    }

    /**
     * Adds DVD from inventory and adds it to customers order, then removes
     * DVD from inventory
     * @param numID Unique code of DVD
     */
    public void addDVDOrder(int numID) {
        //Copies a DVD from DVDInventory arraylist to DVDOrder arraylist
        DVD DVDToOrder;
        for (DVD check : DVDInventory) {
            if (check.getIDNum() == numID) {
                DVDToOrder = new DVD(check);
                DVDOrders.add(DVDToOrder);
                currentTotal += DVDToOrder.getPrice();
            }
        }
        //Removes DVD from DVDInventory arraylist
        for (int i = 0; i < DVDInventory.size(); i++) {
            if (DVDInventory.get(i).getIDNum() == numID) {
                DVDInventory.remove(i);
                i++;
            }
        }
    }

    /**
     * Returns ISBN
     * @return IBSN code for book
     */
    public int getBookNumID() {
        return bookNumID;
    }
    
    /**
     * Returns unique code
     * @return Unique code for CD
     */
    public int getCDNumID() {
        return CDNumID;
    }
    
    /**
     * Returns unique code
     * @return Unique code for DVD
     */
    public int getDVDNumID() {
        return DVDNumID;
    }

    /**
     * Removes book from customer order and places it back into inventory
     * @param numID IBSN code of book
     */
    public void cancelBookOrder(int numID) {
        //Copies a book from bookOrders arraylist to bookInventory arraylist
        Book removeBook;
        for (Book check : bookOrders) {
            if (check.getIDNum() == numID) {
                removeBook = new Book(check);
                bookInventory.add(removeBook);
                currentTotal -= removeBook.getPrice();
            }
        }
        //Remove a book from the bookOrders arraylist
        for (int i = 0; i < bookOrders.size(); i++) {
            if (bookOrders.get(i).getIDNum() == numID) {
                bookOrders.remove(i);
                i++;
            }
        }
    }

    /**
     * Removes CD from customer order and places it back into inventory
     * @param numID Unique code of CD
     */
    public void cancelCDOrder(int numID) {
        //Copies a CD from CDOrders arraylist to CDInventory arraylist
        CD removeCD;
        for (CD check : CDOrders) {
            if (check.getIDNum() == numID) {
                removeCD = new CD(check);
                CDInventory.add(removeCD);
                currentTotal -= removeCD.getPrice();
            }
        }
        //Remove a CD from the CDOrders arraylist
        for (int i = 0; i < CDOrders.size(); i++) {
            if (CDOrders.get(i).getIDNum() == numID) {
                CDOrders.remove(i);
                i++;
            }
        }
    }

   /**
     * Removes DVD from customer order and places it back into inventory
     * @param numID Unique code of DVD
     */
    public void cancelDVDOrder(int numID) {
        //Copies a DVD from DVDOrders arraylist to DVDInventory arraylist
        DVD removeDVD;
        for (DVD check : DVDOrders) {
            if (check.getIDNum() == numID) {
                removeDVD = new DVD(check);
                DVDInventory.add(removeDVD);
                currentTotal -= removeDVD.getPrice();
            }
        }
        //Remove a DVD from the DVDOrders arraylist
        for (int i = 0; i < DVDOrders.size(); i++) {
            if (DVDOrders.get(i).getIDNum() == numID) {
                DVDOrders.remove(i);
                i++;
            }
        }
    }

    /**
     * Generates the inventory of products for the bookstore
     */
    public void generateInventory() {
        Book book1 = new Book("The General Of The Dead Army", 14.99, "Ismail Kadare", 
                              9781561310074L);
        bookInventory.add(book1);

        Book book2 = new Book("To Kill a Mockingbird", 12.50, "Harper Lee", 9780060173227L);
        bookInventory.add(book2);

        Book book3 = new Book("The Book Thief", 10.00, "Markus Zusak",  9780375842207L);
        bookInventory.add(book3);

        Book book4 = new Book("Animal Farm", 9.99 ,"George Orwell",  9780452284241L);
        bookInventory.add(book4);

        Book book5 = new Book("Gone with the Wind", 13.50, "Margaret Mitchell", 9781416548942L);
        bookInventory.add(book5);

        Book book6 = new Book("The Giving Tree", 8.99, "Shel Silverstein", 9780060256654L);
        bookInventory.add(book6);

        Book book7 = new Book("The Great Gatsby", 12.50, "F. Scott Fitzgerald", 9780743273565L);
        bookInventory.add(book7);

        CD CD1 = new CD("Smells Like Teen Spirit", 5.99, "Nirvana", 202492010);
        CDInventory.add(CD1);

        CD CD2 = new CD("Imagine", 6.99, "John Lennon", 302395010);
        CDInventory.add(CD2);

        CD CD3 = new CD("Sweet Child O'Mine", 5.99, "Guns N' Roses", 562353312);
        CDInventory.add(CD3);

        CD CD4 = new CD("I Will Always Love You", 8.99, "Whitney Houston", 992322000);
        CDInventory.add(CD4);

        CD CD5 = new CD("Born to Run", 6.89, "Bruce Springsteen", 833215697);
        CDInventory.add(CD5);

        CD CD6 = new CD("No Woman No Cry", 7.99, "Bob Marley", 125782010);
        CDInventory.add(CD6);

        CD CD7 = new CD("Every Breath You Take", 1.99, "The Police", 456124597);
        CDInventory.add(CD7);

        DVD DVD1 = new DVD("Avatar", 10.45, "20th Century Studios", 512493046);
        DVDInventory.add(DVD1);

        DVD DVD2 = new DVD("Avengers:Endgame", 11.50, "Walt Disney", 382458202);
        DVDInventory.add(DVD2);

        DVD DVD3 = new DVD("Jurassic Park", 7.99, "Universal Pictures", 567311119);
        DVDInventory.add(DVD3);

        DVD DVD4 = new DVD("John Wick", 8.49, "Lionsgate", 333563998);
        DVDInventory.add(DVD4);

        DVD DVD5 = new DVD("The Lion King", 12.99, "Walt Disney", 432452754);
        DVDInventory.add(DVD5);

        DVD DVD6 = new DVD("Jumanji", 10.50, "Sony Pictures", 532431772);
        DVDInventory.add(DVD6);

        DVD DVD7 = new DVD("Ratatouille", 11.99, "Walt Disney", 215285764);
        DVDInventory.add(DVD7);
    }

    /**
     * Prints the entire book inventory of the bookstore to the screen
     */
    public void printBookInventory() {
        System.out.println("List of Books Available\n--------------------------");
        for (int i = 0; i < bookInventory.size(); i++) {
            String toPrint;
            toPrint = bookInventory.get(i).toString();
            System.out.println(toPrint + "\n");
        }
        System.out.println();
    }
    
    /**
     * Prints the entire CD inventory of the bookstore to the screen
     */
    public void printCDInventory() {
        System.out.println("List of CDs(Music) Available\n--------------------------");
        for (int i = 0; i < CDInventory.size(); i++) {
            String toPrint;
            toPrint = CDInventory.get(i).toString();
            System.out.println(toPrint + "\n");
        }
        System.out.println();
    }
    
    /**
     * Prints the entire DVD inventory of the bookstore to the screen
     */
    public void printDVDInventory() {
        System.out.println("List of DVDs(Movies) Available\n--------------------------");
        for (int i = 0; i < DVDInventory.size(); i++) {
            String toPrint;
            toPrint = DVDInventory.get(i).toString();
            System.out.println(toPrint + "\n");
        }
        System.out.println();
    }

    /**
     * Prints the current order of the customer to the screen
     */
    public void displayCurrentOrder() {
        System.out.println("<--Here are your order details-->");
        System.out.println("Books");
        for (Book printBook : bookOrders) {
            String output = printBook.toString();
            System.out.println(output);
        }

        System.out.println("CDs");
        for (CD printCD : CDOrders) {
            String output = printCD.toString();
            System.out.println(output);
        }

        System.out.println("DVDs");
        for (DVD printDVD : DVDOrders) {
            String output = printDVD.toString();
            System.out.println(output);
        }
    }

    /**
     * Prints only the books of the current order of the customer to the screen
     */
    public void printBookOrders() {
        for (Book bookInOrder : bookOrders) {
            String output = bookInOrder.toString();
            System.out.println(output);
        }
    }

    /**
     * Prints only the CDs of the current order of the customer to the screen
     */
    public void printCDOrders() {
        for (CD CDInOrder : CDOrders) {
            String output = CDInOrder.toString();
            System.out.println(output);
        }
    }

    /**
     * Prints only the DVDs of the current order of the customer to the screen
     */
    public void printDVDOrders() {
        for (DVD DVDInOrder : DVDOrders) {
            String output = DVDInOrder.toString();
            System.out.println(output);
        }
    }
    
    /**
     * Adds a new standard member for the bookstore
     * @param newName Name of registering customer
     * @param newPhoneNum  Phone number of registering customer
     */
    public void addMember(String newName, String newPhoneNum) {
        Member addMember = new Member(newName, newPhoneNum);
        memberList.add(addMember);
    }

    /**
     * Adds a new premium member for the bookstore
     * @param newName Name of registering customer
     * @param newPhoneNum Phone number of registering customer
     * @param newPayMethod Preferred pay method of registering customer
     */
    public void addPremiumMember(String newName, String newPhoneNum, String newPayMethod) {
        PremiumMember addMember = new PremiumMember(newName, newPhoneNum, newPayMethod);
        premiumList.add(addMember);
    }

    /**
     * Searches for standard member by phone number and displays info to screen
     * if member is found
     * @param phoneNum Phone number of registered customer
     * @return True if found, false if not
     */
    public boolean lookupMember(String phoneNum) {
        System.out.println("\nMember\n------------");
        for (Member check : memberList) {
            if (check.getPhoneNum().equals(phoneNum)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for premium member by phone number and displays info to screen
     * if member is found
     * @param phoneNum Phone number of registered customer
     * @return True if found, false if not
     */
    public boolean lookupPremiumMember(String phoneNum) {
        System.out.println("\nPremium Member\n------------");
        for (PremiumMember check : premiumList) {
            if (check.getPhoneNum().equals(phoneNum)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Return the Member object in the Member arraylist
     * @param phoneNum Phone number of standard registered customer
     * @return The object if found, null if not
     */
    public Member getMember(String phoneNum) {
        for (Member check : memberList) {
            if (check.getPhoneNum().equals(phoneNum)) {
                return check;
            }
        }
        return null;
    }
    
    /**
     * Return the Member object in the Member arraylist
     * @param phoneNum Phone number of premium registered customers
     * @return The object if found, null otherwise
     */
    public PremiumMember getPremiumMember(String phoneNum) {
        for (PremiumMember check : premiumList) {
            if (check.getPhoneNum().equals(phoneNum)) {
                return check;
            }
        }
        return null;
    }

    /**
     * Searches premium member by phone number and pays off the monthly fee
     * @param phoneNum Phone number of registered premium customer
     */
    public void payMonthFee(String phoneNum) {
        boolean found = false;

        for (int i = 0; i < premiumList.size(); i++) {
            if (premiumList.get(i).getPhoneNum().equals(phoneNum)) {
                found = true;
                premiumList.get(i).setFeePaid(true);

                premiumList.get(i).addToTotalSpent(premiumList.get(i).getMonthlyFee());
            }
        }

        if (!found) {
            System.out.println("No member exists with that number");
        } else {
            System.out.println("Payment Made Successfully!");
        }
    }

    /**
     * Calculates the total amount of profits earned by the bookstore
     * from the monthly fees of its premium members.
     * @return The total profit
     */
    public double monthlyFeeProfits() {
        double total = 0;
        for (PremiumMember check : premiumList) {
            total += check.getTotalSpent();
        }
        
        return total;
    }
    
    /**
     * Returns the total cost of the order for the customer
     * @return The current total price of the order
     */
    public double getCurrentTotal() {
        return currentTotal;
    }
    
    /**
     * Resets the inventory and order arraylists back to initial state
     * Maintains the member and premium member arraylists
     */
    public void reset() {
        bookInventory.clear();
        CDInventory.clear();
        DVDInventory.clear();
        
        bookOrders.clear();
        CDOrders.clear();
        DVDOrders.clear();
        
        generateInventory();
    }
    
}