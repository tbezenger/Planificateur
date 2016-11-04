package fr.univtln.projuml.clt.Controllers;

import com.sun.jersey.api.client.GenericType;
import fr.univtln.projuml.clt.AppConstants;
import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Models.MainMenuModel;
import fr.univtln.projuml.clt.Views.MainMenuView;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ltonnet637 on 02/11/16.
 */
public class MainMenuController {

    private MainMenuView view;
    private MainMenuModel model = MainMenuModel.getInstance();

    public MainMenuController(MainMenuView pView) {
        this.view = pView;
        getAllEvents();
    }

    public void getAllEvents() {
        model.getAllEvents();
    }

}
