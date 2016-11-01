package fr.univtln.projuml.clt;

import com.sun.javafx.tk.*;
import fr.univtln.projuml.clt.Views.ConnectionView;
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
        GridPane grid = new GridPane();
        Button buttonTest = new Button();
        Scene scene = new Scene(grid);
        grid.add(buttonTest,0,0);
        primaryStage.setScene(scene);
        primaryStage.setTitle("test");
        buttonTest.setText("clic");
        buttonTest.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Platform.runLater(new Runnable() {
                    public void run() {
                        ConnectionView connectionView = new ConnectionView();
                        connectionView.setVisible();
                    }
                });
            }
        });
        primaryStage.show();
    }
}