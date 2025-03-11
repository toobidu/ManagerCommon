package org.example.informationservice.Repository;

import org.example.informationservice.Model.Entity.ConfigView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfigViewRepository extends JpaRepository<ConfigView, Long>{

    Optional<ConfigView> findByConfigViewId(Long configViewId);

    boolean existsByConfigViewId(Long configViewId);

    @Query("SELECT c FROM ConfigView c WHERE " +
            "(:configViewId IS NULL OR c.configViewId = :configViewId) AND " +
            "(:viewName IS NULL OR LOWER(c.viewName) LIKE LOWER(CONCAT('%', :viewName, '%'))) AND " +
            "(:viewPath IS NULL OR LOWER(c.viewPath) LIKE LOWER(CONCAT('%', :viewPath, '%'))) AND " +
            "(:apiPath IS NULL OR LOWER(c.apiPath) LIKE LOWER(CONCAT('%', :apiPath, '%'))) AND " +
            "(:roleId IS NULL OR LOWER(c.roleId) LIKE LOWER(CONCAT('%', :roleId, '%'))) AND " +
            "(:status IS NULL OR c.status = :status) AND " +
            "(:createdTimeFrom IS NULL OR c.createdTime >= :createdTimeFrom) AND " +
            "(:createdTimeTo IS NULL OR c.createdTime <= :createdTimeTo) AND " +
            "(:updatedTimeFrom IS NULL OR c.updatedTime >= :updatedTimeFrom) AND " +
            "(:updatedTimeTo IS NULL OR c.updatedTime <= :updatedTimeTo) AND " +
            "(:createdUser IS NULL OR c.createdUser = :createdUser) AND " +
            "(:updatedUser IS NULL OR c.updatedUser = :updatedUser)")
    Page<ConfigView> search(
            @Param("configViewId") Long configViewId,
            @Param("viewName") String viewName,
            @Param("viewPath") String viewPath,
            @Param("apiPath") String apiPath,
            @Param("roleId") String roleId,
            @Param("status") Long status,
            @Param("createdTimeFrom") String createdTimeFrom,
            @Param("createdTimeTo") String createdTimeTo,
            @Param("updatedTimeFrom") String updatedTimeFrom,
            @Param("updatedTimeTo") String updatedTimeTo,
            @Param("createdUser") Long createdUser,
            @Param("updatedUser") Long updatedUser,
            Pageable pageable);
}
