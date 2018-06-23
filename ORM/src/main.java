import javax.persistence.*;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SE42");
        EntityManager em = emf.createEntityManager();

        Product cola = new Product();
        Product beer = new Product();

        em.getTransaction().begin();
        try {
            cola.addStock(48);
            beer.addStock(72);
            em.getTransaction().commit();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(em != null) { em.close(); }
        }
    }
}