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
    private Scene scene, previousScene;
    private VBox mainPane;

    private ImageView logo;
    private Text title;

    private Text askAQuestion;
    private TextField questionField;

    private Text setAsPrivate;
    private CheckBox isPrivate;

    private List<Text> answersText;
    private List<TextField> answers;

    private Button addAnAnswer;
    private Button goBack;


    /*
     * AppConstants
     */

    private final String TITLE = "Créer votre Sondage";
    private final String ASK_A_QUESTION = "Posez votre question:";
    private final String SET_AS_PRIVATE = "définir comme privé";
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


    public void initializeScene() {
        scene = new Scene(mainPane, AppConstants.WINDOW_WIDTH, AppConstants.WINDOW_HEIGHT);
    }


    public void initializeMainPane() {
        mainPane = new VBox();
        mainPane.getChildren().addAll(logo, title, askAQuestion, questionField, setAsPrivate, isPrivate,
                answersText.get(0), answers.get(0), addAnAnswer, goBack);
        mainPane.setAlignment(Pos.TOP_CENTER);
    }


    public void initializeElements() {
        logo = new ImageView(AppConstants.POOPER_LOGO);
        title = new Text(TITLE);

        askAQuestion = new Text(ASK_A_QUESTION);
        questionField = new TextField();

        setAsPrivate = new Text(SET_AS_PRIVATE);
        isPrivate = new CheckBox();

        answersText = new ArrayList<Text>();
        answersText.add(new Text(FIRST_ANSWER));
        answers = new ArrayList<TextField>();
        answers.add(new TextField());

        addAnAnswer = new Button(ADD_AN_ANSWER);
        goBack = new Button(AppConstants.GO_BACK);
    }


    public void setListeners() {
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stage.setScene(previousScene);
            }
        });
    }


    public Scene getScene() {
        return scene;
    }
}
