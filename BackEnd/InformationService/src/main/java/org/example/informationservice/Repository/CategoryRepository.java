package org.example.informationservice.Repository;

import org.example.informationservice.Model.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    //Tìm dựa trên CATEGORY_ID
    Optional<Category> findByCategoryId(Long categoryId);

    boolean existsByCategoryId(Long categoryId);


}
