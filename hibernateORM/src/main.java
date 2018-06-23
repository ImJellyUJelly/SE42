import javax.persistence.*;

/*<discription>
This is a supply management system. Products can be added to the 'store' and a quantity can be added to those products.
</discription>*/

public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolePU");
        EntityManager em = emf.createEntityManager();

        Store store = new Store("Voorbeeldwinkel");
        String cola = "Cola";
        String beer = "Beer";

        em.getTransaction().begin();
        try {
            em.persist(store);

            store.addProductToStore(cola);
            store.addProductToStore(beer);

            store.getProductByName(cola).addStock(72);
            store.getProductByName(beer).addStock(96);

            em.getTransaction().commit();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        } finally {
            if(em != null) { em.close(); }
        }
    }
}