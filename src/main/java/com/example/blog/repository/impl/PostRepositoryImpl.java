package com.example.blog.repository.impl;

import com.example.blog.model.entity.QCategory;
import com.example.blog.model.entity.QPost;
import com.example.blog.model.response.PostResponse;
import com.example.blog.repository.PostRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PostResponse> getPosts() {
        QPost post = QPost.post;
        QCategory category = QCategory.category;
        return new JPAQuery<PostResponse>(entityManager)
                .select(Projections.constructor(PostResponse.class,
                        post.postId,
                        post.postTitle,
                        post.postContent,
                        category.categoryId,
                        category.categoryName))
                .from(post)
                .innerJoin(post.category, category)
                .orderBy(post.postId.asc())
                .fetch();
    }
}
