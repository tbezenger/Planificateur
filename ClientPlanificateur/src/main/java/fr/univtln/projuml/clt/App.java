package fr.univtln.projuml.clt;

import fr.univtln.projuml.clt.Models.MainMenuModel;
import fr.univtln.projuml.clt.Views.MainMenuView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This is the main-class for executable
 *
 */

public class App extends Application {

    public static void main( String[] args ) {
        Application.launch();

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenuView welcomeScreen = new MainMenuView();
        MainMenuModel.getInstance().addObserver(welcomeScreen);
    }
}