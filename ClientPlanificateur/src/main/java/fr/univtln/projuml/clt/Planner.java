package fr.univtln.projuml.clt;

/**
 * Created by tomy- on 18/10/2016.
 */


import fr.univtln.projuml.clt.Events.*;
import fr.univtln.projuml.clt.Users.CGroup;
import fr.univtln.projuml.clt.Users.CUser;


public class Planner {
    private static Planner planner = new Planner();
    private static CSurvey currentSurvey;

    public static Planner getInstance() {
        return planner;
    }

    private Planner() {
    }


    public Planner createMeeting(CMeeting pMeeting){
        return this;
    }

    public Planner createSurvey(String title,boolean isPrivate, int duration){
        currentSurvey = new CSurvey(title, isPrivate, duration);
        return this;
    }

    public Planner validateSurvey(){
        // envoyer currentSurvey au serveur pour persistance
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

    public Planner addOption(String title){
        COption option = new COption(title);
        currentSurvey.addProposal(option);
        return this;
    }

    public Planner updateOption(COption pOption){
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
