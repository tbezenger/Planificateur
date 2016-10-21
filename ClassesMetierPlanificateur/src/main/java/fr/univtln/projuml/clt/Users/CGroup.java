package fr.univtln.projuml.clt.Users;

import java.util.ArrayList;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CGroup {
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

    public void setMembers(ArrayList<CUser> members) {
        this.members = members;
    }

    public CGroup(CUser owner) {
        this.owner = owner;
    }

    public CGroup(CUser owner, ArrayList<CUser> members) {
        this.owner = owner;
        this.members = members;
    }
}
