package com.example.blog.repository;

import com.example.blog.model.entity.Headline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadlineRepository extends JpaRepository<Headline, Integer>, HeadlineRepositoryCustom {
}
