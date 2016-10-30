package poopleserverrest.services;

import fr.univtln.projuml.clt.Places.CRoom;
import fr.univtln.projuml.clt.Users.CGroup;
import poopleserverrest.dao.CCrudServiceBean;
import poopleserverrest.dao.ICrudService;

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
