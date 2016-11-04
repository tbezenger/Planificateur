package poopleserverrest.services.events;

import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.COption;
import fr.univtln.projuml.clt.Events.CSurvey;
import poopleserverrest.dao.CCrudServiceBean;
import poopleserverrest.dao.ICrudService;
import poopleserverrest.dao.QueryParameter;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

import static poopleserverrest.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 01/11/16.
 */

@Path("/surveys")
@Produces("application/json")
@Consumes("application/json")
public class CSurveyServices {

    public static ICrudService<CSurvey> sCrudSurvey = new CCrudServiceBean<CSurvey>();


    //////// crud operations


    // retourne les sondages par id
    @GET
    @Produces("application/json")
    @Path("/id/{id}")
    public static CSurvey surveyById(@PathParam("id") final int pId) {
        return (CSurvey) sCrudSurvey.findWithNamedQuery(
                CSurvey.FIND_SURVEY_BY_ID, QueryParameter.with("Pid", pId).parameters()).get(0);
    }

    // retourne tout les utilisateurs
    @GET
    @Produces("application/json")
    public static List<CSurvey> surveyAll() {
        return (List<CSurvey>) sCrudSurvey.findWithNamedQuery(CSurvey.SURVEY_BY_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putSurvey(CSurvey pSurvey){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudSurvey.update(pSurvey);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postSurvey(CSurvey pSurvey) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudSurvey.create(pSurvey);
        transac.commit();
    }
}
