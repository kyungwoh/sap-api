package com.example.blog.controller;

import com.example.blog.model.response.CategoryResponse;
import com.example.blog.model.response.HeadlineResponse;
import com.example.blog.model.response.PostResponse;
import com.example.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class BlogController {
    private final BlogService blogService;
    public BlogController(BlogService blogService) {
        log.info("BlogController contructor");
        this.blogService = blogService;
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
    public List<PostResponse> getPosts() {
        log.info("getPosts()");
        return blogService.getPosts();
    }

    @GetMapping("headlines")
    public List<HeadlineResponse> getHeadlines() {
        log.info("getHeadlines()");
        return blogService.getHeadlines();
    }
}
