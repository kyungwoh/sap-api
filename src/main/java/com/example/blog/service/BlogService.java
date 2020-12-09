package com.example.blog.service;

import com.example.blog.model.mapper.CategoryMapper;
import com.example.blog.model.response.CategoryResponse;
import com.example.blog.model.response.HeadlineResponse;
import com.example.blog.model.response.PostResponse;
import com.example.blog.repository.CategoryRepository;
import com.example.blog.repository.HeadlineRepository;
import com.example.blog.repository.PostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;
    private final HeadlineRepository headlineRepository;
    public BlogService(CategoryRepository categoryRepository, PostRepository postRepository, HeadlineRepository headlineRepository) {
        this.categoryRepository = categoryRepository;
        this.postRepository = postRepository;
        this.headlineRepository = headlineRepository;
    }
    public List<CategoryResponse> getCategories() {
        return CategoryMapper.convert(categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryId")));
    }
    public List<PostResponse> getPosts() {
        return postRepository.getPosts();
    }

    public List<HeadlineResponse> getHeadlines() {
        return headlineRepository.getHeadlines();
    }
}
