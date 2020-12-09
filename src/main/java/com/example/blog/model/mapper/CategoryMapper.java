package com.example.blog.model.mapper;

import com.example.blog.model.entity.Category;
import com.example.blog.model.response.CategoryResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static CategoryResponse convert(Category category) {
        return CategoryResponse.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
    }
    public static List<CategoryResponse> convert(List<Category> categories) {
        return categories.stream().map(CategoryMapper::convert).collect(Collectors.toList());
    }
}
