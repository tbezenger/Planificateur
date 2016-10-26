package fr.univtln.projuml.clt.Controllers;

import fr.univtln.projuml.clt.Models.ConnectionModel;
import fr.univtln.projuml.clt.Views.ConnectionView;

/**
 * Created by tomy- on 26/10/2016.
 */
public class ConnectionController {
    private ConnectionView connectionView;
    private ConnectionModel connectionModel;

    public boolean createAccount(){
        return true;
    }

    public boolean userConnection(){
        return true;
    }

    public ConnectionController(ConnectionModel connectionModel){
        this.connectionModel = connectionModel;
    }
}
