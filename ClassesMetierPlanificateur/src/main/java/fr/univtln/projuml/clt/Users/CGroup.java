package fr.univtln.projuml.clt.Users;

import java.util.ArrayList;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CGroup {
    private int id;
    private String name;
    private CUser owner;
    private ArrayList<CUser> members;

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

    public CGroup(String name, CUser owner) {
        this.owner = owner;
        this.name = name;
    }

    public CGroup(String name, CUser owner, ArrayList<CUser> members) {
        this(name, owner);
        this.members = members;
    }
}
