package fr.univtln.projuml.clt.Controllers;

import fr.univtln.projuml.clt.Models.AnswerMeetingModel;
import fr.univtln.projuml.clt.Models.ConnectionModel;
import fr.univtln.projuml.clt.Models.MainMenuModel;
import fr.univtln.projuml.clt.Views.AnswerMeetingView;

/**
 * Created by imnotfood on 05/11/16.
 */
public class AnswerMeetingController {

    AnswerMeetingView view;
    AnswerMeetingModel model = AnswerMeetingModel.getInstance();

    public AnswerMeetingController(AnswerMeetingView view) {
        this.view = view;
    }


    public boolean participate() {
        if (ConnectionModel.getInstance().getCurrentUser() == null)
            return false;

        AnswerMeetingModel.getInstance().participate(ConnectionModel.getInstance().getCurrentUser());
        return true;
    }
}
