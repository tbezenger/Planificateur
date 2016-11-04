package fr.univtln.projuml.clt.Controllers;

import fr.univtln.projuml.clt.Models.CreateMeetingModel;
import fr.univtln.projuml.clt.Views.CreateMeetingView;

/**
 * Created by imnotfood on 04/11/16.
 */
public class CreateMeetingController {

    CreateMeetingView view;
    CreateMeetingModel model = CreateMeetingModel.getInstance();

    public CreateMeetingController(CreateMeetingView view) {
        this.view = view;
    }


    public boolean createMeeting(String title, String address, String building, String roomNumber,
                              String date, String time, boolean privateMeeting){
        String[] parameters = {title, address, building, roomNumber, date, time};
        for (String s : parameters)
            if (s.isEmpty())
                return false;

        model.createMeeting(title, address, building, roomNumber, date, time, privateMeeting);
        return true;
    }
}
