package fr.univtln.projuml.clt;

/**
 * Created by tomy- on 18/10/2016.
 */


import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Events.CProposal;
import fr.univtln.projuml.clt.Events.CSurvey;
import fr.univtln.projuml.clt.Users.CGroup;
import fr.univtln.projuml.clt.Users.CUser;


public class Planner {
    private static Planner planner = new Planner();

    public static Planner getInstance() {
        return planner;
    }

    private Planner() {
    }


    public Planner createMeeting(CMeeting pMeeting){
        return this;
    }

    public Planner createSurvey(CSurvey pSurvey){
        return this;
    }

    public Planner vote(CProposal pProposal){
        return this;
    }

    public Planner participate(CMeeting pMeeting){
        return this;
    }

    public Planner deleteEvent(AEvent pEvent){
        return this;
    }

    public Planner updateProposal(CProposal pProposal){
        return this;
    }

    public Planner updateSurvey(CSurvey pSurvey){
        return this;
    }

    public Planner invite(String pEmail){
        return this;
    }

    public Planner addFriend(CUser pUser){
        return this;
    }

    public Planner subFriend(CUser pUser){
        return this;
    }

    public Planner createGroup(CGroup pGroup){
        return this;
    }

    public Planner deleteGroup(CGroup pGroup){
        return this;
    }

    public Planner addInGroup(CUser pUser, CGroup pGroup){
        return this;
    }

    public Planner deleteFromGroup(CUser pUser, CGroup pGroup){
        return this;
    }

    public Planner getEventsOfCurrentUser(){
        return this;
    }


}
