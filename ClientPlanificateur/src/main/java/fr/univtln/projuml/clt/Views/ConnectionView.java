package fr.univtln.projuml.clt.Views;
/**
 * Created by tomy- on 26/10/2016.
 */

import fr.univtln.projuml.clt.Controllers.ConnectionController;
import fr.univtln.projuml.clt.Models.ConnectionModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ConnectionView {

    private Stage stage;
    final GridPane grid = new GridPane();
    final Scene scene = new Scene(grid, 700, 275);
    private Text erreurCreationCompteText = new Text();
    private Text compteInexistantText = new Text("compte inexistant");



    private void createScene(ConnectionController pConnectionController){
        this.stage = new Stage();
        final ConnectionController connectionController = pConnectionController;
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        this.stage.setScene(scene);

        Text leftTitle = new Text("Compte existant");
        leftTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        HBox leftTitleBox = new HBox();
        leftTitleBox.setAlignment(Pos.CENTER);
        leftTitleBox.getChildren().add(leftTitle);
        grid.add(leftTitleBox, 0, 0, 2, 1);

        Label logEMail = new Label("Adresse mail :");
        grid.add(logEMail, 0, 1);
        final TextField logEMailTextField = new TextField();
        grid.add(logEMailTextField, 1, 1);

        Label logPw = new Label("Mot de passe :");
        grid.add(logPw, 0, 2);
        final PasswordField logPwField = new PasswordField();
        grid.add(logPwField, 1, 2);

        Button logBtn = new Button("Se connecter");
        HBox logHbBtn = new HBox(10);
        logHbBtn.setAlignment(Pos.CENTER);
        logHbBtn.getChildren().add(logBtn);
        grid.add(logHbBtn, 0, 3, 2, 1);

        logBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                connectionController.userConnection(logEMailTextField.getText(), logPwField.getText());

            }
        });

        compteInexistantText.setFill(Color.RED);
        compteInexistantText.setVisible(false);
        grid.add(compteInexistantText,0,4,2,1);


        Text rightTitle = new Text("Nouvel Utilisateur?");
        rightTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        HBox rightTitleBox = new HBox();
        rightTitleBox.setAlignment(Pos.CENTER);
        rightTitleBox.getChildren().add(rightTitle);
        grid.add(rightTitleBox, 4, 0, 2, 1);

        final Label newEMail = new Label("Adresse mail :");
        grid.add(newEMail, 4, 1);
        final TextField newEMailField = new TextField();
        grid.add(newEMailField, 5, 1);

        Label newPw = new Label("Mot de passe :");
        grid.add(newPw, 4, 2);
        final PasswordField newPwField = new PasswordField();
        grid.add(newPwField, 5, 2);

        Label newPwValidation = new Label("Confirmation :");
        grid.add(newPwValidation, 4, 3);
        final PasswordField newPwFieldValidation = new PasswordField();
        grid.add(newPwFieldValidation, 5, 3);

        Button createAccountBtn = new Button("Creer compte");
        HBox createAccountHbBtn = new HBox(10);
        createAccountHbBtn.setAlignment(Pos.CENTER);
        createAccountHbBtn.getChildren().add(createAccountBtn);
        grid.add(createAccountHbBtn, 4, 4, 2, 1);

        createAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                connectionController.createAccount(newEMailField.getText(), newPwField.getText(), newPwFieldValidation.getText());
            }
        });


        erreurCreationCompteText.setFill(Color.RED);
        grid.add(erreurCreationCompteText, 4, 5, 2, 1);


        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        grid.add(separator, 3, 0, 1, 5);

        stage.show();

    }

    public ConnectionView(){
        ConnectionController connectionController = new ConnectionController(this,ConnectionModel.getInstance());
        createScene(connectionController);
    }

    public void setVisible(){
        stage.show();
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() { return scene; }

    public void setErreurCreationCompteText(String s){
        erreurCreationCompteText.setText(s);
    }

    public Text getCompteInexistantText() {
        return compteInexistantText;
    }
}
