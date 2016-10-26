package fr.univtln.projuml.clt.Events;

import fr.univtln.projuml.clt.Users.CUser;

import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CMeeting extends AEvent {
    private Date date;
    private Time hour;
    private ArrayList<CUser> participants;

    public ArrayList<CUser> getParticipants() {
        return participants;
    }

    public void addParticipant(CUser pUser){
        this.participants.add(pUser);
    }

    public void subParticipant(CUser pUser){
        this.participants.remove(pUser);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public CMeeting(int id, String title, boolean isPrivate, Date creationDate, int duration, Date date, Time hour, ArrayList<CUser> participants) {
        super(id, title, isPrivate, creationDate, duration);
        this.date = date;
        this.hour = hour;
        this.participants = participants;
    }

    public CMeeting(String title, boolean isPrivate, int duration, Date date, Time hour) {
        super(title, isPrivate, duration);
        this.date = date;
        this.hour = hour;
    }
}
