package poopleserverrest.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import fr.univtln.projuml.clt.Users.CUser;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by clemzux on 04/11/16.
 */
public class COtherTest {

    public static void main(String[] args) {

        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
//        WebResource webResource = c.resource("http://localhost:9999/");
        WebResource webResource = c.resource("http://176.157.85.69:9999/");


        ObjectMapper om = new ObjectMapper();

        String u = webResource.path("users/mail/tomy@bezenger.fr").type(MediaType.APPLICATION_JSON).get(String.class);

        CUser us;
        try {
            us = om.readValue(u, CUser.class);
            System.out.println(u.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
