package fr.univtln.projuml.clt.Views;

import javafx.application.Application;
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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by imnotfood on 01/11/16.
 */
public class MainMenuView extends Application {


    ImageView logo;

    Button startPoll, startMeeting;

    Button logIn, myEvents;
    Text loggedAs;

    TextField eventSearch;
    ComboBox eventFilter;
    ListView events;


    Scene primaryScene;
    GridPane mainPane;


    /*
     * Constantes
     */

    final private String STAGE_TITLE = "Poople";
    final private double STAGE_WIDTH = 750d;
    final private double STAGE_HEIGHT = 550d;

    final private double GRID_H_GAP = 5d;
    final private double GRID_V_GAP = 5d;
    final private int GRID_ROWS = 9;
    final private int GRID_COLUMNS = 5;

    final private String START_POLL = "Créer Sondage";
    final private String START_MEETING = "Créer Réunion";
    final private String SEARCH = "Rechercher";
    final private String FILTER = "Filtrer";
    final private String LOG_IN = "Se Connecter";
    final private String LOG_OUT = "Se Déconnecter";
    final private String MY_EVENTS = "Mes Evénements";
    final private String LOGGED_AS = "connecté en tant que mail@mail.com";

    final private String POOPER_LOGO = "pooper_logo.png";

    final private double START_EVENT_WIDTH = STAGE_WIDTH/3;
    final private double START_EVENT_HEIGHT = STAGE_HEIGHT/5;
    final private double START_EVENT_BUTTON_SPACING = 60;



    /*
     *
     */


    @Override
    public void start(Stage primaryStage) throws Exception {

        initializeElements();
        initializeGridPane();


        //On place les éléments
        mainPane.add(eventSearch, 0, 1);
        mainPane.add(eventFilter, 0, 3);
        mainPane.add(events, 0, 4, 2, 4);

        HBox logoBox = new HBox();
        logoBox.setAlignment(Pos.CENTER);
        logoBox.getChildren().add(logo);
        mainPane.add(logoBox, 1, 1, 3, 2);

        VBox startEventBox = new VBox();
        startEventBox.setAlignment(Pos.CENTER_RIGHT);
        startEventBox.getChildren().addAll(startPoll, startMeeting);
        startEventBox.setPadding(new Insets(50, 0, 0, 50));
        startEventBox.setSpacing(START_EVENT_BUTTON_SPACING);
        mainPane.add(startEventBox, 3, 5, 2, 1);


        HBox loggedBox = new HBox();
        loggedBox.setAlignment(Pos.CENTER_RIGHT);
        loggedBox.getChildren().add(loggedAs);
        mainPane.add(loggedBox, 3, 0, 2, 1);
        mainPane.add(logIn, 4, 1);
        mainPane.add(myEvents, 4, 8);


        //Scene settings
        primaryScene = new Scene(mainPane);

        //Stage settings
        primaryStage.setTitle(STAGE_TITLE);
        primaryStage.setResizable(false);
        primaryStage.setMaxWidth(STAGE_WIDTH);
        primaryStage.setMaxHeight(STAGE_HEIGHT);

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

        startPoll = new Button(START_POLL);
        startPoll.setPrefSize(START_EVENT_WIDTH, START_EVENT_HEIGHT);
        startMeeting = new Button(START_MEETING);
        startMeeting.setPrefSize(START_EVENT_WIDTH, START_EVENT_HEIGHT);

        loggedAs = new Text(LOGGED_AS);
        loggedAs.setFont(new Font(10));
        logIn = new Button(LOG_IN);
        myEvents = new Button(MY_EVENTS);

        Image image = new Image(POOPER_LOGO);
        logo = new ImageView(image);

        eventSearch = new TextField(SEARCH);
        eventFilter = new ComboBox(); //TODO: ObservableList
        events = new ListView(); //TODO: ObservableList
    }


    public static void main(String[] args) {
        launch(args);
    }
}
