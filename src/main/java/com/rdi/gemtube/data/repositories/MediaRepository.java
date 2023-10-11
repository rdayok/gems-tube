package com.rdi.gemtube.data.repositories;

import com.rdi.gemtube.data.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
