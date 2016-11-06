package fr.univtln.projuml.clt.Controllers;

import fr.univtln.projuml.clt.Models.ConnectionModel;
import fr.univtln.projuml.clt.Views.ConnectionView;

/**
 * Created by tomy- on 26/10/2016.
 */
public class ConnectionController {
    private ConnectionView connectionView;
    private ConnectionModel connectionModel;

    public void createAccount(String mail, String pw, String pwValidation){
        if (!pw.equals(pwValidation))
            connectionView.setErreurCreationCompteText("les deux mdp ne sont pas identiques");

        else if (!mail.contains("@"))
            connectionView.setErreurCreationCompteText("adresse mail invalide");

        else {
            if (connectionModel.createAccount(mail, pw))
                connectionView.getStage().close();
            else{
                connectionView.setErreurCreationCompteText("adresse mail déjà utilisée");
            }
        }
    }

    public void userConnection(String mail, String pw){

        if(connectionModel.userConnection(mail, pw)){
            connectionView.getCompteInexistantText().setVisible(false);
            connectionView.getStage().close();
        }
        else {
            connectionView.getCompteInexistantText().setVisible(true);
        }
    }

    public ConnectionController(ConnectionView connectionView, ConnectionModel connectionModel) {
        this.connectionModel = connectionModel;
        this.connectionView = connectionView;
    }
}
