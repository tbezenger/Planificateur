package fr.univtln.projuml.clt.Events;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.univtln.projuml.clt.Users.CUser;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = AEvent.AEVENT_BY_ALL, query =
                "select event from AEvent event"),
        @NamedQuery(name = AEvent.AEVENT_BY_ID, query =
                "select event from AEvent event where event.id = :Pid")
})
@DiscriminatorColumn(name = "event_type ")
@MappedSuperclass
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include= JsonTypeInfo.As.PROPERTY, property="@class")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = AEvent.class)
//@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AEvent implements Serializable {

    @TableGenerator(name = "eventGenerator",allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="eventGenerator")
    @Column(name="event_id")
    private int id;
    @Column(unique = true)
    protected String title;
    protected boolean isPrivate = false;
    protected Date creationDate;
    // duree de vie de l'evenement en jours
    protected int duration;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private CUser creator;

    public static final String AEVENT_BY_ALL = "eventByAll";
    public static final String AEVENT_BY_ID = "findEventById";


    //////// builders ////////


    public AEvent() {
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


    //////// methods ////////


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

    public AEvent setCreator(CUser creator) {
        this.creator = creator;
        return this;

    }

    @Override
    public String toString() {
        return this.title;
    }
}
