package fr.univtln.projuml.clt.Views;

import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Controllers.CreateSurveyController;
import fr.univtln.projuml.clt.Models.MainMenuModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imnotfood on 03/11/16.
 */
public class CreateSurveyView {

    private CreateSurveyController controller;

    /*
     * UI Stuff
     */

    private Stage appStage;
    private Scene previousScene;
    private Scene currentScene;
    private VBox mainPane;

    private ImageView logo;
    private Text title;

    private Text askAQuestion;
    private TextField askAQuestionField;

    private CheckBox makePrivate;

    private VBox answersBox;
    private Text firstAnswer;
    private TextField firstAnswerField;
    private Text secondAnswer;
    private TextField secondAnswerField;

    private Button addAnswer;
    private Button deleteAnswer;
    private Button validate;
    private Button clear;
    private Button goBack;


    /*
     * AppConstants
     */

    private final String TITLE = "Créez votre Sondage";
    private final String ASK_A_QUESTION = "Posez votre question:";
    private final String MAKE_PRIVATE = "définir comme privé";
    private final String ANSWER = "Choix";
    private final String ADD_ANSWER = "Ajouter une Réponse";
    private final String DELETE_ANSWER = "Supprimer une Réponse";

    private final double ANSWERS_SPACING = 5;
    private final double SCROLLPANE_MARGIN = 10;


    /*
     * Methods
     */


    public CreateSurveyView(Stage stage, Scene previousScene) {
        this.appStage = stage;
        this.previousScene = previousScene;

        controller = new CreateSurveyController(this);

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
        mainPane.setSpacing(AppConstants.GENERAL_SPACING);
        mainPane.setAlignment(Pos.TOP_CENTER);

        HBox askQuestionBox = new HBox();
        askQuestionBox.setAlignment(Pos.CENTER);
        askQuestionBox.setSpacing(AppConstants.SMALL_SPACING);
        askQuestionBox.getChildren().addAll(askAQuestion, askAQuestionField);

        answersBox = new VBox();
        answersBox.setAlignment(Pos.TOP_CENTER);
        answersBox.setSpacing(ANSWERS_SPACING);

        ScrollPane scrollableAnswers = new ScrollPane(answersBox);
        scrollableAnswers.setFitToWidth(true);
        scrollableAnswers.setPadding(new Insets(SCROLLPANE_MARGIN, 0, 0, SCROLLPANE_MARGIN));

        HBox firstAnswerBox = new HBox();
        firstAnswerBox.setAlignment(Pos.CENTER);
        firstAnswerBox.setSpacing(AppConstants.SMALL_SPACING);
        firstAnswerBox.getChildren().addAll(firstAnswer, firstAnswerField);

        HBox secondAnswerBox = new HBox();
        secondAnswerBox.setAlignment(Pos.CENTER);
        secondAnswerBox.setSpacing(AppConstants.SMALL_SPACING);
        secondAnswerBox.getChildren().addAll(secondAnswer, secondAnswerField);

        answersBox.getChildren().addAll(firstAnswerBox, secondAnswerBox);


        HBox addDeleteAnswerBox = new HBox();
        addDeleteAnswerBox.setAlignment(Pos.CENTER);
        addDeleteAnswerBox.setSpacing(AppConstants.SMALL_SPACING);
        addDeleteAnswerBox.getChildren().addAll(addAnswer, deleteAnswer);

        HBox okCancelBox = new HBox();
        okCancelBox.setAlignment(Pos.CENTER);
        okCancelBox.setSpacing(AppConstants.SMALL_SPACING);
        okCancelBox.getChildren().addAll(validate, clear, goBack);


        mainPane.getChildren().addAll(logo, title, askQuestionBox, makePrivate, scrollableAnswers, addDeleteAnswerBox,
                okCancelBox);
    }


    private void initializeElements() {
        logo = new ImageView(AppConstants.POOPLE_LOGO);
        title = new Text(TITLE);
        title.setFont(new Font(AppConstants.TITLES_FONT));

        askAQuestion = new Text(ASK_A_QUESTION);
        askAQuestionField = new TextField();

        makePrivate = new CheckBox(MAKE_PRIVATE);

        firstAnswer = new Text(ANSWER + " " + 1 + ":");
        firstAnswerField = new TextField();
        secondAnswer = new Text(ANSWER + " " + 2 + ":");
        secondAnswerField = new TextField();

        addAnswer = new Button(ADD_ANSWER);
        deleteAnswer = new Button(DELETE_ANSWER);
        validate = new Button(AppConstants.VALIDATE);
        clear = new Button(AppConstants.CLEAR_VALUES);
        goBack = new Button(AppConstants.GO_BACK);
    }


    private void setListeners() {
        addAnswer.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                Text newAnswer = new Text();
                TextField newAnswerField = new TextField();

                HBox newAnswerBox = new HBox();
                newAnswerBox.setAlignment(Pos.CENTER);
                newAnswerBox.getChildren().addAll(newAnswer, newAnswerField);

                answersBox.getChildren().add(newAnswerBox);

                newAnswer.setText(ANSWER + " " + answersBox.getChildren().size() + ":");
            }
        });


        deleteAnswer.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(answersBox.getChildren().size() > 2)
                    answersBox.getChildren().remove(answersBox.getChildren().size()-1);
            }
        });


        validate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                List<String> textAnswers = new ArrayList<String>();
                int boxSize = answersBox.getChildren().size();
                for(int i = 0; i < boxSize; i++) {
                    String answer;
                    answer = ((TextField)((HBox)answersBox.getChildren().get(i)).getChildren().get(1)).getText();
                    textAnswers.add(answer);
                }
                controller.createSurvey(askAQuestionField.getText(), makePrivate.isSelected(), textAnswers);
                MainMenuModel.getInstance().message = AppConstants.SURVEY_VALIDATION;
                appStage.setScene(previousScene);
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                askAQuestionField.clear();
                makePrivate.setSelected(false);
                firstAnswerField.clear();
                secondAnswerField.clear();

                int answersAmount = answersBox.getChildren().size();
                while (answersAmount > 2) {
                    answersBox.getChildren().remove(answersAmount - 1);
                    answersAmount--;
                }
            }
        });

        goBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                appStage.setScene(previousScene);
            }
        });
    }


    public Scene getScene() {
        return currentScene;
    }
}
