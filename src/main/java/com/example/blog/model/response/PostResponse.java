package com.example.blog.model.response;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PostResponse implements Serializable {
    private Integer postId;
    private String postTitle;
    private String postContent;
    private Integer categoryId;
    private String categoryName;

    public PostResponse(Integer postId, String postTitle, String postContent, Integer categoryId, String categoryName) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
