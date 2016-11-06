package fr.univtln.projuml.clt.Models;

import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Users.CUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static fr.univtln.projuml.clt.AppConstants.webResource;


/**
 * Created by tomy- on 26/10/2016.
 */
public class ConnectionModel extends Observable {
    private static ConnectionModel connectionModel = new ConnectionModel();
    private  ConnectionModel(){    }
    public static ConnectionModel getInstance(){return connectionModel;}

    private CUser currentUser;

    private List<AEvent> events = new ArrayList<AEvent>();

    public List<AEvent> getEvents() {
        return events;
    }

    private int hash(String s){
        return s.hashCode();
    }

    public boolean createAccount(String mail, String pw){
        CUser newUser = new CUser(mail, hash(pw));
        webResource.path("users").type(MediaType.APPLICATION_JSON).post(newUser);
        currentUser = newUser;
        setChanged();
        notifyObservers();
        return true;
    }

    public boolean userConnection(String mail, String pw){
        ObjectMapper om = new ObjectMapper();
        try {
            String u = webResource.path("users/mail/"+mail).type(MediaType.APPLICATION_JSON).get(String.class);
            currentUser = om.readValue(u, CUser.class);
            setChanged();
            notifyObservers();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public CUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CUser currentUser) {
        this.currentUser = currentUser;
        setChanged();
        notifyObservers();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }
}
