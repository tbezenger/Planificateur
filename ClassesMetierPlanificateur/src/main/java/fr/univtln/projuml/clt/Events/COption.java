package fr.univtln.projuml.clt.Events;

import fr.univtln.projuml.clt.Users.CUser;

import java.util.ArrayList;

/**
 * Created by tomy- on 18/10/2016.
 */

public class COption {
    private int id;
    private String title;
    private ArrayList<CUser> voters;

    public void addVoter(CUser pVoter){
        this.voters.add(pVoter);
    }

    public void subVoter(CUser pVoter){
        this.voters.remove(pVoter);
    }

    public ArrayList<CUser> getVoters() {
        return voters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public COption(String title) {
        this.title = title;
    }
}
