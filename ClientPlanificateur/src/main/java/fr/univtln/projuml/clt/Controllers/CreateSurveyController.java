package fr.univtln.projuml.clt.Controllers;

import com.sun.jersey.api.client.GenericType;
import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.CSurvey;
import fr.univtln.projuml.clt.Models.CreateSurveyModel;
import fr.univtln.projuml.clt.Models.MainMenuModel;
import fr.univtln.projuml.clt.Views.CreateSurveyView;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by imnotfood on 04/11/16.
 */
public class CreateSurveyController {

    private CreateSurveyView view;
    private CreateSurveyModel model = CreateSurveyModel.getInstance();


    public CreateSurveyController(CreateSurveyView pView) {
        this.view = pView;
    }


    public boolean createSurvey(String question, boolean privateSurvey, List<String> answers) {
        if (question.isEmpty())
            return false;
        for (String answer : answers)
            if (answer.isEmpty())
                return false;
        System.out.println("Controller:" + answers);
        return model.createSurvey(question, privateSurvey, answers);
    }
}
