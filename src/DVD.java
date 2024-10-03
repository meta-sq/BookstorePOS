package BookStorePOS;

/**
 * This DVD class represents the DVDs(movies) that the bookstore sells
 * @author ilir-meta
 * @version 1.0.0
 */
public class DVD {
    private String title;
    private double price;
    private String productionCompany;
    private int idNum;

    /**
     * Constructor that takes field values as arguments
     * @param title Title of the book
     * @param price Price of the book
     * @param productionCompany Production company responsible for film
     * @param idNum ID number of DVD
     */
    public DVD(String title, double price, String productionCompany, 
               int idNum) {
        this.title = title;
        this.price = price;
        this.productionCompany = productionCompany;
        this.idNum = idNum;
    }
    
    /**
     * Constructor that takes CD object as argument
     * and copies the field values
     * @param copyDVD 
     */
    public DVD(DVD copyDVD) {
        title = copyDVD.getTitle();
        price = copyDVD.getPrice();
        productionCompany = copyDVD.getProductionCompany();
        idNum = copyDVD.getIDNum();
    }
    
    /**
     * @return The title of the DVD
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param titleOfDVD The new title for the DVD
     */
    public void setTitle(String titleOfDVD) {
        title = titleOfDVD;
    }

    /**
     * @return The price of the DVD
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * @param priceOfDVD The new price for the DVD
     */
    public void setPrice(double priceOfDVD) {
        price = priceOfDVD;
    }

    /**
     * @return The production company of the DVD film
     */
    public String getProductionCompany() {
        return productionCompany;
    }

    /**
     * @param companyName The new production company for the DVD film
     */
    public void setProductionCompany(String companyName) {
        productionCompany = companyName;
    }

    /**
     * 
     * @return The ID number of the DVD
     */
    public int getIDNum() {
        return idNum;
    }
    
    /**
     * @param num The new ID number for the DVD
     */
    public void setIDNum(int num) {
        idNum = num;
    }

    /**
     * @return String describing the DVD object 
     */
    @Override
    public String toString() {
        return idNum + ", " + title + ", " + productionCompany + ", " + price;
    }
}
