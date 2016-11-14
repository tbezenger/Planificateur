package fr.univtln.projuml.clt.Models;

import com.sun.jersey.api.client.GenericType;
import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.CProperties;
import fr.univtln.projuml.clt.Events.CSurvey;
import fr.univtln.projuml.clt.Users.CGroup;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by clemzux on 14/11/16.
 */
public class MyAccountModel {
    private static MyAccountModel ourInstance = new MyAccountModel();

    public static MyAccountModel getInstance() {
        return ourInstance;
    }

    private MyAccountModel() {
    }

    public void addGroup(String pName) {

        CGroup group = new CGroup();
        group.setName(pName);

        AppConstants.webResource.path("groups").type(MediaType.APPLICATION_JSON).post(group);
    }

    public void modifiyUser() {

        AppConstants.webResource.path("users").type(MediaType.APPLICATION_JSON).post(CProperties.userConnected);
    }

    public List<CGroup> getGroups() {

        List<CGroup> groups = AppConstants.webResource.path("groups").type(MediaType.APPLICATION_JSON).get(new GenericType<List<CGroup>>(){});

        return groups;
    }
}
