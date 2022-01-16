package hm8.repositories;

import hm8.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query(value ="select * from products limit ?1,?2", nativeQuery = true)
    List<Product> myQuery(int shift, int scrap);

    Optional<Product> findByTitle(String s);
}
