package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(ShopCart.class)
                .buildSessionFactory();

        Session session = null;

//
//        session = factory.getCurrentSession();
//        ShopCart shopCart = new ShopCart();
//        session.beginTransaction();
//        Product product = session.get(Product.class, (long) 2);
//        shopCart.setId_product(product);
//
//        User user = session.get(User.class, (long) 1);
//        shopCart.setId_user(user);
//        shopCart.setNumber(1);
//        shopCart.setSum(shopCart.getNumber()*product.getPrice());
//
//        session.save(shopCart);
//        session.getTransaction().commit();



            session = factory.getCurrentSession();
            session.beginTransaction();
            User user = (User) session.createQuery("from User where name = 'Slava'").getSingleResult();
            List<ShopCart> shopCarts = session.createQuery("from ShopCart where id_user=" + user.getId()).getResultList();
            session.getTransaction().commit();
            System.out.println(shopCarts.toString());


    }
}
