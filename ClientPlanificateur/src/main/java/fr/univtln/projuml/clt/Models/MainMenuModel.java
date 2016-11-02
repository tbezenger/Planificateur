package fr.univtln.projuml.clt.Models;

import fr.univtln.projuml.clt.Events.AEvent;

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


    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
