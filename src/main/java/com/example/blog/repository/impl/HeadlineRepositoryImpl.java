package com.example.blog.repository.impl;

import com.example.blog.model.entity.QCategory;
import com.example.blog.model.entity.QHeadline;
import com.example.blog.model.entity.QPost;
import com.example.blog.model.response.HeadlineResponse;
import com.example.blog.model.response.PostResponse;
import com.example.blog.repository.HeadlineRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HeadlineRepositoryImpl implements HeadlineRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HeadlineResponse> getHeadlines() {
        QHeadline headline = QHeadline.headline;
        QPost post = QPost.post;
        QCategory category = QCategory.category;
        return new JPAQuery<HeadlineResponse>(entityManager)
                .select(Projections.constructor(HeadlineResponse.class,
                        headline.headlineId,
                        post.postId,
                        post.postTitle,
                        post.postContent,
                        category.categoryId,
                        category.categoryName))
                .from(headline)
                .innerJoin(headline.post, post)
                .innerJoin(post.category, category)
                .orderBy(headline.headlineId.asc())
                .fetch();
    }
}
