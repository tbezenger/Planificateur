package poopleserverrest.services.places;

import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Places.CRoom;
import fr.univtln.projuml.clt.Users.CGroup;
import poopleserverrest.dao.CCrudServiceBean;
import poopleserverrest.dao.ICrudService;
import poopleserverrest.dao.QueryParameter;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;

import static poopleserverrest.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 30/10/16.
 */

@Path("/rooms")
@Produces("application/json")
@Consumes("application/json")
public class CRoomServices {

    public static ICrudService<CRoom> sCrudRoom = new CCrudServiceBean<CRoom>();


    //////// crud operations


    // retourne les rooms par id de batiment
    @GET
    @Produces("application/json")
    @Path("/building/id/{id}")
    public static List<CRoom> roomsByBuilding(@PathParam("id") final int pId) {
        return (List<CRoom>) sCrudRoom.findWithNamedQuery(
                CRoom.FIND_ROOMS_BY_BUILDING, QueryParameter.with("Pid", pId).parameters());
    }

    // retourne les pieces par id
    @GET
    @Produces("application/json")
    @Path("/id/{id}")
    public static CRoom roomById(@PathParam("id") final int pId) {
        return (CRoom) sCrudRoom.findWithNamedQuery(
                CRoom.FIND_ROOM_BY_ID, QueryParameter.with("Pid", pId).parameters()).get(0);
    }

    // retourne toutes les rooms
    @GET
    @Produces("application/json")
    public static List<CRoom> roomAll() {
        return (List<CRoom>) sCrudRoom.findWithNamedQuery(CRoom.FIND_ROOM_BY_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putRoom(CRoom pRoom){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudRoom.update(pRoom);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postRoom(CRoom pRoom) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudRoom.create(pRoom);
        transac.commit();
    }
}
