package com.pedroska.games.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "category")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Category {
    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
        private  UUID id;
    @Column(name="name", nullable = false)
        private String name;
}
