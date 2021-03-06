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
        if(productId > -1) {
            return productId;
        }
        return Long.getLong("0");
    }

    public String getName() {
        if(!name.equals("")){
            return name;
        }
        return "No name";
    }

    public Double getPrice() {
        if(price > 0){
            return price;
        }
        return 999.99;
    }

    public Integer getStock() {
        return stock;
    }
}
