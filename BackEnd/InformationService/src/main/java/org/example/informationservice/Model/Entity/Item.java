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
@Table(name = "ITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder

public class Item {

    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long itemId;

    @Column(name = "ITEM_NAME", nullable = false, length = 500)
    String itemName;

    @Column(name = "ITEM_CODE", nullable = false, length = 100)
    String itemCode;

    @Column(name = "ITEM_VALUE", nullable = false, length = 500)
    String itemValue;

    @Column(name = "PARENT_ITEM_ID")
    Long parentItemId;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    Category category;

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
