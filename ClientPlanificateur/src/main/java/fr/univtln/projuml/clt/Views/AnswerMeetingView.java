package fr.univtln.projuml.clt.Views;

import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Controllers.AnswerMeetingController;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Models.AnswerMeetingModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by imnotfood on 05/11/16.
 */
public class AnswerMeetingView implements Observer {


    AnswerMeetingController controller;

    /*
     * UI Stuff
     */


    private Stage appStage;
    private Scene previousScene;
    private Scene currentScene;
    private VBox mainPane;

    private ImageView logo;
    private Text meetingTitle;
    private Text address;
    private Text building;
    private Text roomNumber;
    private Text date;
    private Text time;
    private Text numberOfParticipants;
    private ComboBox<String> participants;
    private Button participate;
    private Button goBack;



    /*
     * Constants
     */

    private final String ADDRESS = "Adresse:";
    private final String BUILDING = "Bâtiment:";
    private final String ROOM_NUMBER = "Salle:";
    private final String NUMBER_OF_PARTICIPANTS = "Nombre de participants:";
    private final String NAME = "Nom:";
    private final String PARTICIPATE = "Participer";

    private final double MEETING_INFO_SPACING = 50;



    /*
     * Methods
     */


    public AnswerMeetingView(Stage stage, Scene previousScene) {

        this.appStage = stage;
        this.previousScene = previousScene;

        controller = new AnswerMeetingController(this);

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

        VBox locationBox = new VBox();
        locationBox.setAlignment(Pos.CENTER);
        locationBox.setSpacing(AppConstants.SMALL_SPACING);
        locationBox.getChildren().addAll(address, building, roomNumber);

        VBox timeBox = new VBox();
        timeBox.setAlignment(Pos.CENTER);
        timeBox.setSpacing(AppConstants.SMALL_SPACING);
        timeBox.getChildren().addAll(date, time);

        VBox participantsBox = new VBox();
        participantsBox.setAlignment(Pos.CENTER);
        timeBox.setSpacing(AppConstants.SMALL_SPACING);
        participantsBox.getChildren().addAll(numberOfParticipants, participants);

        HBox meetingInfoBox = new HBox();
        meetingInfoBox.setAlignment(Pos.CENTER);
        meetingInfoBox.setSpacing(MEETING_INFO_SPACING);
        meetingInfoBox.getChildren().addAll(locationBox, timeBox, participantsBox);

        HBox nameBox = new HBox();
        nameBox.setAlignment(Pos.CENTER);
        nameBox.setSpacing(AppConstants.SMALL_SPACING);

        HBox buttonsBox = new HBox();
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setSpacing(AppConstants.SMALL_SPACING);
        buttonsBox.getChildren().addAll(participate, goBack);

        mainPane.getChildren().addAll(logo, meetingTitle, meetingInfoBox, nameBox, buttonsBox);
    }


    private void initializeElements() {
        logo = new ImageView(AppConstants.POOPLE_LOGO);

        meetingTitle = new Text();
        meetingTitle.setFont(new Font(AppConstants.TITLES_FONT));

        address = new Text(ADDRESS);
        building = new Text(BUILDING);
        roomNumber = new Text(ROOM_NUMBER);

        date = new Text();
        time = new Text();

        numberOfParticipants = new Text(NUMBER_OF_PARTICIPANTS);
        participants = new ComboBox<String>();

        participate = new Button(PARTICIPATE);
        goBack = new Button(AppConstants.GO_BACK);
    }


    private void setListeners() {
        participate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.participate();
            }
        });


        goBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                appStage.setScene(previousScene);
            }
        });
    }


    public void setScene(Scene scene) {
        this.currentScene = scene;
    }


    public Scene getScene() {
        return currentScene;
    }

    public void update(Observable o, Object arg) {
        if (o instanceof AnswerMeetingModel) {
            CMeeting currentMeeting = AnswerMeetingModel.getInstance().getMeeting();

            if (AnswerMeetingModel.getInstance().getMeeting() != null) {
                meetingTitle.setText(currentMeeting.getTitle());
                date.setText("Le " + currentMeeting.getDate());
                time.setText("à " + currentMeeting.getHour());
            }
        }
    }
}
