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

@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public class CUserServices {

    public static ICrudService<CUser> sCrudUser = new CCrudServiceBean<CUser>();


    //////// crud operations


    // retourne les utilisateurs par id de groupe
    @GET
    @Produces("application/json")
    @Path("/group/id/{id}")
    public static List<CUser> userByGroup(@PathParam("id") final int pId) {
        return (List<CUser>) sCrudUser.findWithNamedQuery(
                CUser.FIND_USERS_BY_GROUP, QueryParameter.with("Pid", pId).parameters());
    }

    // retourne tout les utilisateurs
    @GET
    @Produces("application/json")
    public static List<CUser> userAll() {
        return (List<CUser>) sCrudUser.findWithNamedQuery(CUser.FIND_USER_ALL);
    }

    // retourne l'utilisateur par son id
    @GET
    @Produces("application/json")
    @Path("/id/{id}")
    public static CUser userById(@PathParam("id") final int pId) {
        return (CUser) sCrudUser.findWithNamedQuery(
                CUser.FIND_USER_BY_ID, QueryParameter.with("Pid", pId).parameters()).get(0);
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
