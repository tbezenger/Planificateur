package fr.univtln.projuml.clt.Users;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@NamedQueries(
        @NamedQuery(name = CUser.FIND_USER_ALL, query =
                "select user from Cuser user")
)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = CUser.class)
public class CUser implements Serializable{

    @TableGenerator(name = "userGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "userGenerator")
    @Column(name = "user_id")
    private int id;
    private String mail;
    private String firstName;
    private String lastName;
    private int password;

    public static final String FIND_USER_ALL = "findUserByAll";

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

    public CUser() {}

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

    public boolean isGuest(){
        return mail == null;
    }
}
