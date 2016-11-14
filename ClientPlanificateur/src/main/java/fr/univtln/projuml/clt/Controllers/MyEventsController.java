package fr.univtln.projuml.clt.Controllers;

import fr.univtln.projuml.clt.CProperties;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Events.CSurvey;
import fr.univtln.projuml.clt.Models.MyEventsModel;
import fr.univtln.projuml.clt.Views.MyEventsView;
import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by clemzux on 14/11/16.
 */
public class MyEventsController {

    private MyEventsView myEventsView;
    private MyEventsModel myEventsModel = MyEventsModel.getInstance();

    private List<CMeeting> meetings;
    private List<CSurvey> surveys;

    public MyEventsController(MyEventsView pView) {

        myEventsView = pView;

        initializeListeners();
        initialiseLists();
    }

    private void initialiseLists() {

        meetings = myEventsModel.getAllMeetings();
        surveys = myEventsModel.getAllSurveys();

//        List<CMeeting> meetingsByUser = new ArrayList<CMeeting>();
//        List<CSurvey> surveysByUser = new ArrayList<CSurvey>();
//
//        for (CMeeting m : meetings) {
//
//            if (m.getCreator().getMail().equals(CProperties.userConnected.getMail()))
//                meetingsByUser.add(m);
//        }
//
//        for (CSurvey s : surveys) {
//
//            System.out.println(s.getCreator().getId());
//
//            if (s.getCreator().getMail().equals(CProperties.userConnected.getMail()))
//                surveysByUser.add(s);
//        }

        myEventsView.getMeetingsListView().setItems(FXCollections.observableList(meetings));
        myEventsView.getSurveysListView().setItems(FXCollections.observableList(surveys));
    }

    private void initializeListeners() {

//        myEventsView.get
    }
}
