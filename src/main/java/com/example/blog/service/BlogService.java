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
import java.util.stream.Collectors;

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
    public List<PostResponse> getPosts(Integer categoryId) {
        List<PostResponse> posts = postRepository.getPosts();
        return categoryId == null ?
                posts :
                posts.stream().filter(p -> p.getCategoryId().equals(categoryId)).collect(Collectors.toList());
    }

    public List<HeadlineResponse> getHeadlines() {
        return headlineRepository.getHeadlines();
    }
}
