package poopleserverrest.services.events;

import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.CMeeting;
import poopleserverrest.dao.CCrudServiceBean;
import poopleserverrest.dao.ICrudService;
import poopleserverrest.dao.QueryParameter;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;

import static poopleserverrest.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 31/10/16.
 */

@Path("/meetings")
@Produces("application/json")
@Consumes("application/json")
public class CMeetingServices {

    public static ICrudService<CMeeting> sCrudMeetings = new CCrudServiceBean<CMeeting>();


    //////// crud operations


    // retourne les meetings par id d'utilisateur
    @GET
    @Produces("application/json")
    @Path("/user/id/{id}")
    public static List<CMeeting> meetingsByUser(@PathParam("id") final int pId) {
        return (List<CMeeting>) sCrudMeetings.findWithNamedQuery(
                CMeeting.FIND_MEETINGS_BY_USER, QueryParameter.with("Pid", pId).parameters());
    }

    // retourne les meetings par id
    @GET
    @Produces("application/json")
    @Path("/id/{id}")
    public static CMeeting eventById(@PathParam("id") final int pId) {
        return (CMeeting) sCrudMeetings.findWithNamedQuery(
                CMeeting.FIND_MEETING_BY_ID, QueryParameter.with("Pid", pId).parameters()).get(0);
    }

    // retourne tout les utilisateurs
    @GET
    @Produces("application/json")
    public static List<CMeeting> eventAll() {
        return (List<CMeeting>) sCrudMeetings.findWithNamedQuery(CMeeting.MEETING_BY_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putEvent(CMeeting pMeeting){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudMeetings.update(pMeeting);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postEvent(CMeeting pMeeting) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudMeetings.create(pMeeting);
        transac.commit();
    }
}
