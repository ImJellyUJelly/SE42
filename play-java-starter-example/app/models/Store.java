package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Store {

    @Id @GeneratedValue
    private long storeId;
    private String name;
    @OneToMany(cascade=CascadeType.REMOVE)
    private List<Product> products;

    public String getName() {
        return name;
    }

    public long getStoreId() {
        return storeId;
    }

    public List<Product> getProducts() { return products; }

    public Store() {}

    public Store(String name) {
        storeId = 0;
        this.name = name;
        products = new ArrayList<>();
    }

    public boolean addProductToStore(String newProductName) {
        // Only if product doesn't already exists, add to store.
        for(Product product : products) {
            if(product.getName().equals(newProductName)) {
                return false;
            }
        }
        //Product newProduct = new Product(newProductName);
        //products.add(newProduct);
        return true;
    }

    public boolean removeProductFromStore(String productName) {
        for(Product product : products) {
            if(product.getName().equals(productName)) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    public boolean sellProduct(String productName) {
        // Will not be implemented
        throw new UnsupportedOperationException();
    }

    public Product getProductByName(String productName) {
        for(Product product : products) {
            if(product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
