package fr.univtln.projuml.clt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Created by imnotfood on 03/11/16.
 */
public abstract class AppConstants {

    public static ObjectMapper objectMapper = new ObjectMapper();
    public static WebResource webResource;

    static {
        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
        webResource = c.resource("http://176.157.85.69:9999");
    }

    public static final double WINDOW_WIDTH = 750d;
    public static final double WINDOW_HEIGHT = 550d;

    public static final double GENERAL_SPACING = 15;

    public static final int TITLES_FONT = 25;

    public static final String POOPER_LOGO = "pooper_logo.png";

    public static final String VALIDATE = "Valider";
    public static final String CLEAR_VALUES = "Réinitialiser";
    public static final String GO_BACK = "Retour";

}
