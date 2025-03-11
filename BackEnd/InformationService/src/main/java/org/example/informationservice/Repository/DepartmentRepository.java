package org.example.informationservice.Repository;

import org.example.informationservice.Model.Entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    Optional<Department> findByDepartmentId(Long departmentId);

    boolean existsByDepartmentId(Long departmentId);

    @Query("SELECT d FROM Department d WHERE " +
            "(:departmentId IS NULL OR d.departmentId = :departmentId) AND " +
            "(:departmentCode IS NULL OR LOWER(d.departmentCode) LIKE LOWER(CONCAT('%', :departmentCode, '%'))) AND " +
            "(:departmentName IS NULL OR LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :departmentName, '%'))) AND " +
            "(:parentDepartmentId IS NULL OR d.parentDepartmentId = :parentDepartmentId) AND " +
            "(:status IS NULL OR d.status = :status) AND " +
            "(:createdTimeFrom IS NULL OR d.createdTime >= :createdTimeFrom) AND " +
            "(:createdTimeTo IS NULL OR d.createdTime <= :createdTimeTo) AND " +
            "(:updatedTimeFrom IS NULL OR d.updatedTime >= :updatedTimeFrom) AND " +
            "(:updatedTimeTo IS NULL OR d.updatedTime <= :updatedTimeTo) AND " +
            "(:createdUser IS NULL OR d.createdUser = :createdUser) AND " +
            "(:updatedUser IS NULL OR d.updatedUser = :updatedUser)")
    Page<Department> search(
            @Param("departmentId") Long departmentId,
            @Param("departmentCode") String departmentCode,
            @Param("departmentName") String departmentName,
            @Param("parentDepartmentId") Long parentDepartmentId,
            @Param("status") Long status,
            @Param("createdTimeFrom") LocalDateTime createdTimeFrom,
            @Param("createdTimeTo") LocalDateTime createdTimeTo,
            @Param("updatedTimeFrom") LocalDateTime updatedTimeFrom,
            @Param("updatedTimeTo") LocalDateTime updatedTimeTo,
            @Param("createdUser") Long createdUser,
            @Param("updatedUser") Long updatedUser,
            Pageable pageable);
}
