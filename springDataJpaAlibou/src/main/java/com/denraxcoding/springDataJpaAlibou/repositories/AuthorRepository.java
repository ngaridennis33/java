package com.denraxcoding.springDataJpaAlibou.repositories;

import com.denraxcoding.springDataJpaAlibou.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
