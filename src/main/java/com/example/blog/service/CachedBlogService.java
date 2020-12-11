package com.example.blog.service;

import com.example.blog.model.response.PostResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CachedBlogService {
    private final BlogService blogService;
    public CachedBlogService(BlogService blogService) { this.blogService = blogService; }

    @Cacheable(value = "post")
    public List<PostResponse> getPosts(Integer categoryId) {
        return blogService.getPosts(categoryId);
    }
}
