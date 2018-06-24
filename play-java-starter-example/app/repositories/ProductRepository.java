package repositories;

import models.HibernateUtility;
import models.Product;
import scala.concurrent.java8.FuturesConvertersImpl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductRepository {
    private final EntityManager em = HibernateUtility.getEntityManager();

    public void insertProduct(Product product) {
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                //em.close();
            }
        }
    }

    public Product getProductById(String id) {
        try {
            Query q = em.createNamedQuery("Product.getProductById", Product.class);
            q.setParameter("productId", Long.parseLong(id));
            Product p = (Product) q.getSingleResult();
            return p;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            //em.close();
        }
        return null;
    }

    public List<Product> getAllProducts() {
        try {
            Query q = em.createNamedQuery("Product.getProducts", Product.class);
            List<Product> products = q.getResultList();
            return products;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (em != null) {
                //em.close();
            }
        }
        return null;
    }

    public void updateProduct(Product product) {
        try {
            em.getTransaction().begin();
            product.addStock(24);
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                //em.close();
            }
        }
    }

    public void deleteProduct(String id) {
        try {
            Product p = em.find(Product.class, Long.parseLong(id));
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                //em.close();
            }
        }
    }
}
