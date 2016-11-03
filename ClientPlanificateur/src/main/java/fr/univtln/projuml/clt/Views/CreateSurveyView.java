package fr.univtln.projuml.clt.Views;

import fr.univtln.projuml.clt.AppConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

/**
 * Created by imnotfood on 03/11/16.
 */
public class CreateSurveyView {


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
    private TextField questionField;

    private CheckBox makePrivate;

    private VBox answersBox;
    private Text firstAnswer;
    private TextField firstAnswerField;
    private Text secondAnswer;
    private TextField secondAnswerField;

    private Button addAnswer;
    private Button deleteAnswer;
    private Button validate;
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


    /*
     * Methods
     */


    public CreateSurveyView(Stage stage, Scene previousScene) {
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

        HBox askQuestionBox = new HBox();
        askQuestionBox.setAlignment(Pos.CENTER);
        askQuestionBox.getChildren().addAll(askAQuestion, questionField);

        answersBox = new VBox();
        answersBox.setAlignment(Pos.TOP_CENTER);

        ScrollPane scrollableAnswers = new ScrollPane(answersBox);
        scrollableAnswers.setFitToWidth(true);

        HBox firstAnswerBox = new HBox();
        firstAnswerBox.setAlignment(Pos.CENTER);
        firstAnswerBox.getChildren().addAll(firstAnswer, firstAnswerField);

        HBox secondAnswerBox = new HBox();
        secondAnswerBox.setAlignment(Pos.CENTER);
        secondAnswerBox.getChildren().addAll(secondAnswer, secondAnswerField);

        answersBox.getChildren().addAll(firstAnswerBox, secondAnswerBox);


        mainPane.getChildren().addAll(logo, title, askQuestionBox, makePrivate,
                scrollableAnswers, addAnswer, deleteAnswer, validate, goBack);
        mainPane.setAlignment(Pos.TOP_CENTER);
    }


    private void initializeElements() {
        logo = new ImageView(AppConstants.POOPER_LOGO);
        title = new Text(TITLE);
        title.setFont(new Font(AppConstants.TITLES_FONT));

        askAQuestion = new Text(ASK_A_QUESTION);
        questionField = new TextField();

        makePrivate = new CheckBox(MAKE_PRIVATE);

        firstAnswer = new Text(ANSWER + " " + 1 + ":");
        firstAnswerField = new TextField();
        secondAnswer = new Text(ANSWER + " " + 2 + ":");
        secondAnswerField = new TextField();

        addAnswer = new Button(ADD_ANSWER);
        deleteAnswer = new Button(DELETE_ANSWER);
        validate = new Button(AppConstants.VALIDATE);
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
