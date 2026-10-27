package com.pedroska.games.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "games")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public Games(@NotNull @NotEmpty String name, @NotNull @NotEmpty String category) {
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
