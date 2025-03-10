package org.example.informationservice.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER_ROLES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)

public class UserRoles {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userRoleId;

    @Column(name = "USER_ID")
    Long userId;

    @Column(name = "ROLE_ID")
    Long roleId;

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
