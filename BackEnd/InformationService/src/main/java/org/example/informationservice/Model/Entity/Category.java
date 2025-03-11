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
import java.util.List;


@Entity
@Table(name = "Category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)

public class Category {

    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long categoryId;

    @Column(name = "CATEGORY_CODE", nullable = false, length = 100)
    String categoryCode;

    @Column(name = "CATEGORY_NAME", nullable = false, length = 500)
    String categoryName;

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

    @OneToMany(mappedBy = "CATEGORY")
    List<Item> items;

}
