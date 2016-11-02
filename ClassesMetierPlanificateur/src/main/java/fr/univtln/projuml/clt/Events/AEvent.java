package fr.univtln.projuml.clt.Events;

import fr.univtln.projuml.clt.Users.CUser;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by tomy- on 18/10/2016.
 */
public abstract class AEvent {
    private int id = 0;

    private String title;

    private boolean isPrivate = false;

    private Date creationDate;

    /**
     * duree de vie de l'evenement en jours
     */
    private int duration;

    private final CUser creator = null;

    public CUser getCreator() {
        return creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public AEvent(int id, String title, boolean isPrivate, Date creationDate, int duration) {
        this.id = id;
        this.title = title;
        this.isPrivate = isPrivate;
        this.creationDate = creationDate;
        this.duration = duration;
    }

    public AEvent(String title, boolean isPrivate, int duration) {
        this.title = title;
        this.isPrivate = isPrivate;
        this.duration = duration;
        this.creationDate = Date.valueOf(LocalDate.now());
        Collection<AEvent> collection = new ArrayList<AEvent>();
    }
}
