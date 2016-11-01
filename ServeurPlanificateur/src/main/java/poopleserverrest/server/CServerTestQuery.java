package poopleserverrest.server;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.impl.CopyOnWriteHashMap;
import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Events.COption;
import fr.univtln.projuml.clt.Events.CSurvey;
import fr.univtln.projuml.clt.Places.CBuilding;
import fr.univtln.projuml.clt.Places.CRoom;
import fr.univtln.projuml.clt.Users.CGroup;
import fr.univtln.projuml.clt.Users.CUser;

import javax.ws.rs.core.MediaType;
import java.sql.Date;
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


        // pour gérer les meetings, le faire via un post d'un user


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



        webResource.path("users").type(MediaType.APPLICATION_JSON).post(u1);
//        webResource.path("users").type(MediaType.APPLICATION_JSON).post(u2);

//        webResource.path("groups").type(MediaType.APPLICATION_JSON).post(g1);

        CBuilding b = new CBuilding().setName("lolBuild").setAdress("2 rues apres XD");
        CRoom r1 = new CRoom().setNumber(20).setCapacity(25).setBuilding(b);
        CRoom r2 = new CRoom().setNumber(22).setCapacity(30).setBuilding(b);

//        webResource.path("rooms").type(MediaType.APPLICATION_JSON).post(r1);
//        webResource.path("rooms").type(MediaType.APPLICATION_JSON).post(r2);

        CMeeting m1 = new CMeeting();
        m1.setId(1);
        m1.setTitle("Mercredi a la fac pour le projet :D ?");
        m1.addRoom(r1);
        m1.addRoom(r2);
        m1.setCreator(u1);

        u1.addMeeting(m1);
        u2.addMeeting(m1);

        // ne pas faire ca , ca ne fonctionne pas
//        m1.addParticipant(u1);
//        m1.addParticipant(u2);

        COption o1 = new COption("Avec sucre ?").setId(1);
        COption o2 = new COption("Plutot sans sucre ?").setId(2);

        CSurvey s = new CSurvey();
        s.setId(2);
        s.setTitle("Comment préférez vous le café ?");
        s.setCreator(u2);
        s.addOption(o1);
        s.addOption(o2);

        u1.addOption(o1);
        u2.addOption(o2);

//        webResource.path("groups").type(MediaType.APPLICATION_JSON).post(g1);

        webResource.path("events").type(MediaType.APPLICATION_JSON).post(m1);
//
//        webResource.path("users").type(MediaType.APPLICATION_JSON).post(u1);
        webResource.path("surveys").type(MediaType.APPLICATION_JSON).post(s);
//        webResource.path("users").type(MediaType.APPLICATION_JSON).post(u2);
    }
}
