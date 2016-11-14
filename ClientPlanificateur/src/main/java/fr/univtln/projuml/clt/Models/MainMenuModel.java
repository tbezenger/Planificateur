package fr.univtln.projuml.clt.Models;

import com.sun.jersey.api.client.GenericType;
import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Events.CSurvey;

import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * Created by ltonnet637 on 02/11/16.
 */
public class MainMenuModel extends Observable {
    private static MainMenuModel mainMenuModel = new MainMenuModel();
    private MainMenuModel() {}
    public static MainMenuModel getInstance() {
        return mainMenuModel;
    }

    private List<AEvent> events = new ArrayList<AEvent>();
    public String message = "";

    public List<AEvent> getEvents() {
        return events;
    }


    public List<AEvent> getSurveys() {
        List<AEvent> surveys = new ArrayList<AEvent>();
        int quantity = events.size();
        for (int i = 0; i < quantity; i++)
            if (events.get(i) instanceof CSurvey) {
                surveys.add((CSurvey) events.get(i));
            }

        return surveys;
    }


    public List<AEvent> getMeetings() {
        List<AEvent> meetings = new ArrayList<AEvent>();
        int quantity = events.size();
        for (int i = 0; i < quantity; i++) {
            if (events.get(i) instanceof CMeeting) {
                meetings.add((CMeeting) events.get(i));
            }
        }

        return meetings;
    }



    public void setEvents(List<AEvent> pEvents) {
        this.events = pEvents;
        setChanged();
        notifyObservers();
    }


    public void getAllEvents() {
        setEvents(AppConstants.webResource.path("surveys").type(MediaType.APPLICATION_JSON).get(new GenericType<List<AEvent>>() {
        }));
        events.addAll(AppConstants.webResource.path("meetings").type(MediaType.APPLICATION_JSON).get(new GenericType<Collection<? extends AEvent>>(){}));
        setChanged();
        notifyObservers();
    }


    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
