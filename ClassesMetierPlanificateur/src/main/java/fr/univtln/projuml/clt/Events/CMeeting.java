package fr.univtln.projuml.clt.Events;

import fr.univtln.projuml.clt.Places.CRoom;
import fr.univtln.projuml.clt.Users.CUser;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@NamedQueries(
        @NamedQuery(name = CMeeting.MEETING_BY_ALL, query =
                "select meeting from CMeeting meeting")
)
@DiscriminatorValue(value = "meeting")
public class CMeeting extends AEvent {

    private Date date;
    private Time hour;

    private List<CUser> meetingUsers = new ArrayList<CUser>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    public List<CUser> getUsersMeeting() {
        return meetingUsers;
    }

    private List<CRoom> meetingRooms = new ArrayList<CRoom>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    public List<CRoom> getMeetingRooms() {
        return meetingRooms;
    }

    public static final String MEETING_BY_ALL = "findMeetingAll";


    //////// builders ////////


    public CMeeting() {}

    public CMeeting(int id, String title, boolean isPrivate, Date creationDate, int duration, Date date, Time hour, ArrayList<CUser> participants) {
        super(id, title, isPrivate, creationDate, duration);
        this.date = date;
        this.hour = hour;
//        this.usersMeeting = participants;
    }

    public CMeeting(String title, boolean isPrivate, int duration, Date date, Time hour) {
        super(title, isPrivate, duration);
        this.date = date;
        this.hour = hour;
    }


    //////// methods ////////


    public void addRoom(CRoom pRoom) { meetingRooms.add(pRoom); }

    public void removeRoom(CRoom pRoom) { meetingRooms.remove(pRoom); }

    public List<CUser> getParticipants() { return meetingUsers; }

    public void addParticipant(CUser pUser){ this.meetingUsers.add(pUser); }

    public void subParticipant(CUser pUser){ this.meetingUsers.remove(pUser); }

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

//    public void addRoom(CRoom pRoom) { rooms.add(pRoom); }
//
//    public void removeRoom(CRoom pRoom) { rooms.remove(pRoom); }
}
