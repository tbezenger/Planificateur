package fr.univtln.projuml.clt.Models;

import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.CSurvey;

import javax.ws.rs.core.MediaType;
import java.util.List;

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


    public void createSurvey(String question, boolean privateSurvey, List<String> answers) {
        //webResource.path("surveys").type(MediaType.APPLICATION_JSON).post(survey);
        CSurvey surveyTest = new CSurvey(question, privateSurvey, 1000);
        AppConstants.webResource.path("surveys").type(MediaType.APPLICATION_JSON).post(surveyTest);
    }
}
