package BookStorePOS;

/**
 * This Products class represents the books, CDs, and DVDs that the bookstore sells
 * @author ilir-meta
 * @version 1.0.0
 */
public class Product {
    private final String title;
    private double price;
    private final String author;
    private long idNum;
    private final String type; //determines if product is book, cd, or dvd

    /**
     * Constructor that takes each field value as arguments
     * @param type Type of product: book, cd, or dvd
     * @param title Title of product
     * @param price Price of product
     * @param author Author of product
     * @param idNum  ID of the product
     */
    public Product(String type, String title, double price, String author, long idNum) {
        this.type = type;
        this.title = title;
        this.price = price;
        this.author = author;
        this.idNum = idNum;
    }

    /**
     * Constructor that takes Product object as argument 
     * and copies field values
     * @param copyProduct Product object that is copied
     */
    public Product(Product copyProduct) {
        type = copyProduct.getType();
        title = copyProduct.getTitle();
        price = copyProduct.getPrice();
        author = copyProduct.getAuthor();
        idNum = copyProduct.getIDNum();
    }
    
    /**
     * @return Type of Product: book, cd, or dvd
     */
    public String getType() {
        return type;
    }
    
    /**
     * @return Title of the product
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The price of the product
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * @param productPrice New price for the product
     */
    public void setPrice(double productPrice) {
        price = productPrice;
    }
    
    /**
     * @return The author of the product
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return The ID for the product
     */
    public long getIDNum() {
        return idNum;
    }

    /**
     * @param num New ID for the product 
     */
    public void setIDNum(long num) {
        idNum = num;
    }

    /**
     * @return String describing the Product object
     */
    @Override
    public String toString() {
        return  idNum + ", " + title  + ", " + author + ", " + price;
    }

}
