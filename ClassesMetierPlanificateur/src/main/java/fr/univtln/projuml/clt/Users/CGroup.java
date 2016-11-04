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
@NamedQueries({
        @NamedQuery(name = CGroup.FIND_GROUP_ALL, query =
                "select grp from CGroup grp"),
        @NamedQuery(name = CGroup.FIND_GROUP_BY_ID, query =
                "select  grp from CGroup grp where grp.id = :Pid")
})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = CGroup.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CGroup implements Serializable{

    @TableGenerator(name = "groupGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "groupGenerator")
    @Column(name = "group_id")
    private int id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private CUser owner;

    private List<CUser> users;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    public List<CUser> getUsers() { return users; }


    public static final String FIND_GROUP_ALL = "findGroupByAll";
    public static final String FIND_GROUP_BY_ID = "findGroupById";

    public void setId(int id) { this.id = id; }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public void addUser(CUser user) { users.add(user); }

    public void removeUser(CUser user) { users.remove(user); }

    public CUser getOwner() { return owner; }

    public void setOwner(CUser owner) { this.owner = owner; }

    public CGroup() { users = new ArrayList<CUser>(); }

    public CGroup(String name) {
        this.name = name;
        users = new ArrayList<CUser>();
    }

    @Override
    public String toString() {
        return "CGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }
}
