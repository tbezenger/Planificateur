package fr.univtln.projuml.clt.Models;

import fr.univtln.projuml.clt.Events.AEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by ltonnet637 on 02/11/16.
 */
public class MainMenuModel extends Observable {

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




}
