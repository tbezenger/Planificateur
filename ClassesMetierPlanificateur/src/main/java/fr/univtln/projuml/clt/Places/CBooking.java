package fr.univtln.projuml.clt.Places;

import fr.univtln.projuml.clt.Events.CMeeting;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CBooking {

    private final CRoom room;
    private final CMeeting meeting;

    public CBooking(CRoom room, CMeeting meeting) {
        this.room = room;
        this.meeting = meeting;
    }

    public CRoom getRoom() {
        return room;
    }

    public CMeeting getMeeting() {
        return meeting;
    }
}
