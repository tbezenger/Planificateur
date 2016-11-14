package fr.univtln.projuml.clt.Models;

import com.sun.jersey.api.client.GenericType;
import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.CProperties;
import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.COption;
import fr.univtln.projuml.clt.Events.CSurvey;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Observable;

import static java.lang.Thread.sleep;

/**
 * Created by imnotfood on 04/11/16.
 */
public class CreateSurveyModel extends Observable{

    private static CreateSurveyModel createSurveyModel = new CreateSurveyModel();
    private CreateSurveyModel() {}
    public static CreateSurveyModel getInstance() {
        return createSurveyModel;
    }


    public boolean createSurvey(String question, boolean privateSurvey, List<String> answers) {

        List<CSurvey> surveys = AppConstants.webResource.path("surveys").type(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<CSurvey>>(){});

        int surveySize = surveys.size();
        for (int i = 0; i < surveySize; i++) {
            if (surveys.get(i).getTitle().equals(question))
                return false;
        }

        CSurvey newSurvey = new CSurvey(question, privateSurvey, 1000);

        if (CProperties.connected)
            newSurvey.setCreator(CProperties.userConnected);

        AppConstants.webResource.path("surveys").type(MediaType.APPLICATION_JSON).post(newSurvey);

        surveys = AppConstants.webResource.path("surveys").type(MediaType.APPLICATION_JSON).get(new GenericType<List<CSurvey>>(){});
        for (CSurvey surv : surveys) {
            if (surv.getTitle().equals(question))
                newSurvey.setId(surv.getId());
        }

        System.out.println();
        for (String answer : answers) {
            COption newAnswer = new COption(answer);
            newAnswer.setSurvey(newSurvey);
            AppConstants.webResource.path("options").type(MediaType.APPLICATION_JSON).post(newAnswer);
        }

        setChanged();
        notifyObservers();

        return true;
    }
}
