package fr.univtln.projuml.clt.Controllers;

import fr.univtln.projuml.clt.CProperties;
import fr.univtln.projuml.clt.Models.MyAccountModel;
import fr.univtln.projuml.clt.Users.CGroup;
import fr.univtln.projuml.clt.Users.CUser;
import fr.univtln.projuml.clt.Views.MyAccountView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

import static java.util.Objects.hash;

/**
 * Created by clemzux on 13/11/16.
 */
public class MyAccountController {

    private MyAccountView myAccountView;
    private MyAccountModel myAccountModel = MyAccountModel.getInstance();
    private List<CGroup> groups;


    public MyAccountController(MyAccountView pView) {

        myAccountView = pView;

        initializeFields();
        initializeListeners();
        initializeGroupsComboBox();
    }

    private void initializeFields() {

        myAccountView.getNameTextField().setText(CProperties.userConnected.getFirstName());
        myAccountView.getLastNameTextField().setText(CProperties.userConnected.getLastName());
        myAccountView.getMailTextField().setText(CProperties.userConnected.getMail());
    }

    private void initializeGroupsComboBox() {

        groups = myAccountModel.getGroups();

        List<String> stringGroups = new ArrayList<String>();
        stringGroups.add("");

        for (CGroup group : groups)
            stringGroups.add(group.getName());

        myAccountView.getGroupsComboBox().setItems(FXCollections.<String>observableArrayList(stringGroups));
    }

    private void initializeListeners() {

        myAccountView.getModifyUserButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                CProperties.userConnected.setFirstName(myAccountView.getNameTextField().getText());
                CProperties.userConnected.setLastName(myAccountView.getLastNameTextField().getText());
                CProperties.userConnected.setMail(myAccountView.getMailTextField().getText());

                if (!myAccountView.getPasswordTextField().getText().equals(""))
                CProperties.userConnected.setPassword(hash(myAccountView.getPasswordTextField().getText()));

                String group = myAccountView.getGroupsComboBox().getSelectionModel().getSelectedItem();

                if (!group.equals("")) {

                    for (CGroup g : groups) {

                        if (g.getName().equals(group))
                            CProperties.userConnected.addGroup(g);
                    }
                }

                myAccountModel.modifiyUser();
                myAccountView.goToPreviousScene();
            }
        });

        myAccountView.getPreviewButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                myAccountView.goToPreviousScene();
            }
        });

        myAccountView.getCreateGroupButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                myAccountModel.addGroup(myAccountView.getNewGroupNameTextField().getText());
            }
        });
    }
}
