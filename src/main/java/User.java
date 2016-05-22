/**
 * Created by Eugeniy Krukun on 22.05.2016.
 */
public class User {
    private Integer ID;
    private String Name;
    private String Surname;
    private String Email;
    private String Password;
    private Float Rating;
    private Integer Status;
    private String Country;

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return Country;
    }

    public String getSurname() {
        return Surname;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public Float getRating() {
        return Rating;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setRating(Float rating) {
        Rating = rating;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
