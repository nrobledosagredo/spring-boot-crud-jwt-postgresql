package com.nrobledosagredo.itemmanagement.model;

import jakarta.persistence.*;
import lombok.*;

// Represents a item stored in 'items' table
@Entity
@Table(name = "items", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "name", "user_id" })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "user_id", nullable = false)
    private String userId;
}