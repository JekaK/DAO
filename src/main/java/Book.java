/**
 * Created by Eugeniy Krukun on 22.05.2016.
 */
public class Book {
    private Integer ID = null;
    private String Author;
    private String Title;
    private Float Price;
    private String Publisher;
    private String Owner;
    private String Description;
    private Integer State;
    private Float Rating;
    private Boolean Trade;
    private String Language;

    public Integer getID() {
        return ID;
    }

    public String getAuthor() {
        return Author;
    }

    public String getTitle() {
        return Title;
    }

    public Float getPrice() {
        return Price;
    }

    public String getPublisher() {
        return Publisher;
    }

    public String getOwner() {
        return Owner;
    }

    public String getDescription() {
        return Description;
    }

    public Integer getState() {
        return State;
    }

    public Float getRating() {
        return Rating;
    }

    public Boolean getTrade() {
        return Trade;
    }

    public String getLanguage() {
        return Language;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setState(Integer state) {
        State = state;
    }

    public void setRating(Float rating) {
        Rating = rating;
    }

    public void setTrade(Boolean trade) {
        Trade = trade;
    }

    public void setLanguage(String language) {
        Language = language;
    }
}
