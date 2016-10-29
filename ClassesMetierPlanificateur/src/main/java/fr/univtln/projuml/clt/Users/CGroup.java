package fr.univtln.projuml.clt.Users;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;

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
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "groupGenerator")
    @Column(name = "group_id")
    private int id;
    private String name;
    private CUser owner;
    private ArrayList<CUser> members;

    public static final String FIND_GROUP_ALL = "findGroupByAll";

    public void addMember(CUser pUser){
        this.members.add(pUser);
    }

    public void subMember(CUser pUser){
        this.members.remove(pUser);
    }

    public CUser getOwner() {
        return owner;
    }

    public ArrayList<CUser> getMembers() {
        return members;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setMembers(ArrayList<CUser> members) {
        this.members = members;
    }

    public CGroup() {}

    public CGroup(String name, CUser owner) {
        this.owner = owner;
        this.name = name;
    }

    public CGroup(String name, CUser owner, ArrayList<CUser> members) {
        this(name, owner);
        this.members = members;
    }
}
