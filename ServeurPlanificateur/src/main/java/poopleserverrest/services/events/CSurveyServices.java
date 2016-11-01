package poopleserverrest.services.events;

import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.CSurvey;
import poopleserverrest.dao.CCrudServiceBean;
import poopleserverrest.dao.ICrudService;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;

import static poopleserverrest.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 01/11/16.
 */

@Path("/surveys")
@Produces("application/json")
@Consumes("application/json")
public class CSurveyServices {

    public static ICrudService<CSurvey> sCrudOptions = new CCrudServiceBean<CSurvey>();


    //////// crud operations


    // retourne tout les utilisateurs
    @GET
    @Produces("application/json")
    public static List<CSurvey> surveyAll() {
        return (List<CSurvey>) sCrudOptions.findWithNamedQuery(CSurvey.SURVEY_BY_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putSurvey(CSurvey pSurvey){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudOptions.update(pSurvey);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postSurvey(CSurvey pSurvey) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudOptions.create(pSurvey);
        transac.commit();
    }
}
