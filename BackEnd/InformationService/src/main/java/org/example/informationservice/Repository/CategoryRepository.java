package org.example.informationservice.Repository;

import org.example.informationservice.Model.Entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    //Tìm dựa trên CATEGORY_ID
    Optional<Category> findByCategoryId(Long categoryId);

    boolean existsByCategoryId(Long categoryId);

    // Custom query method for searching categories by multiple criteria
    @Query("SELECT c FROM Category c WHERE " +
            "(:categoryId IS NULL OR c.categoryId = :categoryId) AND " +
            "(:categoryCode IS NULL OR LOWER(c.categoryCode) LIKE LOWER(CONCAT('%', :categoryCode, '%'))) AND " +
            "(:categoryName IS NULL OR LOWER(c.categoryName) LIKE LOWER(CONCAT('%', :categoryName, '%'))) AND " +
            "(:status IS NULL OR c.status = :status) AND " +
            "(:createdTimeFrom IS NULL OR c.createdTime >= :createdTimeFrom) AND " +
            "(:createdTimeTo IS NULL OR c.createdTime <= :createdTimeTo) AND " +
            "(:updatedTimeFrom IS NULL OR c.updatedTime >= :updatedTimeFrom) AND " +
            "(:updatedTimeTo IS NULL OR c.updatedTime <= :updatedTimeTo) AND " +
            "(:createdUser IS NULL OR c.createdUser = :createdUser) AND " +
            "(:updatedUser IS NULL OR c.updatedUser = :updatedUser)")
    Page<Category> search(
            @Param("categoryId") Long categoryId,
            @Param("categoryCode") String categoryCode,
            @Param("categoryName") String categoryName,
            @Param("status") Long status,
            @Param("createdTimeFrom") LocalDateTime createdTimeFrom,
            @Param("createdTimeTo") LocalDateTime createdTimeTo,
            @Param("updatedTimeFrom") LocalDateTime updatedTimeFrom,
            @Param("updatedTimeTo") LocalDateTime updatedTimeTo,
            @Param("createdUser") Long createdUser,
            @Param("updatedUser") Long updatedUser,
            Pageable pageable);

}
