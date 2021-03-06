package com.example.blog.controller;

import com.example.blog.model.response.CategoryResponse;
import com.example.blog.model.response.HeadlineResponse;
import com.example.blog.model.response.PostResponse;
import com.example.blog.service.BlogService;
import com.example.blog.service.CachedBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class BlogController {
    private final BlogService blogService;
    private final CachedBlogService cachedBlogService;
    public BlogController(BlogService blogService, CachedBlogService cachedBlogService) {
        this.blogService = blogService;
        this.cachedBlogService = cachedBlogService;
    }

    @GetMapping("")
    public String getHome() {
        log.info("getHome()");
        return "home";
    }

    @GetMapping("categories")
    public List<CategoryResponse> getCategories() {
        log.info("getCategories()");
        return blogService.getCategories();
    }

    @GetMapping("posts")
    public List<PostResponse> getPosts(
            @RequestParam(name = "categoryId", required = false) Integer categoryId,
            @RequestParam(name = "cacheOn", required = false) Boolean cacheOn) {
        log.info("getPosts()");
        return cacheOn != null && cacheOn ? cachedBlogService.getPosts(categoryId) : blogService.getPosts(categoryId);
    }

    @GetMapping("headlines")
    public List<HeadlineResponse> getHeadlines() {
        log.info("getHeadlines()");
        return blogService.getHeadlines();
    }
}
