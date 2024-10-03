package BookStorePOS;

import java.util.Scanner;

/**
 * Driver program for the Bookstore class
 * @author ilir-meta
 * @version 1.0.0
 */
public class TestHarness {
    /**
     * Displays the menu options for the employee of the Bookstore to serve 
     * as a POS system to check out customers and display information about
     * the bookstore
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        
        //Create the bookstore instance
        Bookstore bookstore = new Bookstore();
        
        //Obtains most of the user input throughout the program
        Scanner userInString = new Scanner(System.in);
        Scanner userInInt = new Scanner(System.in);
        int userAnswer;

        //Creates the inventory of books, CDs, and DVDs
        bookstore.generateInventory();

        boolean shopping = true;
        //TODO Remove temp if not used
        int temp = 0;

        //Generate my logo: Meta Store!
            Logo bookstoreLogo = new Logo();
            bookstoreLogo.printLogo();
            
        while (shopping) {
            //Show user the list of options(These are the three main functionalities)
            System.out.println("\nWelcome to Meta Books! Please chose one of "
                    + "the options below by " +
                    "typing in the number of the option");
            System.out.println("\t 1. Start an Order");
            System.out.println("\t 2. Register a Member & Other Member Options");
            System.out.println("\t 3. Calculate Profit from Monthly Fee for Meta Books");
            System.out.println("\t 4. Exit");

            userAnswer = userInInt.nextInt();//get user option choice

            //Takes user to another menu based off previous answer choice
            switch (userAnswer) {
                case 1 -> {
                    //Before starting the order we make sure to check if customer is a member
                    System.out.println("If you are a current member, type in "
                            + "your phone number. If not type 0");
                    
                    
                    //Store member information in separate variable
                    Scanner customerIn = new Scanner(System.in);
                    String customerPhoneNum = customerIn.nextLine();
                    
                    //Objects to store registered customer info
                    Member currentCustomer = null;
                    PremiumMember currentPremiumCustomer = null;
                    if (bookstore.lookupMember(customerPhoneNum)) {
                        //If current customer is a standard member
                        currentCustomer = bookstore.getMember(customerPhoneNum);
                    } 
                    
                    if (bookstore.lookupPremiumMember(customerPhoneNum)) {
                        //If current customer is a premium member
                        currentPremiumCustomer = bookstore.getPremiumMember(customerPhoneNum);
                    }
                        
                    

                    boolean noCheckout = true;
                    //Menu for adding items, removing items, and finishing the order
                    while (noCheckout) {
                        System.out.println("\nSelect from the following options to edit your order");
                        System.out.println("\t 1. Add a Book to Order");
                        System.out.println("\t 2. Add a CD to Order");
                        System.out.println("\t 3. Add a DVD to Order");
                        System.out.println("\t 4. Remove a Book from Order");
                        System.out.println("\t 5. Remove a CD from Order");
                        System.out.println("\t 6. Remove a DVD from Order");
                        System.out.println("\t 7. Check Current Order");
                        System.out.println("\t 8. Complete Order");

                        userAnswer = userInInt.nextInt();
                        switch (userAnswer) {
                            case 1 -> {
                                System.out.println("\n");
                                bookstore.printBookInventory();
                                System.out.println("Enter the number of the option to select a book");

                                userAnswer = userInInt.nextInt();
                                bookstore.addBookOrder(userAnswer);
                            }
                            case 2 -> {
                                System.out.println("\n");
                                bookstore.printCDInventory();
                                System.out.println("Enter the number of the option to select a CD");

                                userAnswer = userInInt.nextInt();
                                bookstore.addCDOrder(userAnswer);
                            }
                            case 3 -> {
                                System.out.println("\n");
                                bookstore.printDVDInventory();
                                System.out.println("Enter the number of the option to "
                                        + "select a DVD");

                                userAnswer = userInInt.nextInt();
                                bookstore.addDVDOrder(userAnswer);
                            }
                            case 4 -> {
                                System.out.println("\nSelect which of the following "
                                        + "books to remove");
                                bookstore.printBookOrders();

                                userAnswer = userInInt.nextInt();
                                bookstore.cancelBookOrder(userAnswer);
                            }
                            case 5 -> {
                                System.out.println("\nSelect which of the following "
                                        + "CDs to remove");
                                bookstore.printCDOrders();

                                userAnswer = userInInt.nextInt();
                                bookstore.cancelCDOrder(userAnswer);
                            }
                            case 6 -> {
                                System.out.println("\nSelect which of the following "
                                        + "DVDs to remove");
                                bookstore.printDVDOrders();

                                userAnswer = userInInt.nextInt();
                                bookstore.cancelDVDOrder(userAnswer);
                            }
                            case 7 -> {
                                System.out.println("\n");
                                bookstore.displayCurrentOrder();
                            }
                            case 8 -> {
                                if (currentCustomer != null) {
                                    currentCustomer.addToTotalSpent(bookstore.getCurrentTotal());
                                    bookstore.reset();
                                }
                                
                                if (currentPremiumCustomer != null) {
                                    currentPremiumCustomer.addToTotalSpent(bookstore.getCurrentTotal());
                                    bookstore.reset();
                                }
                                noCheckout = false;
                            }
                            default -> System.out.println("Incorrect Input. Please try again");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("\nSelect one of the following member options");
                    System.out.println("\t 1. Register a member");
                    System.out.println("\t 2. Lookup Member Information");
                    System.out.println("\t 3. Pay monthly fee");

                    userAnswer = userInInt.nextInt();
                    switch (userAnswer) {
                        case 1 -> {
                            //Premium or standard membership
                            System.out.println("\n Do you want to be a premium member. "
                                    + "Type 1 for yes and 0 for no");
                            int membType = userInInt.nextInt();

                            //Get new member's name
                            String newName;
                            System.out.println("What is the customer name?");
                            newName = userInString.nextLine();

                            //Get new member's phone number
                            String newPhoneNum;
                            System.out.println("Please enter 10-digit customer phone number");
                            newPhoneNum = userInString.nextLine();

                            if (membType == 1) {
                                //Get premium member's preferred payment method
                                System.out.println("What is your preferred method of payment?" +
                                        "Type 'cash', 'card', or 'check'");
                                String methodOfPay = userInString.nextLine();
                                //Create Premium member
                                bookstore.addPremiumMember(newName, newPhoneNum, methodOfPay);
                            } else {
                                //Create normal member
                                bookstore.addMember(newName, newPhoneNum);
                            }
                        }
                        case 2 -> {
                            //Ask if searching for premium or normal member
                            System.out.println("Is this a premium member lookup. Type 1 for yes and 0 for no");
                            int membType = userInInt.nextInt();
                            System.out.println("Please enter the 10-digit phone number for the member");
                            String newPhoneNum = userInString.nextLine();
                            
                            //Display member info to screen
                            if (membType == 1) {
                                boolean found = bookstore.lookupPremiumMember(newPhoneNum);
                                if (found) {
                                    PremiumMember tempMember = bookstore.getPremiumMember(newPhoneNum);
                                    System.out.println(tempMember.toString());
                                } else {
                                    System.out.println("Premium Member does not exist");
                                }
                            } else {
                                boolean found = bookstore.lookupMember(newPhoneNum);
                                if (found) {
                                    Member tempMember = bookstore.getMember(newPhoneNum);
                                    System.out.println(tempMember.toString());
                                } else {
                                    System.out.println("Standard Member does not exist");
                                }
                            }
                        }
                        case 3 -> {
                            System.out.println("Please enter the phone # of premium member to pay monthly fee");
                            String phoneNum = userInString.nextLine();
                            bookstore.payMonthFee(phoneNum);
                        }
                        default -> System.out.println("Incorrect input. Please try again.");
                    }
                }
                case 3 -> {
                    System.out.println("\nAmount of Money Made from Premium Member's Monthly Fee");
                    System.out.println("Total: " + bookstore.monthlyFeeProfits());
                }
                default -> System.out.println("Error: Incorrect Input, please try again");
            }
        }
    }
}