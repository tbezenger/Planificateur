package fr.univtln.projuml.clt.Views;

import fr.univtln.projuml.clt.AppConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by imnotfood on 03/11/16.
 */
public class CreateMeetingView {

    /*
     * UI Stuff
     */

    private Stage appStage;
    private Scene previousScene;
    private Scene currentScene;
    private VBox mainPane;

    private ImageView logo;
    private Text title;

    private Text meetingTitle;
    private TextField meetingTitleField;

    private Text pickALocation;
    private Text address;
    private TextField addressField;
    private Text building;
    private TextField buildingField;
    private Text roomNumber;
    private TextField roomNumberField;

    private Text pickADate;
    private Text date;
    private TextField dateField;
    private Text time;
    private TextField timeField;

    private CheckBox makePrivate;

    private Button validate;
    private Button goBack;

    /*
     * Constants
     */

    private final String TITLE = "Créez votre Réunion";
    private final String MEETING_TITLE = "Nom de votre réunion:";
    private final String PICK_A_LOCATION = "Choisissez un lieu:";
    private final String ADDRESS = "Adresse:";
    private final String BUILDING = "Nom du bâtiment:";
    private final String ROOM_NUMBER = "Numéro de salle:";
    private final String PICK_A_DATE = "Choisissez une date:";
    private final String DATE = "Date:";
    private final String TIME = "Heure:";
    private final String MAKE_PRIVATE = "définir comme privé";


    /*
     * Methods
     */

    public CreateMeetingView(Stage stage, Scene previousScene) {
        appStage = stage;
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
        mainPane.getChildren().addAll(logo, title, meetingTitle, meetingTitleField, pickALocation, address, addressField,
                building, buildingField, roomNumber, roomNumberField, pickADate, date, dateField, time, timeField,
                makePrivate, validate, goBack);
    }


    private void initializeElements() {
        logo = new ImageView(AppConstants.POOPER_LOGO);
        title = new Text(TITLE);
        title.setFont(new Font(AppConstants.TITLES_FONT));

        meetingTitle = new Text(MEETING_TITLE);
        meetingTitleField = new TextField();

        pickALocation = new Text(PICK_A_LOCATION);
        address = new Text(ADDRESS);
        addressField = new TextField();
        building = new Text(BUILDING);
        buildingField = new TextField();
        roomNumber = new Text(ROOM_NUMBER);
        roomNumberField = new TextField();

        pickADate = new Text(PICK_A_DATE);
        date = new Text(DATE);
        dateField = new TextField();
        time = new Text(TIME);
        timeField = new TextField();

        makePrivate = new CheckBox(MAKE_PRIVATE);

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


    public Scene getScene() {
        return currentScene;
    }
}
