package com.example.blog.model.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "headline")
public class Headline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "headline_id")
    private Integer headlineId;

    @Column(name = "post_id")
    private Integer postId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", insertable = false, updatable = false)
    private Post post;
}
