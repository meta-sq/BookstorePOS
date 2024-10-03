package BookStorePOS;

/**
 * This CD class represents the CDs(music) that the bookstore sells
 * @author ilir-meta
 * @version 1.0.0
 */
public class CD {
    private String title;
    private double price;
    private String artist;
    private int idNum;

    /**
     * Constructor that takes field values as arguments
     * @param title Title of CD
     * @param price Price of CD
     * @param artist Artist of music CD
     * @param idNum ID number of CD
     */
    public CD(String title, double price, String artist, int idNum) {
        this.title = title;
        this.price = price;
        this.artist = artist;
        this.idNum = idNum;
    }

    /**
     * Constructor that takes a CD object as argument 
     * and copies field values
     * @param copyCD 
     */
    public CD(CD copyCD) {
        title = copyCD.getTitle();
        price = copyCD.getPrice();
        artist = copyCD.getArtist();
        idNum = copyCD.getIDNum();
    }

    /**
     * @return The title of the CD
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param titleOfCD The new title for the CD 
     */
    public void setTitle(String titleOfCD) {
        title = titleOfCD;
    }

    /**
     * @return The price of the CD
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * 
     * @param priceOfCD The new price for the CD
     */
    public void setPrice(double priceOfCD) {
        price = priceOfCD;
    }

    /**
     * @return The artist of the CD
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artistName The new artist for the CD
     */
    public void setArtist(String artistName) {
        artist = artistName;
    }

    /**
     * 
     * @return The ID number of the CD
     */
    public int getIDNum() {
        return idNum;
    }

    /**
     * @param num The new ID number for the CD
     */
    public void setIDNum(int num) {
        idNum = num;
    }

    /**
     * 
     * @return String describing the CD object
     */
    @Override
    public String toString() {
        return idNum + ", " + title + ", " + artist + ", " + price;
    }

}
