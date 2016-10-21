package fr.univtln.projuml.clt.Events;

import fr.univtln.projuml.clt.Users.CUser;

import java.util.ArrayList;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CProposal {
    private String entitled;
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

    public String getEntitled() {
        return entitled;
    }

    public void setEntitled(String entitled) {
        this.entitled = entitled;
    }

    public CProposal(String entitled, ArrayList<CUser> voters) {
        this.entitled = entitled;
        this.voters = voters;
    }
}
