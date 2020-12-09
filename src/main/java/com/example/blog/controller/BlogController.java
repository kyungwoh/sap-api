package com.example.blog.controller;

import com.example.blog.model.response.CategoryResponse;
import com.example.blog.model.response.HeadlineResponse;
import com.example.blog.model.response.PostResponse;
import com.example.blog.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    private final BlogService blogService;
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("categories")
    public List<CategoryResponse> getCategories() {
        return blogService.getCategories();
    }

    @GetMapping("posts")
    public List<PostResponse> getPosts() { return blogService.getPosts(); }

    @GetMapping("headlines")
    public List<HeadlineResponse> getHeadlines() { return blogService.getHeadlines(); }
}
