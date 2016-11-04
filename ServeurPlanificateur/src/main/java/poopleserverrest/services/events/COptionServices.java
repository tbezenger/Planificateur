package poopleserverrest.services.events;

import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.COption;
import poopleserverrest.dao.CCrudServiceBean;
import poopleserverrest.dao.ICrudService;
import poopleserverrest.dao.QueryParameter;

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


    // retourne les options par id de sondage
    @GET
    @Produces("application/json")
    @Path("/survey/id/{id}")
    public static List<COption> getOptionsBySUrvey(@PathParam("id") final int pId) {
        return (List<COption>) sCrudOptions.findWithNamedQuery(COption.FIND_OPTIONS_BY_SURVEY,
                QueryParameter.with("Pid", pId).parameters());
    }

    // retourne les options par id
    @GET
    @Produces("application/json")
    @Path("/id/{id}")
    public static COption optionById(@PathParam("id") final int pId) {
        return (COption) sCrudOptions.findWithNamedQuery(
                COption.FIND_OPTION_BY_ID, QueryParameter.with("Pid", pId).parameters()).get(0);
    }

    // retourne tout les option
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
