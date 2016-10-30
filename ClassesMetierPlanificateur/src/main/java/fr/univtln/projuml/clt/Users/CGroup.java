package fr.univtln.projuml.clt.Users;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.*;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@NamedQueries(
        @NamedQuery(name = CGroup.FIND_GROUP_ALL, query =
                "select grp from CGroup grp")
)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = CGroup.class)
public class CGroup {

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
    @JoinTable(name = "group_user",
            joinColumns = @JoinColumn(name = "group_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false, updatable = false))
    public List<CUser> getUsers() { return users; }


    public static final String FIND_GROUP_ALL = "findGroupByAll";

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
}
