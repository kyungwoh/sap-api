package com.example.blog.repository;

import com.example.blog.model.response.PostResponse;

import java.util.List;

public interface PostRepositoryCustom {
    List<PostResponse> getPosts();
}
