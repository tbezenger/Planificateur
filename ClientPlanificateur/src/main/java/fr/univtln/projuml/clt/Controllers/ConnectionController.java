package fr.univtln.projuml.clt.Controllers;

import fr.univtln.projuml.clt.Models.ConnectionModel;
import fr.univtln.projuml.clt.Views.ConnectionView;

/**
 * Created by tomy- on 26/10/2016.
 */
public class ConnectionController {
    private ConnectionView connectionView;
    private ConnectionModel connectionModel;

    public boolean createAccount(String mail, String pw, String pwValidation){
        if (pw.equals(pwValidation))

            return false;

        if (!mail.contains("@"))
            // throw exception
            return false;
        connectionModel.createAccount(mail,pw);

        return true;
    }

    public boolean userConnection(String mail, String pw){
        return connectionModel.userConnection(mail, pw);
    }

    public ConnectionController(ConnectionModel connectionModel){
        this.connectionModel = connectionModel;
    }

    public ConnectionController(ConnectionView connectionView, ConnectionModel connectionModel) {
        this(connectionModel);
        this.connectionView = connectionView;
    }
}
