package fr.univtln.projuml.clt.Users;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Events.COption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = CUser.FIND_USER_ALL, query =
                "select user from CUser user"),
        @NamedQuery(name = CUser.FIND_USER_BY_ID, query =
                "select user from CUser user where user.id = :Pid")
})
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

    private List<CGroup> groups;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    public List<CGroup> getGroups() { return groups; }

    private List<CMeeting> meetingsAll = new ArrayList<CMeeting>();
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "meetingUsers")
    public List<CMeeting> getMeetings() { return meetingsAll; }

    private List<COption> userOptions = new ArrayList<COption>();
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "optionUsers")
    public List<COption> getOptions() { return userOptions; }

    public static final String FIND_USER_ALL = "findUserByAll";
    public static final String FIND_USER_BY_ID = "findUserById";


    //////// builders ////////


    public CUser(String mail, String firstName, String lastName, int password) {
        this(mail,password);
        this.firstName = firstName;
        this.lastName = lastName;
        groups = new ArrayList<CGroup>();
    }

    public CUser(String mail, int password){
        this.mail = mail;
        this.password = password;
        groups = new ArrayList<CGroup>();
    }
    public CUser(String firstName) {
        this.firstName = firstName;
        groups = new ArrayList<CGroup>();
    }


    //////// methods ////////

    public void addOption(COption pOption) { userOptions.add(pOption); }

    public void removeOption(COption pOption) { userOptions.remove(pOption); }

    public void addMeeting(CMeeting pMeeting) { meetingsAll.add(pMeeting); }

    public void removeMeeting(CMeeting pMeeting) { meetingsAll.remove(pMeeting); }

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

    public CUser() { groups = new ArrayList<CGroup>(); }

    public boolean isGuest(){
        return mail == null;
    }
}
