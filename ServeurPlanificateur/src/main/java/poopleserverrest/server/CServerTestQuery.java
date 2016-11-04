package poopleserverrest.server;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import fr.univtln.projuml.clt.Events.CMeeting;
import fr.univtln.projuml.clt.Events.COption;
import fr.univtln.projuml.clt.Events.CSurvey;
import fr.univtln.projuml.clt.Places.CBuilding;
import fr.univtln.projuml.clt.Places.CRoom;
import fr.univtln.projuml.clt.Users.CGroup;
import fr.univtln.projuml.clt.Users.CUser;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
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
        WebResource webResource = c.resource("http://localhost:9999/");
//        WebResource webResource = c.resource("http://176.157.85.69:9999/");

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

        CUser u3 = new CUser();
        u3.setId(3);
        u3.setFirstName("tomy");
        u3.setLastName("bezenger");
        u3.setMail("xplosm@ptdr.mdr");
        u3.setPassword(654321);
        u3.addGroup(g1);

        // on définit l'utilisateur 1 comme proprio du groupe
        g1.setOwner(u1);
        // on ajoute l'utilisateur 1 et 2 au groupe
        g1.addUser(u1);
        g1.addUser(u2);

        CGroup g2 = new CGroup();
        g2.setId(2);
        g2.setName("lolololololol");
        g2.addUser(u2);
        g2.addUser(u3);

        webResource.path("groups").type(MediaType.APPLICATION_JSON).post(g1);
        webResource.path("groups").type(MediaType.APPLICATION_JSON).post(g2);

        CBuilding b1 = new CBuilding().setName("lolBuild").setAdress("2 rues apres XD").setId(1);
        CBuilding b2 = new CBuilding().setName("bat u").setAdress("je sais pas").setId(2);

        webResource.path("buildings").type(MediaType.APPLICATION_JSON).post(b1);
        webResource.path("buildings").type(MediaType.APPLICATION_JSON).post(b2);

        CRoom r1 = new CRoom().setNumber(20).setCapacity(25).setBuilding(b1).setId(1);
        CRoom r2 = new CRoom().setNumber(22).setCapacity(30).setBuilding(b1).setId(2);
        CRoom r3 = new CRoom().setNumber(20).setCapacity(25).setBuilding(b2).setId(3);

        webResource.path("rooms").type(MediaType.APPLICATION_JSON).post(r1);
        webResource.path("rooms").type(MediaType.APPLICATION_JSON).post(r2);
        webResource.path("rooms").type(MediaType.APPLICATION_JSON).post(r3);

        CMeeting m1 = new CMeeting();
        m1.setId(1);
        m1.setTitle("Mercredi a la fac pour le projet :D ?");
        m1.addRoom(r1);
        m1.addRoom(r2);
        m1.setCreator(u1);
//        m1.addUser(u1);
//        m1.addUser(u2);

        CMeeting m2 = new CMeeting();
        m2.setId(2);
        m2.setTitle("Jeudi a la fac pour le projet :D ?");

        u1.addMeeting(m1);
        u2.addMeeting(m1);

        COption o1 = new COption("Avec sucre ?").setId(1);
        COption o2 = new COption("Plutot sans sucre ?").setId(2);

        CSurvey s = new CSurvey();
        s.setId(3);
        s.setTitle("Comment préférez vous le café ?");
        s.setCreator(u2);

        o1.setSurvey(s);
        o2.setSurvey(s);

        u1.addOption(o1);
        u2.addOption(o2);

        webResource.path("meetings").type(MediaType.APPLICATION_JSON).post(m1);
        webResource.path("meetings").type(MediaType.APPLICATION_JSON).post(m2);

        webResource.path("surveys").type(MediaType.APPLICATION_JSON).post(s);

        webResource.path("options").type(MediaType.APPLICATION_JSON).post(o1);
        webResource.path("options").type(MediaType.APPLICATION_JSON).post(o2);

//        webResource.path("users").type(MediaType.APPLICATION_JSON).post(u1);
//        webResource.path("users").type(MediaType.APPLICATION_JSON).post(u2);

//        ObjectMapper om = new ObjectMapper();
//
//        String u = webResource.path("users/id/1").type(MediaType.APPLICATION_JSON).get(String.class);
//
//        CUser us;
//        try {
//            us = om.readValue(u, CUser.class);
//            System.out.println(u.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        List<CUser> users =
//                webResource.path("users").type(MediaType.APPLICATION_JSON).get(new GenericType<List<CUser>>(){});
//        for (CUser cu : users)
//            System.out.println(cu.toString());
    }
}
