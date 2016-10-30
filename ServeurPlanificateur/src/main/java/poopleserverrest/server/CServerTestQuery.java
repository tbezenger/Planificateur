package poopleserverrest.server;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import fr.univtln.projuml.clt.Users.CGroup;
import fr.univtln.projuml.clt.Users.CUser;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by clemzux on 03/08/16.
 */
public class CServerTestQuery {

    public static void main(String[] args) {

        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
        WebResource webResource = c.resource("http://localhost:10000/");
//        WebResource webResource = c.resource("http://176.157.85.69:10000/");

        CGroup g1 = new CGroup();
        g1.setId(1);
        g1.setName("Hourra");

        CUser u1 = new CUser();
        u1.setId(1);
        u1.setFirstName("clement");
        u1.setLastName("farge");
        u1.setMail("lol@ptdr.mdr");
        u1.setPassword(123456);
        u1.addGroup(g1);

        CUser u2 = new CUser();
        u2.setId(2);
        u2.setFirstName("tomy");
        u2.setLastName("bezenger");
        u2.setMail("xplosm@ptdr.mdr");
        u2.setPassword(654321);
        u2.addGroup(g1);

        // on définit l'utilisateur 1 comme proprio du groupe
        g1.setOwner(u1);
        // on ajoute l'utilisateur 1 et 2 au groupe
        g1.addUser(u1);
        g1.addUser(u2);

        webResource.path("groups").type(MediaType.APPLICATION_JSON).post(g1);

//        webResource.path("users").type(MediaType.APPLICATION_JSON).post(u1);
//        webResource.path("users").type(MediaType.APPLICATION_JSON).post(u2);
    }
}
