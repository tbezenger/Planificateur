package fr.univtln.projuml.clt.Models;

import com.sun.jersey.api.client.GenericType;
import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.COption;
import fr.univtln.projuml.clt.Events.CSurvey;

import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by imnotfood on 04/11/16.
 */
public class CreateSurveyModel {

    /* Meeting
     * webResource.path("meetings").type(MediaType.APPLICATION_JSON).post(m1);
     */

    private static CreateSurveyModel createSurveyModel = new CreateSurveyModel();
    private CreateSurveyModel() {}
    public static CreateSurveyModel getInstance() {
        return createSurveyModel;
    }


    public boolean createSurvey(String question, boolean privateSurvey, List<String> answers) {

        List<AEvent> surveys = AppConstants.webResource.path("surveys").type(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<AEvent>>(){});

        int surveySize = surveys.size();
        for (int i = 0; i < surveySize; i++) {
            if (surveys.get(i).getTitle().equals(question))
                return false;
        }

        CSurvey newSurvey = new CSurvey(question, privateSurvey, 1000);
        AppConstants.webResource.path("surveys").type(MediaType.APPLICATION_JSON).post(newSurvey);


//        CSurvey newSurveyId = AppConstants.webResource.path("surveys/title/" + question).type(MediaType.APPLICATION_JSON).get(CSurvey.class);
        surveys = AppConstants.webResource.path("surveys").type(MediaType.APPLICATION_JSON).get(new GenericType<List<AEvent>>(){});
        for (AEvent surv : surveys) {
            if (surv.getTitle().equals(question))
                newSurvey.setId(surv.getId());
        }

        System.out.println();
        for (String answer : answers) {
            COption newAnswer = new COption(answer);
            newAnswer.setSurvey(newSurvey);
            System.out.println("lalala");
            AppConstants.webResource.path("options").type(MediaType.APPLICATION_JSON).post(newAnswer);
        }

        return true;
    }
}
