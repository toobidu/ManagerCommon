package org.example.informationservice.Repository;

import org.example.informationservice.Model.Entity.SendMail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface SendMailRepository extends JpaRepository<SendMail, Long> {

    Optional<SendMail> findById(Long sendMailId);

    boolean existsById(Long sendMailId);

    @Query("SELECT s FROM SendMail s WHERE " +
            "(:sendMailId IS NULL OR s.sendMailId = :sendMailId) AND " +
            "(:content IS NULL OR LOWER(s.content) LIKE LOWER(CONCAT('%', :content, '%'))) AND " +
            "(:mailTo IS NULL OR LOWER(s.mailTo) LIKE LOWER(CONCAT('%', :mailTo, '%'))) AND " +
            "(:status IS NULL OR s.status = :status) AND " +
            "(:createdTimeFrom IS NULL OR s.createdTime >= :createdTimeFrom) AND " +
            "(:createdTimeTo IS NULL OR s.createdTime <= :createdTimeTo) AND " +
            "(:updatedTimeFrom IS NULL OR s.updatedTime >= :updatedTimeFrom) AND " +
            "(:updatedTimeTo IS NULL OR s.updatedTime <= :updatedTimeTo) AND " +
            "(:createdUser IS NULL OR s.createdUser = :createdUser) AND " +
            "(:updatedUser IS NULL OR s.updatedUser = :updatedUser)")
    Page<SendMail> search(
            @Param("sendMailId") Long sendMailId,
            @Param("content") String content,
            @Param("mailTo") String mailTo,
            @Param("status") Long status,
            @Param("createdTimeFrom") LocalDateTime createdTimeFrom,
            @Param("createdTimeTo") LocalDateTime createdTimeTo,
            @Param("updatedTimeFrom") LocalDateTime updatedTimeFrom,
            @Param("updatedTimeTo") LocalDateTime updatedTimeTo,
            @Param("createdUser") Long createdUser,
            @Param("updatedUser") Long updatedUser,
            Pageable pageable);

}
