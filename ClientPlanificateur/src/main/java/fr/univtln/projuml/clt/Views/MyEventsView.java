package fr.univtln.projuml.clt.Views;

import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Controllers.MyEventsController;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Events.CSurvey;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by clemzux on 14/11/16.
 */
public class MyEventsView {

    private MyEventsController myEventsController;

    private Stage appStage;
    private Scene previousScene;
    private Scene currentScene;

    private VBox primaryBoxVbox, meetingsVbox, surveysVbox;
    private HBox topWindowHbox, allListViewHbox;

    private ImageView logoImageView;
    private Text logText, myMeetingsTitleText, mySurveysTitleText;
    private Button previewButton, deleteButton;
    private ListView<CMeeting> meetingsListView;
    private ListView<CSurvey> surveysListView;

    final private int LOGGED_AS_FONT_SIZE = 10;
    final private String PREVIOUS_BUTTON = "Retour";

    public MyEventsView(Stage stage, Scene previousScene) {
        appStage = stage;
        this.previousScene = previousScene;

        initializeElements();
        initializeMainBox();
        initializeScene();

        myEventsController = new MyEventsController(this);
    }

    private void initializeElements() {

        // boxes
        primaryBoxVbox = new VBox();
        topWindowHbox = new HBox();
        allListViewHbox = new HBox();
        meetingsVbox = new VBox();
        surveysVbox = new VBox();

        // top box
        logoImageView = new ImageView(AppConstants.POOPLE_LOGO);

        logText = new Text();
        logText.setFont(new Font(LOGGED_AS_FONT_SIZE));

        previewButton = new Button(PREVIOUS_BUTTON);

        // lists box

        myMeetingsTitleText = new Text("Mes réunions");
        mySurveysTitleText = new Text("Mes sondages");
        meetingsListView = new ListView<CMeeting>();
        surveysListView = new ListView<CSurvey>();
        deleteButton = new Button("Supprimer");
    }

    private void initializeMainBox() {

        // top box

        topWindowHbox.setAlignment(Pos.TOP_CENTER);
        topWindowHbox.setSpacing(AppConstants.GENERAL_SPACING);
        topWindowHbox.getChildren().addAll(logoImageView, logText, previewButton);
        topWindowHbox.setPadding(new Insets(0, 0, 10, 0));

        // all listView box
        meetingsVbox.getChildren().addAll(myMeetingsTitleText, meetingsListView);
        surveysVbox.getChildren().addAll(mySurveysTitleText, surveysListView);

        allListViewHbox.setAlignment(Pos.TOP_CENTER);
        allListViewHbox.setSpacing(AppConstants.GENERAL_SPACING);
        allListViewHbox.getChildren().addAll(meetingsVbox, surveysVbox, deleteButton);

        primaryBoxVbox.getChildren().addAll(topWindowHbox, allListViewHbox);
    }

    private void initializeScene() {

        currentScene = new Scene(primaryBoxVbox, AppConstants.WINDOW_WIDTH, AppConstants.WINDOW_HEIGHT);
    }

    public Scene getScene() { return currentScene; }

    public Button getPreviewButton() { return previewButton; }

    public Button getDeleteButton() { return deleteButton; }

    public ListView<CMeeting> getMeetingsListView() { return meetingsListView; }

    public ListView<CSurvey> getSurveysListView() { return surveysListView; }
}
