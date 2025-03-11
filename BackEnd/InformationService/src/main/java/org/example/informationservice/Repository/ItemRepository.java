package org.example.informationservice.Repository;

import org.example.informationservice.Model.Entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

    Optional<Item> findById(Long itemId);

    boolean existsById(Long itemId);

    @Query("SELECT i FROM Item i WHERE " +
            "(:itemId IS NULL OR i.itemId = :itemId) AND " +
            "(:itemName IS NULL OR LOWER(i.itemName) LIKE LOWER(CONCAT('%', :itemName, '%'))) AND " +
            "(:itemCode IS NULL OR LOWER(i.itemCode) LIKE LOWER(CONCAT('%', :itemCode, '%'))) AND " +
            "(:itemValue IS NULL OR LOWER(i.itemValue) LIKE LOWER(CONCAT('%', :itemValue, '%'))) AND " +
            "(:parentItemId IS NULL OR i.parentItemId = :parentItemId) AND " +
            "(:categoryId IS NULL OR i.category.categoryId = :categoryId) AND " +
            "(:status IS NULL OR i.status = :status) AND " +
            "(:createdTimeFrom IS NULL OR i.createdTime >= :createdTimeFrom) AND " +
            "(:createdTimeTo IS NULL OR i.createdTime <= :createdTimeTo) AND " +
            "(:updatedTimeFrom IS NULL OR i.updatedTime >= :updatedTimeFrom) AND " +
            "(:updatedTimeTo IS NULL OR i.updatedTime <= :updatedTimeTo) AND " +
            "(:createdUser IS NULL OR i.createdUser = :createdUser) AND " +
            "(:updatedUser IS NULL OR i.updatedUser = :updatedUser)")
    Page<Item> search(
            @Param("itemId") Long itemId,
            @Param("itemName") String itemName,
            @Param("itemCode") String itemCode,
            @Param("itemValue") String itemValue,
            @Param("parentItemId") Long parentItemId,
            @Param("categoryId") Long categoryId,
            @Param("status") Long status,
            @Param("createdTimeFrom") LocalDateTime createdTimeFrom,
            @Param("createdTimeTo") LocalDateTime createdTimeTo,
            @Param("updatedTimeFrom") LocalDateTime updatedTimeFrom,
            @Param("updatedTimeTo") LocalDateTime updatedTimeTo,
            @Param("createdUser") Long createdUser,
            @Param("updatedUser") Long updatedUser,
            Pageable pageable);

}
