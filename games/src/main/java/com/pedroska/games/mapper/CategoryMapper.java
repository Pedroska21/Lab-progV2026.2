package com.pedroska.games.mapper;

import com.pedroska.games.dto.request.CreateCategoryRequestDto;
import com.pedroska.games.dto.request.UpdateCategoryRequestDto;
import com.pedroska.games.dto.response.CategoryResponseDto;
import com.pedroska.games.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CategoryMapper {

    public Category fromCreateCategoryRequestDtoToEntity(CreateCategoryRequestDto categoryDto) {
        return Category.builder()
                .name(categoryDto.name())
                .build();
    }
    public Category fromUpdateCategoryRequestDtoToEntity(UpdateCategoryRequestDto categoryDto){
        return Category.builder()
                .name(categoryDto.name())
                .build();
    }
    public CategoryResponseDto fromCategoryToDto(Category category) {
        return new CategoryResponseDto(
                category.getId(),
                category.getName()
        );
    }
    public List<CategoryResponseDto> fromCategoryToDto(List<Category> category) {
        return category.stream()
                .map(this::fromCategoryToDto)
                .toList();
    }
}
