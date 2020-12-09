package com.example.blog.repository;

import com.example.blog.model.response.HeadlineResponse;

import java.util.List;

public interface HeadlineRepositoryCustom {
    List<HeadlineResponse> getHeadlines();
}
