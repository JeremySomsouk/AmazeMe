package com.manomano.AmazeMe.repository;

import com.manomano.AmazeMe.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
