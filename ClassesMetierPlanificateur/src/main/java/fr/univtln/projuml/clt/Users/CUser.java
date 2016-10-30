package fr.univtln.projuml.clt.Users;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@Table(name = "cuser")
@NamedQueries(
        @NamedQuery(name = CUser.FIND_USER_ALL, query =
                "select user from CUser user")
)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = CUser.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CUser implements Serializable{

    @TableGenerator(name = "userGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "userGenerator")
    @Column(name = "user_id")
    private int id;
    private String mail;
    private String firstName;
    private String lastName;
    private int password;

    private Set<CGroup> groups;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    public Set<CGroup> getGroups() { return groups; }

    public static final String FIND_USER_ALL = "findUserByAll";

    public void addGroup(CGroup group) { groups.add(group); }

    public void removeGroup(CGroup group) { groups.remove(group); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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

    public CUser() { groups = new HashSet<CGroup>(); }

    public CUser(String mail, String firstName, String lastName, int password) {
        this(mail,password);
        this.firstName = firstName;
        this.lastName = lastName;
        groups = new HashSet<CGroup>();
    }

    public CUser(String mail, int password){
        this.mail = mail;
        this.password = password;
        groups = new HashSet<CGroup>();
    }
    public CUser(String firstName) {
        this.firstName = firstName;
        groups = new HashSet<CGroup>();
    }

    public boolean isGuest(){
        return mail == null;
    }
}
