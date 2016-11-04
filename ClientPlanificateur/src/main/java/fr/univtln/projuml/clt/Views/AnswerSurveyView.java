package fr.univtln.projuml.clt.Views;

import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.COption;
import fr.univtln.projuml.clt.Models.AnswerSurveyModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by imnotfood on 04/11/16.
 */
public class AnswerSurveyView implements Observer{


    /*
     * UI Stuff
     */


    private Stage appStage;
    private Scene previousScene;
    private Scene currentScene;
    private VBox mainPane;

    private ImageView logo;
    private Text surveyQuestion;
    private Text name;
    private TextField nameField;
    private VBox answers;
    private Button validate;
    private Button goBack;


    /*
     * Constants
     */

    private final String NAME = "Entrez un nom:";


    /*
     * Methods
     */

    public AnswerSurveyView(Stage stage, Scene previousScene) {
        this.appStage = stage;
        this.previousScene = previousScene;

        initializeElements();
        initializeMainPane();
        initializeScene();
        setListeners();
    }


    private void initializeScene() {
        currentScene = new Scene(mainPane, AppConstants.WINDOW_WIDTH, AppConstants.WINDOW_HEIGHT);
    }


    private void initializeMainPane() {
        mainPane = new VBox();
        mainPane.setAlignment(Pos.TOP_CENTER);

        HBox nameBox = new HBox();
        nameBox.setAlignment(Pos.CENTER);
        nameBox.getChildren().addAll(name, nameField);

        mainPane.getChildren().addAll(logo, surveyQuestion, nameBox, answers, validate, goBack);
    }


    private void initializeElements() {
        logo = new ImageView(AppConstants.POOPLE_LOGO);

        surveyQuestion = new Text();
        surveyQuestion.setFont(new Font(AppConstants.TITLES_FONT));

        name = new Text(NAME);
        nameField = new TextField();

        answers = new VBox();
        answers.setAlignment(Pos.CENTER);
        validate = new Button(AppConstants.VALIDATE);
        goBack = new Button(AppConstants.GO_BACK);
    }


    private void setListeners() {
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                appStage.setScene(previousScene);
            }
        });
    }


    public void update(Observable o, Object arg) {
        if (o instanceof AnswerSurveyModel) {
            answers.getChildren().clear();

            surveyQuestion.setText(AnswerSurveyModel.getInstance().getSurvey().getTitle());
            List<COption> answersList = AnswerSurveyModel.getInstance().getSurveyAnswers();

            if (answersList != null) {
                int answersSize = answersList.size();
                for (int i = 0; i < answersSize; i++) {
                    CheckBox answerCheckBox = new CheckBox(i + ". " + answersList.get(i).getTitle());
                    answers.getChildren().add(answerCheckBox);
                }
            }
        }
    }


    public Scene getScene() {
        return currentScene;
    }
}
