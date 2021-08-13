package com.cherr.mov.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostsEntity, Long> {

}
