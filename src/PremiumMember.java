package BookStorePOS;

/**
 * This PremiumMember class represents registered members that shop at the
 * bookstore AND pay a monthly membership fee
 *
 * @author ilir-meta
 * @version 1.0.0
 */
public class PremiumMember {

    private String name;
    private String phoneNum;
    private double totalSpent;
    private final double monthlyFee = 10.50;
    private String payMethod;
    private boolean feePaid;

    /**
     * Constructor that takes field values as arguments
     * @param name Name of premium customer
     * @param phoneNum Phone number of premium customer
     * @param payMethod Preferred payment method of premium customer
     */
    public PremiumMember(String name, String phoneNum, String payMethod) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.payMethod = payMethod;
    }

    /**
     * Constructor that takes PremiumMember object
     * and copies the field values
     * @param copyMem 
     */
    public PremiumMember(PremiumMember copyMem) {
        name = copyMem.getName();
        phoneNum = copyMem.getPhoneNum();
        payMethod = copyMem.getPayMethod();
        totalSpent = copyMem.getTotalSpent();
        feePaid = copyMem.isFeePaid();
    }

    /**
     * @return Name of premium customer
     */
    public String getName() {
        return name;
    }

    /**
     * @param memberName New name for premium customer
     */
    public void setName(String memberName) {
        name = memberName;
    }

    /**
     * @return Phone number for premium customer
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param num New phone number for premium customer 
     */
    public void setPhoneNum(String num) {
        phoneNum = num;
    }

    /**
     * @return Total money spent by premium customer
     */
    public double getTotalSpent() {
        return totalSpent;
    }

    /**
     * @param amount Addition to total spent by premium customer
     */
    public void addToTotalSpent(double amount) {
        totalSpent += amount;
    }
    
    /**
     * @return Amount of monthly fee
     */
    public double getMonthlyFee() {
        return monthlyFee;
    }
    /**
     * Pay monthly fee for premium membership
     */
    public void payMonthlyFee() {
        totalSpent += monthlyFee;
        feePaid = true;
    }

    /**
     * @return True if fee is paid, false otherwise
     */
    public boolean isFeePaid() {
        return feePaid;
    }

    /**
     * @param b Determines whether fee is paid or not
     */
    public void setFeePaid(boolean b) {
        feePaid = b;
    }

    /**
     * @param method New preferred payment method for premium customer
     */
    public void setPayMethod(String method) {
        payMethod = method;
    }

    /**
     * @return Current preferred payment method for premium customer
     */
    public String getPayMethod() {
        return payMethod;
    }

    /**
     * @return String describing PremiumMember object
     */
    @Override
    public String toString() {
        return "Name: " + name + "; Phone#: " + phoneNum + "; Total Spent: "
                + totalSpent + "; Pay Method: " + payMethod + "; Is monthly fee paid: "
                + isFeePaid();
    }
}
