package fr.univtln.projuml.clt.Controllers;

import fr.univtln.projuml.clt.Events.CSurvey;
import fr.univtln.projuml.clt.Models.AnswerSurveyModel;
import fr.univtln.projuml.clt.Models.ConnectionModel;
import fr.univtln.projuml.clt.Models.MainMenuModel;
import fr.univtln.projuml.clt.Views.AnswerSurveyView;
import fr.univtln.projuml.clt.Views.ConnectionView;
import fr.univtln.projuml.clt.Views.MainMenuView;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by ltonnet637 on 02/11/16.
 */
public class MainMenuController {

    private MainMenuView view;
    private MainMenuModel model = MainMenuModel.getInstance();

    public MainMenuController(MainMenuView pView) {
        this.view = pView;
        getAllEvents();
    }

    public void openConnectionView(){
        new ConnectionView();
        ConnectionModel.getInstance().addObserver(view);
    }

    public void logOut(){
        ConnectionModel.getInstance().setCurrentUser(null);
    }

    public void openSurvey(CSurvey pSurvey) {
        AnswerSurveyModel.getInstance().setSurvey(pSurvey);
    }

    public void getAllEvents() {
        model.getAllEvents();
    }

}
