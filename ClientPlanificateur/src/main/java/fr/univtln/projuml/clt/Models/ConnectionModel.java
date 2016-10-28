package fr.univtln.projuml.clt.Models;

import fr.univtln.projuml.clt.Users.CUser;

import java.util.Observable;
import java.util.Observer;


/**
 * Created by tomy- on 26/10/2016.
 */
public class ConnectionModel extends Observable implements Observer {
    private static ConnectionModel connectionModel = new ConnectionModel();
    private  ConnectionModel(){}
    public static ConnectionModel getInstance(){return connectionModel;}

    private CUser currentUser;

    public void update(Observable o, Object arg) {
        // TODO
    }

    private int hash(String s){
        // c'est bidon mais juste pour l'exemple
        return s.hashCode();
    }

    public boolean createAccount(String mail, String pw){
        int hashedPw = hash(pw);
        CUser newUser = new CUser(mail, hashedPw);
        // TODO : envoyer au serveur pour persistance
        currentUser = newUser;
        return true;
    }

    public boolean userConnection(String mail, String pw){
        // TODO : verifier dans la bdd que l'utilisateur est correct et le definir comme "currentUser" (/!\ au hash)
        return true;
    }

    public CUser getCurrentUser() {
        return currentUser;
    }
}
