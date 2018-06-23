package models;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "Product.getProductById",
                query = "select p from Product p where p.productId = :productId "),
        @NamedQuery(
                name = "Product.getProducts",
                query = "select p from Product p"),
        @NamedQuery(
                name = "Product.updateProductById",
                query = "update Product p set p = :product where p.productId = :productId")
})
@Entity
public class Product {

    @Id @GeneratedValue
    private long productId;
    private String name;
    private double price;
    private int stock;

    public Product() {
    } // JPA

    public Product(String name) {
        this.name = name;
        price = 1.0;
        stock = 0;
    }

    public Product(long id, String name, double price, int stock) {
        productId = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }

    public void addStock(int value) {
        stock += value;
    }

    public void removeStock(int value) {
        stock -= value;
    }

    public long getId() {
        if (productId > -1) {
            return productId;
        }
        return Long.getLong("0");
    }

    public String getName() {
        if (!name.equals("")) {
            return name;
        }
        return "No name";
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        if (price >= 0) {
            return price;
        }
        return 999.99;
    }

    public int getStock() {
        return stock;
    }
}
