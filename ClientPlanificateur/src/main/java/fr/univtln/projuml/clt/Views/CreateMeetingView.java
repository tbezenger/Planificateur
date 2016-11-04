package fr.univtln.projuml.clt.Views;

import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Controllers.CreateMeetingController;
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


/**
 * Created by imnotfood on 03/11/16.
 */
public class CreateMeetingView {

    CreateMeetingController controller;

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
    private Button clear;
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
    private final String DATE = "Date (jj/mm/aaaa):";
    private final String TIME = "Heure (hh:mm):";
    private final String MAKE_PRIVATE = "définir comme privé";

    private final double FIELDS_BOX_SPACING = 15;
    private final double FULL_BOX_SPACING = 30;
    private final double DATE_TIME_SPACING = 60;

    /*
     * Methods
     */

    public CreateMeetingView(Stage stage, Scene previousScene) {
        appStage = stage;
        this.previousScene = previousScene;
        controller = new CreateMeetingController(this);

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
        mainPane.setSpacing(AppConstants.GENERAL_SPACING);

        HBox meetingTitleBox = new HBox();
        meetingTitleBox.setAlignment(Pos.CENTER);
        meetingTitleBox.getChildren().addAll(meetingTitle, meetingTitleField);


        //Pick a location
        HBox addressBox = new HBox();
        addressBox.setAlignment(Pos.CENTER_RIGHT);
        addressBox.getChildren().addAll(address, addressField);

        HBox buildingBox = new HBox();
        buildingBox.setAlignment(Pos.CENTER_RIGHT);
        buildingBox.getChildren().addAll(building, buildingField);

        HBox roomNumberBox = new HBox();
        roomNumberBox.setAlignment(Pos.CENTER_RIGHT);
        roomNumberBox.getChildren().addAll(roomNumber, roomNumberField);

        VBox pickALocationFieldsBox = new VBox();
        pickALocationFieldsBox.setAlignment(Pos.TOP_RIGHT);
        pickALocationFieldsBox.setSpacing(FIELDS_BOX_SPACING);
        pickALocationFieldsBox.getChildren().addAll(addressBox, buildingBox, roomNumberBox);

        VBox pickALocationFullBox = new VBox();
        pickALocationFullBox.setAlignment(Pos.TOP_CENTER);
        pickALocationFullBox.setSpacing(FULL_BOX_SPACING);
        pickALocationFullBox.getChildren().addAll(pickALocation, pickALocationFieldsBox);


        //Pick a date
        HBox dateBox = new HBox();
        dateBox.setAlignment(Pos.CENTER_RIGHT);
        dateBox.getChildren().addAll(date, dateField);

        HBox timeBox = new HBox();
        timeBox.setAlignment(Pos.CENTER_RIGHT);
        timeBox.getChildren().addAll(time, timeField);

        VBox pickADateFieldsBox = new VBox();
        pickADateFieldsBox.setAlignment(Pos.TOP_RIGHT);
        pickADateFieldsBox.setSpacing(FIELDS_BOX_SPACING);
        pickADateFieldsBox.getChildren().addAll(dateBox, timeBox, makePrivate);

        VBox pickADateFullBox = new VBox();
        pickADateFullBox.setAlignment(Pos.TOP_CENTER);
        pickADateFullBox.setSpacing(FULL_BOX_SPACING);
        pickADateFullBox.getChildren().addAll(pickADate, pickADateFieldsBox);

        HBox dateTimeBox = new HBox();
        dateTimeBox.setAlignment(Pos.TOP_CENTER);
        dateTimeBox.setSpacing(DATE_TIME_SPACING);
        dateTimeBox.getChildren().addAll(pickALocationFullBox, pickADateFullBox);

        HBox okCancel = new HBox();
        okCancel.setAlignment(Pos.CENTER);
        okCancel.getChildren().addAll(validate, clear, goBack);

        mainPane.getChildren().addAll(logo, title, meetingTitleBox, dateTimeBox, okCancel);
    }


    private void initializeElements() {
        logo = new ImageView(AppConstants.POOPLE_LOGO);
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
        clear = new Button(AppConstants.CLEAR_VALUES);
        goBack = new Button(AppConstants.GO_BACK);
    }


    private void setListeners() {
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                meetingTitleField.clear();
                addressField.clear();
                buildingField.clear();
                roomNumberField.clear();
                dateField.clear();
                timeField.clear();
                makePrivate.setSelected(false);
            }
        });

        validate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String lTitle, lAddress, lBuilding, lRoomNumber, lDate, lTime;

                boolean lPrivateMeeting = makePrivate.isSelected();
                lTitle = meetingTitleField.getText();
                lAddress = addressField.getText();
                lBuilding = buildingField.getText();
                lRoomNumber = roomNumberField.getText();
                lDate = dateField.getText();
                lTime = timeField.getText();

                controller.createMeeting(lTitle, lAddress, lBuilding, lRoomNumber, lDate, lTime, lPrivateMeeting);
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
