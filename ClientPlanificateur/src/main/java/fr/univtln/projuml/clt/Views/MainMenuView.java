package fr.univtln.projuml.clt.Views;

import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Controllers.MainMenuController;
import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.CSurvey;
import fr.univtln.projuml.clt.Models.AnswerSurveyModel;
import fr.univtln.projuml.clt.Models.MainMenuModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by imnotfood on 01/11/16.
 */
public class MainMenuView implements Observer {

    MainMenuController controller;

    private ObservableList<AEvent> eventList = FXCollections.observableArrayList();

    private CreateSurveyView createSurveyView;
    private CreateMeetingView createMeetingView;
    private AnswerSurveyView answerSurveyView;


    /*
     * UI Stuff
     */

    private ImageView logo;

    private Button startSurvey, startMeeting;

    private Button logIn, myEvents, myAccount;
    private Text loggedAs;

    private TextField eventSearch;
    private ComboBox eventFilter;
    private ListView events;


    private Stage primaryStage;
    private Scene primaryScene;
    private GridPane mainPane;

    private Button actualize;


    /*
     * AppConstants
     */

    final private String STAGE_TITLE = "Poople";

    final private double GRID_H_GAP = 5d;
    final private double GRID_V_GAP = 5d;
    final private int GRID_ROWS = 9;
    final private int GRID_COLUMNS = 5;

    final private String START_SURVEY = "Créer Sondage";
    final private String START_MEETING = "Créer Réunion";
    final private String SEARCH = "Rechercher";
    final private String FILTER = "Filtrer";
    final private String MY_EVENTS = "Mes Evénements";
    final private String MY_ACCOUNT = "Mon Compte";
    final private String LOGGED_AS = "connecté en tant que mail@mail.com";
    final private String ACTUALIZE = "Actualiser";

    final private int LOGGED_AS_FONT_SIZE = 10;
    final private int EVENT_BUTTONS_FONT_SIZE = 25;

    final private String NO_FILTERS = "Filtres";
    final private String SURVEYS_FILTER = "Sondages";
    final private String MEETINGS_FILTER = "Réunions";

    final private double START_EVENT_WIDTH = AppConstants.WINDOW_WIDTH /3;
    final private double START_EVENT_HEIGHT = AppConstants.WINDOW_HEIGHT /5;
    final private double START_EVENT_BUTTON_SPACING = 60;

    final private double EVENT_BOX_SPACING = 20;
    final private double MY_ACCOUNT_BUTTON_SPACING = 10;


    /*
     * Methods
     */


    public MainMenuView() {

        initializeElements();
        initializeGridPane();
        setListeners();

        controller = new MainMenuController(this);

        //On place les éléments
        mainPane.add(eventSearch, 0, 1);

        VBox eventBox = new VBox();
        eventBox.getChildren().addAll(eventFilter, events);
        eventBox.setSpacing(EVENT_BOX_SPACING);
        mainPane.add(eventBox, 0, 3, 2, 5);

        HBox logoBox = new HBox();
        logoBox.setAlignment(Pos.CENTER);
        logoBox.getChildren().add(logo);
        mainPane.add(logoBox, 1, 1, 3, 2);

        VBox startEventBox = new VBox();
        startEventBox.setAlignment(Pos.CENTER_RIGHT);
        startEventBox.getChildren().addAll(startSurvey, startMeeting);
        startEventBox.setPadding(new Insets(50, 0, 0, 50));
        startEventBox.setSpacing(START_EVENT_BUTTON_SPACING);
        mainPane.add(startEventBox, 3, 5, 2, 1);


        HBox loggedBox = new HBox();
        loggedBox.setAlignment(Pos.CENTER_RIGHT);
        loggedBox.getChildren().add(loggedAs);
        mainPane.add(loggedBox, 3, 0, 2, 1);
        mainPane.add(logIn, 4, 1);

        HBox myAccountBox = new HBox();
        myAccountBox.getChildren().addAll(myEvents, myAccount);
        myAccountBox.setAlignment(Pos.CENTER_RIGHT);
        myAccountBox.setSpacing(MY_ACCOUNT_BUTTON_SPACING);
        mainPane.add(myAccountBox, 4, 8);


        mainPane.add(actualize, 4, 7);
        //Scene settings
        primaryScene = new Scene(mainPane);

        //Stage settings
        primaryStage = new Stage();
        primaryStage.setTitle(STAGE_TITLE);
        primaryStage.setResizable(false);
        primaryStage.setMaxWidth(AppConstants.WINDOW_WIDTH);
        primaryStage.setMaxHeight(AppConstants.WINDOW_HEIGHT);

        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }


    public void initializeGridPane() {
        //Grid settings
        mainPane = new GridPane();
        mainPane.setHgap(GRID_H_GAP);
        mainPane.setVgap(GRID_V_GAP);
        mainPane.setPadding(new Insets(5, 5, 5, 5));

        for(int i = 0; i < GRID_COLUMNS; i++)
            mainPane.getColumnConstraints().add(new ColumnConstraints());

        mainPane.setAlignment(Pos.CENTER);

        ColumnConstraints constraint = new ColumnConstraints();
        constraint.setHalignment(HPos.RIGHT);
        mainPane.getColumnConstraints().set(4, constraint);
    }


    public void initializeElements() {

        startSurvey = new Button(START_SURVEY);
        startSurvey.setPrefSize(START_EVENT_WIDTH, START_EVENT_HEIGHT);
        startSurvey.setFont(new Font(EVENT_BUTTONS_FONT_SIZE));
        startMeeting = new Button(START_MEETING);
        startMeeting.setPrefSize(START_EVENT_WIDTH, START_EVENT_HEIGHT);
        startMeeting.setFont(new Font(EVENT_BUTTONS_FONT_SIZE));

        loggedAs = new Text(LOGGED_AS);
        loggedAs.setFont(new Font(LOGGED_AS_FONT_SIZE));
        logIn = new Button(AppConstants.LOG_IN);
        myEvents = new Button(MY_EVENTS);
        myAccount = new Button(MY_ACCOUNT);

        Image image = new Image(AppConstants.POOPLE_LOGO);
        logo = new ImageView(image);

        eventSearch = new TextField(SEARCH);

        eventFilter = new ComboBox();
        eventFilter.getItems().addAll(NO_FILTERS, SURVEYS_FILTER, MEETINGS_FILTER);
        eventFilter.getSelectionModel().selectFirst();

        events = new ListView();

        actualize = new Button(ACTUALIZE);
    }


    private void setListeners() {
        logIn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new ConnectionView();
            }
        });

        startSurvey.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (createSurveyView == null)
                    createSurveyView = new CreateSurveyView(primaryStage, primaryScene);
                primaryStage.setScene(createSurveyView.getScene());
            }
        });

        startMeeting.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (createMeetingView == null)
                    createMeetingView = new CreateMeetingView(primaryStage, primaryScene);
                primaryStage.setScene(createMeetingView.getScene());
            }
        });

        actualize.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.getAllEvents();
            }
        });

        eventFilter.valueProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != oldValue) {
                    if (((String) newValue).equals(NO_FILTERS))
                        eventList.setAll(MainMenuModel.getInstance().getEvents());
                    else if (((String) newValue).equals(SURVEYS_FILTER))
                        eventList.setAll(MainMenuModel.getInstance().getSurveys());
                    else
                        eventList.setAll(MainMenuModel.getInstance().getMeetings());
                    events.setItems(eventList);
                }
            }
        });

        events.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (events.getSelectionModel().getSelectedItem() instanceof CSurvey) {
                    controller.openSurvey(answerSurveyView, primaryStage, primaryScene, (CSurvey) events.getSelectionModel().getSelectedItem());
                }
            }
        });
    }


    public void update(Observable o, Object arg) {
        if (o instanceof MainMenuModel) {
            String filterValue = (String) eventFilter.getValue();

            if (filterValue.equals(NO_FILTERS))
                eventList.setAll(((MainMenuModel) o).getEvents());
            else if (filterValue.equals(SURVEYS_FILTER))
                eventList.setAll(((MainMenuModel) o).getSurveys());
            else
                eventList.setAll(((MainMenuModel) o).getMeetings());
            events.setItems(eventList);
        }
    }



    public AnswerSurveyView getAnswerSurveyView() {
        return answerSurveyView;
    }


    public void setAnswerSurveyView(AnswerSurveyView newView) {
        answerSurveyView = newView;
    }


    public Scene getScene() {
        return primaryScene;
    }
}
