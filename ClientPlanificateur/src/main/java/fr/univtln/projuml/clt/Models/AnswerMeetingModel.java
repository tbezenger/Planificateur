package fr.univtln.projuml.clt.Models;

import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Users.CUser;

import javax.ws.rs.core.MediaType;
import java.util.Observable;

/**
 * Created by imnotfood on 05/11/16.
 */
public class AnswerMeetingModel extends Observable{

    private static AnswerMeetingModel answerMeetingModel = new AnswerMeetingModel();
    private AnswerMeetingModel(){}
    public static AnswerMeetingModel getInstance() {
        return answerMeetingModel;
    }

    private CMeeting currentMeeting;


    public CMeeting getMeeting() {
        return currentMeeting;
    }

    public void setMeeting(CMeeting currentMeeting) {
        this.currentMeeting = currentMeeting;
        setChanged();
        notifyObservers();
    }


    public void participate(CUser currentUser) {
        currentUser.addMeeting(currentMeeting);
        AppConstants.webResource.path("users").type(MediaType.APPLICATION_JSON).post(currentUser);
    }
}
