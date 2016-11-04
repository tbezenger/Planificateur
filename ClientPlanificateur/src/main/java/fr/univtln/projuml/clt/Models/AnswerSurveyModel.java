package fr.univtln.projuml.clt.Models;

import fr.univtln.projuml.clt.Events.CSurvey;

import java.util.Observable;

/**
 * Created by imnotfood on 04/11/16.
 */
public class AnswerSurveyModel extends Observable{

    private static AnswerSurveyModel answerSurveyModel = new AnswerSurveyModel();
    private AnswerSurveyModel() {}
    public static AnswerSurveyModel getInstance() {
        return answerSurveyModel;
    }


    private CSurvey currentSurvey;


    public CSurvey getSurvey() {
        return currentSurvey;
    }

    public void setSurvey(CSurvey currentSurvey) {
        this.currentSurvey = currentSurvey;
        setChanged();
        notifyObservers();
    }
}
