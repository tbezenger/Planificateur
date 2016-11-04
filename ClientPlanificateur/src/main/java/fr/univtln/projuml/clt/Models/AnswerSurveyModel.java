package fr.univtln.projuml.clt.Models;

import com.sun.jersey.api.client.GenericType;
import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.COption;
import fr.univtln.projuml.clt.Events.CSurvey;

import javax.ws.rs.core.MediaType;
import java.util.List;
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
    private List<COption> surveyAnswers;

    public CSurvey getSurvey() {
        return currentSurvey;
    }


    public void setSurvey(CSurvey currentSurvey) {
        this.currentSurvey = currentSurvey;
        setChanged();
        notifyObservers();

        setAnswersBySurvey();
    }


    public List<COption> getSurveyAnswers() {
        return surveyAnswers;
    }


    public void setAnswersBySurvey() {
        surveyAnswers = AppConstants.webResource.path("options/survey/id/" + currentSurvey.getId())
                .type(MediaType.APPLICATION_JSON).get(new GenericType<List<COption>>(){});
        setChanged();
        notifyObservers();
    }
}
