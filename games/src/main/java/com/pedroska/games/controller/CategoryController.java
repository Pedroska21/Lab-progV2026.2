package com.pedroska.games.controller;

import com.pedroska.games.dto.request.UpdateCategoryRequestDto;
import com.pedroska.games.dto.response.CategoryResponseDto;
import com.pedroska.games.mapper.CategoryMapper;
import com.pedroska.games.model.Category;
import com.pedroska.games.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper){
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> list() {
        List<Category> category = categoryService.findAll();
        List<CategoryResponseDto> categoryResponseDtos = categoryMapper.fromCategoryToDto(category);
        return ResponseEntity.ok().body(categoryResponseDtos);
    }
    @Operation(summary = "Search category by ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Category found"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Category not found"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> findById(@PathVariable UUID uuid) {
        Category category = categoryService.findById(uuid);
        return ResponseEntity.ok().body(categoryMapper.fromCategoryToDto(category));
    }
    @PutMapping
    public ResponseEntity<CategoryResponseDto> update(@PathVariable UUID uuid, @RequestBody @Valid UpdateCategoryRequestDto categoryDto) {
        Category category = categoryMapper.fromUpdateCategoryRequestDtoToEntity(categoryDto);
       Category updated = categoryService.update(category, uuid);
        return ResponseEntity.ok().body(categoryMapper.fromCategoryToDto(updated));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        categoryService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

}
