package fr.univtln.projuml.clt.Views;

import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Controllers.MyAccountController;
import javafx.geometry.Insets;
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

/**
 * Created by clemzux on 13/11/16.
 */
public class MyAccountView {

    private MyAccountController myAccountController;
    private MainMenuView mainMenuView;

    private Stage appStage;
    private Scene previousScene;
    private Scene currentScene;

    private VBox primaryBoxVbox, textVbox, fieldVbox, newGroupVbox;
    private HBox topWindowHbox, formGroupHbox;

    private ImageView logoImageView;
    private Text logText, nameText, lastNameText, mailText, passwordText, groupText, infoAccountText, newGroupText;
    private TextField nameTextField, lastNameTextField, mailTextField, passwordTextField, newGroupNameTextField;
    private Button previewButton, createGroupButton, modifyUserButton;
    private ComboBox<String> groupsComboBox;


    final private int LOGGED_AS_FONT_SIZE = 10;
    final private String PREVIOUS_BUTTON = "Retour";
    final private String ACCOUNT_INFO = "Informations du profil :";
    final private String NAME = "Nom : ";
    final private String LAST_NAME = "Prénom : ";
    final private String MAIL = "Email : ";
    final private String PASSWORD = "Mot de passe : ";
    final private String GROUP = "Nouveau groupe : ";
    final private String NEW_GROUP = "Créer groupe";
    final private String MODIFY_USER_BUTTON = "Modifier";


    public MyAccountView(Stage stage, Scene previousScene) {
        appStage = stage;
        this.previousScene = previousScene;

        initializeElements();
        initializeMainBox();
        initializeScene();

        myAccountController = new MyAccountController(this);
    }

    private void initializeMainBox() {

        // top box

        topWindowHbox.setAlignment(Pos.TOP_CENTER);
        topWindowHbox.setSpacing(AppConstants.GENERAL_SPACING);
        topWindowHbox.getChildren().addAll(logoImageView, logText, previewButton);
        topWindowHbox.setPadding(new Insets(0, 0, 10, 0));

        // form group box
        formGroupHbox.setAlignment(Pos.TOP_CENTER);
        formGroupHbox.setSpacing(AppConstants.GENERAL_SPACING);
        formGroupHbox.setPadding(new Insets(10, 0, 0, 0));

        // text box
        textVbox.getChildren().addAll(nameText, lastNameText, mailText, passwordText, groupText);
        textVbox.setSpacing(22);

        // textField box
        fieldVbox.getChildren().addAll(nameTextField, lastNameTextField, mailTextField, passwordTextField, groupsComboBox);
        fieldVbox.setSpacing(10);

        // new group box
        newGroupVbox.getChildren().addAll(newGroupText, newGroupNameTextField, createGroupButton);
        newGroupVbox.setPadding(new Insets(0,0,0,60));
        newGroupVbox.setSpacing(10);

        // window organization
        formGroupHbox.getChildren().addAll(textVbox, fieldVbox, newGroupVbox);

        primaryBoxVbox.setAlignment(Pos.TOP_CENTER);
        primaryBoxVbox.setSpacing(AppConstants.GENERAL_SPACING);
        primaryBoxVbox.getChildren().addAll(topWindowHbox, infoAccountText, formGroupHbox, modifyUserButton);
    }

    private void initializeElements() {

        // boxes initialization
        primaryBoxVbox = new VBox();
        formGroupHbox = new HBox();
        topWindowHbox = new HBox();
        textVbox = new VBox();
        fieldVbox = new VBox();
        newGroupVbox = new VBox();

        // top box
        logoImageView = new ImageView(AppConstants.POOPLE_LOGO);

        logText = new Text();
        logText.setFont(new Font(LOGGED_AS_FONT_SIZE));

        previewButton = new Button(PREVIOUS_BUTTON);

        // form box

        infoAccountText = new Text(ACCOUNT_INFO);

        nameText = new Text(NAME);
        lastNameText = new Text(LAST_NAME);
        mailText = new Text(MAIL);
        passwordText = new Text(PASSWORD);
        groupText = new Text(GROUP);

        nameTextField = new TextField();
        lastNameTextField = new TextField();
        mailTextField = new TextField();
        passwordTextField = new TextField();

        groupsComboBox = new ComboBox<String>();

        // new group box

        newGroupText = new Text(GROUP);
        newGroupNameTextField = new TextField();
        createGroupButton = new Button(NEW_GROUP);

        modifyUserButton = new Button(MODIFY_USER_BUTTON);
    }

    private void initializeScene() {
        currentScene = new Scene(primaryBoxVbox, AppConstants.WINDOW_WIDTH, AppConstants.WINDOW_HEIGHT);
    }

    public void goToPreviousScene() {

        if (mainMenuView == null)
            mainMenuView = new MainMenuView();
        appStage.setScene(mainMenuView.getPrimaryScene());
    }

    public Scene getScene() {
        return currentScene;
    }

    public TextField getNameTextField() { return nameTextField; }

    public TextField getLastNameTextField() { return lastNameTextField; }

    public TextField getMailTextField() { return mailTextField; }

    public TextField getPasswordTextField() { return passwordTextField; }

    public TextField getNewGroupNameTextField() { return newGroupNameTextField; }

    public Button getPreviewButton() { return previewButton; }

    public Button getCreateGroupButton() { return createGroupButton; }

    public Button getModifyUserButton() { return modifyUserButton; }

    public ComboBox<String> getGroupsComboBox() { return groupsComboBox; }
}
