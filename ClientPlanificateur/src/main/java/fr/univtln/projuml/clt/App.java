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

public class App extends Application
{
    public static void main( String[] args ) {
        Application.launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenuView abcd = new MainMenuView();
        primaryStage = abcd.getStage();
        primaryStage.show();

        sleep(5000);
        MainMenuModel abc = MainMenuModel.getInstance();
        AEvent lol = new CSurvey(1, "Bonjour les zaz", false, null, 2, null);
        AEvent mdr = new CMeeting(2, "Au revoir les zaz", false, null, 5, null, null, null);
        java.util.List<AEvent> events = new ArrayList<AEvent>();
        events.add(lol);
        events.add(mdr);

        abc.setEvents(events);
    }
}