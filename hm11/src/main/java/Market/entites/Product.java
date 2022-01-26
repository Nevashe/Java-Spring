package Market.entites;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category id_category;

    @Column(name = "price")
    private int price;

    @Column(name = "path_img")
    private String pathImg;

    public Product() {
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", id_category=" +
                "{"+
                "id " + id_category.getId() +
                "category " + id_category.getCategory() +
                "}" +
                ", price=" + price +
                '}';
    }

}