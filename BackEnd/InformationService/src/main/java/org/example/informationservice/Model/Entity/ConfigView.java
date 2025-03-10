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
@Table(name = "Config_View")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)

public class ConfigView {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long configViewId;

    @Column(name = "VIEW_NAME", nullable = false, length = 500)
    String viewName;

    @Column(name = "VIEW_PATH", nullable = false, length = 500)
    String viewPath;

    @Column(name = "API_PATH", nullable = false, length = 500)
    String apiPath;

    @Column(name = "ROLE_ID", nullable = false, length = 100)
    String roleId;

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
