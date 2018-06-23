package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtility {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        if (em != null && em.isOpen()) {
            return em;
        }
        emf = Persistence.createEntityManagerFactory("ConsolePU");
        em = emf.createEntityManager();
        getEntityManager();
        return em;
    }
}
