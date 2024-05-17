package com.denraxcoding.springDataJpaAlibou.repositories;

import com.denraxcoding.springDataJpaAlibou.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
