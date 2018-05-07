import javax.persistence.*;

@Entity
public class Product {

    @Id @GeneratedValue // ORM
    private Long productId;
    private String name;
    private Double price;
    private Integer stock;

    Product() {} // JPA

    public void addStock(int value) {
        stock += value;
    }

    public void removeStock(int value) {
        stock -= value;
    }

    public Long getId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }
}
