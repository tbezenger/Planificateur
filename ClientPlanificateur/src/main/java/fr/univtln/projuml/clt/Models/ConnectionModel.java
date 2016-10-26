package fr.univtln.projuml.clt.Models;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by tomy- on 26/10/2016.
 */
public class ConnectionModel extends Observable implements Observer {
    private static ConnectionModel connectionModel = new ConnectionModel();
    private  ConnectionModel(){}

    public static ConnectionModel getInstance(){return connectionModel;}

    public void update(Observable o, Object arg) {
        // TODO
    }


}
