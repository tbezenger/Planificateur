package poopleserverrest.services.events;

import fr.univtln.projuml.clt.Events.AEvent;
import poopleserverrest.dao.CCrudServiceBean;
import poopleserverrest.dao.ICrudService;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;

import static poopleserverrest.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 31/10/16.
 */

@Path("/events")
@Produces("application/json")
@Consumes("application/json")
public class CEventServices {

    public static ICrudService<AEvent> sCrudEvents = new CCrudServiceBean<AEvent>();


    //////// crud operations


    // retourne tout les utilisateurs
    @GET
    @Produces("application/json")
    public static List<AEvent> eventAll() {
        return (List<AEvent>) sCrudEvents.findWithNamedQuery(AEvent.AEVENT_BY_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putEvent(AEvent pEvent){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudEvents.update(pEvent);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postEvent(AEvent pEvent) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudEvents.create(pEvent);
        transac.commit();
    }
}
