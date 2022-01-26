package Market.repositories;


import org.springframework.stereotype.Repository;
import Market.entites.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByCategory(String category);
}

