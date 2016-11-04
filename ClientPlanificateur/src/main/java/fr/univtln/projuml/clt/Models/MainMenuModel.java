package fr.univtln.projuml.clt.Models;

import com.sun.jersey.api.client.GenericType;
import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.AEvent;

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


    public List<AEvent> getEvents() {
        return events;
    }


    public void addEvent(AEvent pEvent) {
        events.add(pEvent);
        setChanged();
        notifyObservers();
    }


    public void deleteEvent(AEvent pEvent) {
        events.remove(pEvent);
        setChanged();
        notifyObservers();
    }


    public void deleteEvent(int pEventIndex) {
        events.remove(pEventIndex);
        setChanged();
        notifyObservers();
    }


    public void setEvents(List<AEvent> pEvents) {
        this.events = pEvents;
        setChanged();
        notifyObservers();
    }


    public void getAllEvents() {
        setEvents(AppConstants.webResource.path("surveys").type(MediaType.APPLICATION_JSON).get(new GenericType<List<AEvent>>(){}));
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
