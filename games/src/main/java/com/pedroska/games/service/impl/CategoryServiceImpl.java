package com.pedroska.games.service.impl;

import com.pedroska.games.exception.CategoryAlreadyExistsException;
import com.pedroska.games.exception.CategoryNotFoundException;
import com.pedroska.games.model.Category;
import com.pedroska.games.repository.CategoryRepository;
import com.pedroska.games.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public UUID create(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryAlreadyExistsException(category.getName());
        }
        return categoryRepository.save(category).getId();
    }
    @Override
    public Category update(Category category, UUID uuid) {
        Category existing = findById(uuid);
        if (!existing.getName().equals(category.getName()) && categoryRepository.existsByName(category.getName())) {
            throw new CategoryAlreadyExistsException(category.getName());
        }
        existing.setName(category.getName());
        return categoryRepository.save(existing);
    }
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public Category findById(UUID uuid) {
        return categoryRepository.findById(uuid)
                .orElseThrow(() -> new CategoryNotFoundException(uuid));
    }
    @Override
    public void delete(UUID uuid) {
        if (!categoryRepository.existsById(uuid)) {
            throw new CategoryNotFoundException(uuid);
        }
        categoryRepository.deleteById(uuid);
    }
}

