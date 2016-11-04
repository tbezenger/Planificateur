package fr.univtln.projuml.clt.Models;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import fr.univtln.projuml.clt.Users.CUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by tomy- on 26/10/2016.
 */
public class ConnectionModel extends Observable implements Observer {
    private static ConnectionModel connectionModel = new ConnectionModel();
    private  ConnectionModel(){
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
        webResource = c.resource("http://176.157.85.69:9999/");;
    }
    public static ConnectionModel getInstance(){return connectionModel;}

    private ClientConfig cc = new DefaultClientConfig();
    WebResource webResource;
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
        // TODO :  factoriser la webressource

        CUser newUser = new CUser(mail, hashedPw);
        webResource.path("users").type(MediaType.APPLICATION_JSON).post(newUser);
        currentUser = newUser;
        return true;
    }

    public boolean userConnection(String mail, String pw){
        // TODO : verifier dans la bdd que l'utilisateur est correct et le definir comme "currentUser" (/!\ au hash)
        ObjectMapper om = new ObjectMapper();

        String u = webResource.path("users/mail/"+mail).type(MediaType.APPLICATION_JSON).get(String.class);
        try {
            currentUser = om.readValue(u, CUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public CUser getCurrentUser() {
        return currentUser;
    }
}
