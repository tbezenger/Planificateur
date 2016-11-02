package poopleserverrest.services.events;

import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.COption;
import poopleserverrest.dao.CCrudServiceBean;
import poopleserverrest.dao.ICrudService;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;

import static poopleserverrest.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 01/11/16.
 */

@Path("/options")
@Produces("application/json")
@Consumes("application/json")
public class COptionServices {

    public static ICrudService<COption> sCrudOptions = new CCrudServiceBean<COption>();


    //////// crud operations


    // retourne tout les utilisateurs
    @GET
    @Produces("application/json")
    public static List<COption> optionAll() {
        return (List<COption>) sCrudOptions.findWithNamedQuery(COption.OPTION_BY_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putOption(COption pOption){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudOptions.update(pOption);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postOption(COption pOption) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudOptions.create(pOption);
        transac.commit();
    }
}
