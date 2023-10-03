package com.rdi.gemtube.data.repositories;

import com.rdi.gemtube.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
