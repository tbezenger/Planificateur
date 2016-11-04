package poopleserverrest.services.users;

import fr.univtln.projuml.clt.Users.CGroup;
import fr.univtln.projuml.clt.Users.CUser;
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

@Path("/groups")
@Produces("application/json")
@Consumes("application/json")
public class CGroupServices {

    public static ICrudService<CGroup> sCrudGroup = new CCrudServiceBean<CGroup>();


    //////// crud operations


    // retourne les groupes par id
    @GET
    @Produces("application/json")
    @Path("/id/{id}")
    public static CGroup groupById(@PathParam("id") final int pId) {
        return (CGroup) sCrudGroup.findWithNamedQuery(
                CGroup.FIND_GROUP_BY_ID, QueryParameter.with("Pid", pId).parameters()).get(0);
    }

    // retourne tout les groupes
    @GET
    @Produces("application/json")
    public static List<CGroup> groupAll() {
        return (List<CGroup>) sCrudGroup.findWithNamedQuery(CGroup.FIND_GROUP_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putGroup(CGroup pGroup){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudGroup.update(pGroup);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postGroup(CGroup pGroup) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudGroup.create(pGroup);
        transac.commit();
    }
}
