package com.pedroska.games.service;

import com.pedroska.games.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    UUID create(Category category);
    Category update(Category category, UUID uuid);
    List<Category> findAll();
    Category findById(UUID uuid);
    void delete(UUID uuid);
}