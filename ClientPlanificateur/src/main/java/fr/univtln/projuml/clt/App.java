package fr.univtln.projuml.clt;

import com.sun.javafx.tk.*;
import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Events.CSurvey;
import fr.univtln.projuml.clt.Models.MainMenuModel;
import fr.univtln.projuml.clt.Views.ConnectionView;
import fr.univtln.projuml.clt.Views.MainMenuView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Hello world!
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