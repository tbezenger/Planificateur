package fr.univtln.projuml.clt.Controllers;

import fr.univtln.projuml.clt.Models.CreateSurveyModel;
import fr.univtln.projuml.clt.Views.CreateSurveyView;

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

        model.createSurvey(question, privateSurvey, answers);
        return true;
    }
}
