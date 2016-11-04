package fr.univtln.projuml.clt.Models;

import com.sun.jersey.api.client.GenericType;
import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.CMeeting;

import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by imnotfood on 04/11/16.
 */
public class CreateMeetingModel {

    private static CreateMeetingModel createMeetingModel = new CreateMeetingModel();
    private CreateMeetingModel() {}
    public static CreateMeetingModel getInstance() {
        return createMeetingModel;
    }


    public boolean createMeeting(String title, String address, String building, String roomNumber,
                              String date, String time, boolean privateMeeting) {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");

        try {
            Date parsedDate = new Date(dateFormatter.parse(date).getTime());
            Time parsedTime = new Time(timeFormatter.parse(time).getTime());

            CMeeting newMeeting = new CMeeting(title, privateMeeting, 1000, parsedDate, parsedTime);

            List<CMeeting> meetings = AppConstants.webResource.path("meetings").type(MediaType.APPLICATION_JSON_TYPE)
                    .get(new GenericType<List<CMeeting>>() {
                    });

            for (CMeeting lMeeting : meetings)
                if (lMeeting.getTitle().equals(title))
                    return false;

            AppConstants.webResource.path("meetings").type(MediaType.APPLICATION_JSON).post(newMeeting);
            return true;


        } catch (ParseException e) { e.printStackTrace(); }

        return false;
    }
}
