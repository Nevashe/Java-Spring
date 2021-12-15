package servlet;

import org.springframework.beans.factory.annotation.Autowired;

public class Product {
    private int id;
    private  String title;
    private int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public static Product[] getProduct(){
        Product[] products = new Product[10];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(i+1, "Product # " + (i+1), (i+1)*1000);
        }
        return products;
    }
}
