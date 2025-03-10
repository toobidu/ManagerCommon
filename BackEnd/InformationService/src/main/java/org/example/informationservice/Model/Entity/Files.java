package org.example.informationservice.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "FILES")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Files {

    @Id
    @Column(name = "FILE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long fileId;

    @Column(name = "FILE_NAME", nullable = false, length = 500)
    String fileName;

    @Column(name = "FILE_PATH", nullable = false, length = 2000)
    String filePath;

    @Column(name = "BUSINESS_CODE", nullable = false, length = 100)
    String businessCode;

    @Column(name = "BUSINESS_ID")
    Long businessId;

    @Column(name = "STATUS")
    Long status;

    @Column(name = "CREATED_TIME")
    @CreationTimestamp
    LocalDateTime createdTime;

    @Column(name = "UPDATED_TIME")
    @UpdateTimestamp
    LocalDateTime updatedTime;

    @Column(name = "CREATED_USER")
    Long createdUser;

    @Column(name = "UPDATED_USER")
    Long updatedUser;
}
