package fr.univtln.projuml.clt.Places;

import fr.univtln.projuml.clt.Events.CMeeting;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CBooking {
    public final CRoom room;
    public final CMeeting meeting;

    public CBooking(CRoom room, CMeeting meeting) {
        this.room = room;
        this.meeting = meeting;
    }
}
