import javax.persistence.*;

@Entity
public class Product {

    @Id @GeneratedValue // ORM
    private long productId;
    private String name;
    private double price;
    private int stock;

    public Product() { } // JPA

    public Product(String name) {
        this.name = name;
        price = 1.0;
        stock = 0;
    }

    public void addStock(int value) {
        stock += value;
    }

    public void removeStock(int value) {
        stock -= value;
    }

    public long getId() {
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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        if(price >= 0){
            return price;
        }
        return 999.99;
    }

    public int getStock() {
        return stock;
    }
}
