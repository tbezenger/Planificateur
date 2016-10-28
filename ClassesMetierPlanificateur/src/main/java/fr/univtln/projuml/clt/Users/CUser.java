package fr.univtln.projuml.clt.Users;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CUser {
    private String mail;
    private String firstName;
    private String lastName;
    private int password;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public CUser(String mail, String firstName, String lastName, int password) {
        this(mail,password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CUser(String mail, int password){
        this.mail = mail;
        this.password = password;
    }
    public CUser(String firstName) {
        this.firstName = firstName;
    }
}
