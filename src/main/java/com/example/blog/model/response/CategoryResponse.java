package com.example.blog.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryResponse {
    private Integer categoryId;
    private String categoryName;
}
