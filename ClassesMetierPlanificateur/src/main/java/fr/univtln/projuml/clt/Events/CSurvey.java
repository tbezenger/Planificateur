package fr.univtln.projuml.clt.Events;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CSurvey extends AEvent {

    private ArrayList<CProposal> proposals;

    public ArrayList<CProposal> getProposals() {
        return proposals;
    }

    public void addProposal(CProposal pProposal){
        proposals.add(pProposal);
    }

    public void addProposal(ArrayList<CProposal> pProposals){
        proposals.addAll(pProposals);
    }

    public void subProposal(CProposal pProposal){
        proposals.remove(pProposal);
    }

    public void subProposal(ArrayList<CProposal> pProposals){
        proposals.removeAll(pProposals);
    }

    public CSurvey(int id, String title, boolean isPrivate, Date creationDate, int duration, ArrayList<CProposal> proposals) {
        super(id, title, isPrivate, creationDate, duration);
        this.proposals = proposals;
    }
}
