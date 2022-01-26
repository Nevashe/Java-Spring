package servlet;

public class Producttt {
    private int id;
    private  String title;
    private int cost;

    public Producttt(int id, String title, int cost) {
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

    public static Producttt[] getProduct(){
        Producttt[] products = new Producttt[10];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Producttt(i+1, "Product # " + (i+1), (i+1)*1000);
        }
        return products;
    }
}
