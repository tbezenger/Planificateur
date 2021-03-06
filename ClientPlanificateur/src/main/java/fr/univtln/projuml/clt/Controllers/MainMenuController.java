package fr.univtln.projuml.clt.Controllers;

import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Events.CSurvey;
import fr.univtln.projuml.clt.Models.AnswerMeetingModel;
import fr.univtln.projuml.clt.Models.AnswerSurveyModel;
import fr.univtln.projuml.clt.Models.ConnectionModel;
import fr.univtln.projuml.clt.Models.MainMenuModel;
import fr.univtln.projuml.clt.Views.AnswerMeetingView;
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

    public void openSurvey(AnswerSurveyView newView, Stage appStage, Scene mainMenuScene, CSurvey pSurvey) {
        if (newView == null)
            view.setAnswerSurveyView(new AnswerSurveyView(appStage, mainMenuScene));
        AnswerSurveyModel.getInstance().addObserver(view.getAnswerSurveyView());
        AnswerSurveyModel.getInstance().setSurvey(pSurvey);
        appStage.setScene(view.getAnswerSurveyView().getScene());
    }


    public void openMeeting(AnswerMeetingView newView, Stage appStage, Scene mainMenuScene, CMeeting pMeeting) {
        if (newView == null)
            view.setAnswerMeetingView(new AnswerMeetingView(appStage, mainMenuScene));
        AnswerMeetingModel.getInstance().addObserver(view.getAnswerMeetingView());
        AnswerMeetingModel.getInstance().setMeeting(pMeeting);
        appStage.setScene(view.getAnswerMeetingView().getScene());
    }


    public void getAllEvents() {
        model.getAllEvents();
    }

}
