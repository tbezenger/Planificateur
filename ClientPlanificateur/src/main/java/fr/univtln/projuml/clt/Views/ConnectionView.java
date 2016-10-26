package fr.univtln.projuml.clt.Views;
/**
 * Created by tomy- on 26/10/2016.
 */

import com.sun.corba.se.pept.transport.ConnectionCache;
import fr.univtln.projuml.clt.Controllers.ConnectionController;
import fr.univtln.projuml.clt.Models.ConnectionModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ConnectionView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static Scene createScene(ConnectionModel connectionModel){

        final ConnectionController connectionController = new ConnectionController(connectionModel);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 700, 275);


        Text leftTitle = new Text("Connexion");
        leftTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        HBox leftTitleBox = new HBox();
        leftTitleBox.setAlignment(Pos.CENTER);
        leftTitleBox.getChildren().add(leftTitle);
        grid.add(leftTitleBox, 0, 0, 2, 1);

        Label logEMail = new Label("Adresse mail :");
        grid.add(logEMail, 0, 1);
        TextField logEMailTextField = new TextField();
        grid.add(logEMailTextField, 1, 1);

        Label logPw = new Label("Mot de passe :");
        grid.add(logPw, 0, 2);
        PasswordField logPwBox = new PasswordField();
        grid.add(logPwBox, 1, 2);

        Button logBtn = new Button("Se connecter");
        HBox logHbBtn = new HBox(10);
        logHbBtn.setAlignment(Pos.CENTER);
        logHbBtn.getChildren().add(logBtn);
        grid.add(logHbBtn, 0, 3, 2, 1);

        logBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                connectionController.userConnection();
            }
        });


        Text rightTitle = new Text("Nouvel Utilisateur?");
        rightTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        HBox rightTitleBox = new HBox();
        rightTitleBox.setAlignment(Pos.CENTER);
        rightTitleBox.getChildren().add(rightTitle);
        grid.add(rightTitleBox, 4, 0, 2, 1);

        Label newEMail = new Label("Adresse mail :");
        grid.add(newEMail, 4, 1);
        TextField newEMailField = new TextField();
        grid.add(newEMailField, 5, 1);

        Label newPw = new Label("Mot de passe :");
        grid.add(newPw, 4, 2);
        PasswordField newPwField = new PasswordField();
        grid.add(newPwField, 5, 2);

        Label newPwValidation = new Label("Confirmation");
        grid.add(newPwValidation, 4, 3);
        PasswordField newPwFieldValidation = new PasswordField();
        grid.add(newPwFieldValidation, 5, 3);

        Button createAccountBtn = new Button("Creer compte");
        HBox createAccountHbBtn = new HBox(10);
        createAccountHbBtn.setAlignment(Pos.CENTER);
        createAccountHbBtn.getChildren().add(createAccountBtn);
        grid.add(createAccountHbBtn, 4, 4, 2, 1);

        createAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                connectionController.createAccount();
            }
        });


        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        grid.add(separator, 3, 0, 1, 5);

        return scene;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(createScene(ConnectionModel.getInstance()));
        primaryStage.show();
    }
}
