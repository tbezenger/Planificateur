package poopleserverrest.services.places;

import fr.univtln.projuml.clt.Places.CBuilding;
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

@Path("/buildings")
@Produces("application/json")
@Consumes("application/json")
public class CBuildingServices {

    public static ICrudService<CBuilding> sCrudBuilding = new CCrudServiceBean<CBuilding>();


    //////// crud operations


    // retourne tout les groupes
    @GET
    @Produces("application/json")
    public static List<CBuilding> buildingAll() {
        return (List<CBuilding>) sCrudBuilding.findWithNamedQuery(CBuilding.FIND_BIULDING_BY_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putBuilding(CBuilding pBuilding){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudBuilding.update(pBuilding);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postBuilding(CBuilding pBuilding) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudBuilding.create(pBuilding);
        transac.commit();
    }
}
