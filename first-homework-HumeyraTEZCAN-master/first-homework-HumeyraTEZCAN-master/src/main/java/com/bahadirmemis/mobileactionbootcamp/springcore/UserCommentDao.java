package com.bahadirmemis.mobileactionbootcamp.springcore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentDao extends JpaRepository<UserComment, Long> {
}
