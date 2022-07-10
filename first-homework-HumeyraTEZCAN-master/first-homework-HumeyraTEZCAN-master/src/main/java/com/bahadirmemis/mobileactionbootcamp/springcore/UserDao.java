package com.bahadirmemis.mobileactionbootcamp.springcore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
