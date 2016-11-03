package fr.univtln.projuml.clt.Views;

import fr.univtln.projuml.clt.AppConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imnotfood on 03/11/16.
 */
public class CreateSurveyView {



    /*
     * UI Stuff
     */

    private Stage stage;
    private Scene previousScene;
    private Scene currentScene;
    private VBox mainPane;

    private ImageView logo;
    private Text title;

    private Text askAQuestion;
    private TextField questionField;

    private CheckBox makePrivate;

    private List<Text> answersText;
    private List<TextField> answers;

    private Button addAnAnswer;
    private Button validate;
    private Button goBack;


    /*
     * AppConstants
     */

    private final String TITLE = "Créer votre Sondage";
    private final String ASK_A_QUESTION = "Posez votre question:";
    private final String MAKE_PRIVATE = "définir comme privé";
    private final String FIRST_ANSWER = "Choix 1";
    private final String ADD_AN_ANSWER = "Ajouter une Réponse";


    /*
     * Methods
     */


    public CreateSurveyView(Stage stage, Scene previousScene) {
        this.stage = stage;
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
        mainPane.getChildren().addAll(logo, title, askAQuestion, questionField, makePrivate,
                answersText.get(0), answers.get(0), addAnAnswer, goBack);
        mainPane.setAlignment(Pos.TOP_CENTER);
    }


    private void initializeElements() {
        logo = new ImageView(AppConstants.POOPER_LOGO);
        title = new Text(TITLE);

        askAQuestion = new Text(ASK_A_QUESTION);
        questionField = new TextField();

        makePrivate = new CheckBox(MAKE_PRIVATE);

        answersText = new ArrayList<Text>();
        answersText.add(new Text(FIRST_ANSWER));
        answers = new ArrayList<TextField>();
        answers.add(new TextField());

        addAnAnswer = new Button(ADD_AN_ANSWER);
        validate = new Button(AppConstants.VALIDATE);
        goBack = new Button(AppConstants.GO_BACK);
    }


    private void setListeners() {
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stage.setScene(previousScene);
            }
        });
    }


    public Scene getScene() {
        return currentScene;
    }
}
