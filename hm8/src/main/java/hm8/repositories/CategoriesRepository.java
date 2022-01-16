package hm8.repositories;

import hm8.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriesRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByCategory(String category);
}

