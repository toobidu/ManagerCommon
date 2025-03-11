package org.example.informationservice.Repository;

import org.example.informationservice.Model.Entity.Files;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface FilesRepository extends JpaRepository<Files, Long>{

    Optional<Files> findById(Long fileId);

    boolean  existsById(Long fileId);

    @Query("SELECT f FROM Files f WHERE " +
            "(:fileId IS NULL OR f.fileId = :fileId) AND " +
            "(:fileName IS NULL OR LOWER(f.fileName) LIKE LOWER(CONCAT('%', :fileName, '%'))) AND " +
            "(:filePath IS NULL OR LOWER(f.filePath) LIKE LOWER(CONCAT('%', :filePath, '%'))) AND " +
            "(:businessCode IS NULL OR LOWER(f.businessCode) LIKE LOWER(CONCAT('%', :businessCode, '%'))) AND " +
            "(:businessId IS NULL OR f.businessId = :businessId) AND " +
            "(:status IS NULL OR f.status = :status) AND " +
            "(:createdTimeFrom IS NULL OR f.createdTime >= :createdTimeFrom) AND " +
            "(:createdTimeTo IS NULL OR f.createdTime <= :createdTimeTo) AND " +
            "(:updatedTimeFrom IS NULL OR f.updatedTime >= :updatedTimeFrom) AND " +
            "(:updatedTimeTo IS NULL OR f.updatedTime <= :updatedTimeTo) AND " +
            "(:createdUser IS NULL OR f.createdUser = :createdUser) AND " +
            "(:updatedUser IS NULL OR f.updatedUser = :updatedUser)")
    Page<Files> search(
            @Param("fileId") Long fileId,
            @Param("fileName") String fileName,
            @Param("filePath") String filePath,
            @Param("businessCode") String businessCode,
            @Param("businessId") Long businessId,
            @Param("status") Long status,
            @Param("createdTimeFrom") LocalDateTime createdTimeFrom,
            @Param("createdTimeTo") LocalDateTime createdTimeTo,
            @Param("updatedTimeFrom") LocalDateTime updatedTimeFrom,
            @Param("updatedTimeTo") LocalDateTime updatedTimeTo,
            @Param("createdUser") Long createdUser,
            @Param("updatedUser") Long updatedUser,
            Pageable pageable);
}
