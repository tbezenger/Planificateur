package fr.univtln.projuml.clt.Events;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CSurvey extends AEvent {

    private ArrayList<COption> proposals;

    public ArrayList<COption> getProposals() {
        return proposals;
    }

    public void addProposal(COption pProposal){
        proposals.add(pProposal);
    }

    public void addProposal(ArrayList<COption> pProposals){
        proposals.addAll(pProposals);
    }

    public void subProposal(COption pProposal){
        proposals.remove(pProposal);
    }

    public void subProposal(ArrayList<COption> pProposals){
        proposals.removeAll(pProposals);
    }

    public CSurvey(int id, String title, boolean isPrivate, Date creationDate, int duration, ArrayList<COption> proposals) {
        super(id, title, isPrivate, creationDate, duration);
        this.proposals = proposals;
    }

    public CSurvey(String title, boolean isPrivate, int duration) {
        super(title, isPrivate, duration);
    }
}
