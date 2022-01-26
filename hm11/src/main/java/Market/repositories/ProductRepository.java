package Market.repositories;

import Market.entites.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query(value ="select * from products limit ?1,?2", nativeQuery = true)
    List<Product> myQuery(int shift, int scrap);

    Optional<Product> findByTitle(String s);

    Product findOneByTitle(String title);
}
