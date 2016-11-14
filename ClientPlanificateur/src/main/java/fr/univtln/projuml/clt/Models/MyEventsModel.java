package fr.univtln.projuml.clt.Models;

import com.sun.jersey.api.client.GenericType;
import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Events.CSurvey;

import java.util.List;

/**
 * Created by clemzux on 14/11/16.
 */
public class MyEventsModel {
    private static MyEventsModel ourInstance = new MyEventsModel();

    public static MyEventsModel getInstance() {
        return ourInstance;
    }

    private MyEventsModel() {}

    public List<CMeeting> getAllMeetings() {

        return AppConstants.webResource.path("meetings").get(new GenericType<List<CMeeting>>(){});
    }

    public List<CSurvey> getAllSurveys() {

        return AppConstants.webResource.path("surveys").get(new GenericType<List<CSurvey>>(){});
    }
}
