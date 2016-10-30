package poopleserverrest.services;

import fr.univtln.projuml.clt.Users.CUser;
import poopleserverrest.dao.CCrudServiceBean;
import poopleserverrest.dao.ICrudService;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;

import static poopleserverrest.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 30/10/16.
 */

@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public class CUserServices {

    public static ICrudService<CUser> sCrudUser = new CCrudServiceBean<CUser>();


    //////// crud operations


    // retourne tout les utilisateurs
    @GET
    @Produces("application/json")
    public static List<CUser> userAll() {
        return (List<CUser>) sCrudUser.findWithNamedQuery(CUser.FIND_USER_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putUser(CUser user){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudUser.update(user);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postUser(CUser user) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudUser.create(user);
        transac.commit();
    }
}
