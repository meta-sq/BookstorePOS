package BookStorePOS;

/**
 * This Member class represents registered standard members
 * that shop at the bookstore(Note: Premium Members are separate)
 * @author ilir-meta
 * @version 1.0.0
 */
public class Member {
    private String name;
    private String phoneNum;
    private double totalSpent;

    /**
     * Constructor that takes field values as arguments
     * @param name Name of the registered standard customer
     * @param phoneNum 
     */
    public Member(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    /**
     * @return Name of the standard customer
     */
    public String getName() {
        return name;
    }

    /**
     * @param memberName New name for the standard customer 
     */
    public void setName(String memberName) {
        name = memberName;
    }

    /**
     * @return Phone number of standard customer
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param num The new phone number for the standard customer
     */
    public void setPhoneNum(String num) {
        phoneNum = num;
    }

    /**
     * @return The total amount spent by standard customer
     */
    public double getTotalSpent() {
        return totalSpent;
    }

    /** 
     * @param amount Addition to the current total amount
     */
    public void addToTotalSpent(double amount) {
        totalSpent += amount;
    }

    /**
     * @return String describing the Member objects
     */
    @Override
    public String toString() {
        return "Name: " + name + "; Phone#: " + phoneNum + "; Total Spent: " + totalSpent;
    }
}
