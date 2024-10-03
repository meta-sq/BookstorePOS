package BookStorePOS;

/**
 * This Book class represents the books that the bookstore sells
 * @author ilir-meta
 * @version 1.0.0
 */
public class Book {
    private String title;
    private double price;
    private String author;
    private long idNum;

    /**
     * Constructor that takes each field value as arguments
     * @param title Title of book
     * @param price Price of book
     * @param author Author of book
     * @param idNum  ID of the book
     */
    public Book(String title, double price, String author, long idNum) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.idNum = idNum;
    }

    /**
     * Constructor that takes Book object as argument 
     * and copies field values
     * @param copyBook Book object that is copied
     */
    public Book(Book copyBook) {
        title = copyBook.getTitle();
        price = copyBook.getPrice();
        author = copyBook.getAuthor();
        idNum = copyBook.getIDNum();
    }
    
    /**
     * @return Title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param bookTitle The new title for the book
     */
    public void setTitle(String bookTitle) {
        title = bookTitle;
    }

    /**
     * @return The price of the book
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * @param bookPrice New price for the book
     */
    public void setPrice(double bookPrice) {
        price = bookPrice;
    }
    
    /**
     * @return The author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param bookAuthor The new author for the book
     */
    public void setAuthor(String bookAuthor) {
        author = bookAuthor;
    }

    /**
     * @return The ID for the book
     */
    public long getIDNum() {
        return idNum;
    }

    /**
     * @param num New ID for the book 
     */
    public void setIDNum(long num) {
        idNum = num;
    }

    /**
     * @return String describing the Book object
     */
    @Override
    public String toString() {
        return  idNum + ", " + title  + ", " + author + ", " + price;
    }

}
