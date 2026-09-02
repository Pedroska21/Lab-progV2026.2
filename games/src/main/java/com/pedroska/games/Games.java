package com.pedroska.games;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table
public class Games {
    @Id
     @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
        private UUID id;
    @Column(name= "name", nullable = false)
        private String name;
    @Column(name= "category", nullable = false)
        private String category;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public static void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }



    public static void setCategory(String category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
        }

    }
