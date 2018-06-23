package repositories;

import models.Authentication;
import models.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AuthenticationRepository {
    private final EntityManager em = HibernateUtility.getEntityManager();

    public Authentication login(String username, String password) {
        try {
            Query q = em.createNamedQuery("Authentication.login", Authentication.class);
            q.setParameter("username", username);
            q.setParameter("password", password);
            Authentication auth = (Authentication) q.getSingleResult();
            return auth;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            //em.close();
        }
        return null;
    }
}
