package poopleserverrest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by clemzux on 03/08/2016.
 */

public class CEntityManager {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private EntityManager em = emf.createEntityManager();

    private static CEntityManager INSTANCE = null;

    public static CEntityManager getINSTANCE(){
        if(INSTANCE == null)
            INSTANCE = new CEntityManager();
        return INSTANCE;
    }

    private CEntityManager() {}

    public EntityManager getEm() {
        return em;
    }
}
