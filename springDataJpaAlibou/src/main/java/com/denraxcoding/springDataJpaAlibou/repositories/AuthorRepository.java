package com.denraxcoding.springDataJpaAlibou.repositories;

import com.denraxcoding.springDataJpaAlibou.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // Update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    // Update all Authors
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    int updateAllAuthorSAges(int age);


    // Named Query
    List<Author> findByNamedQuery(@Param("age") int age);

    // Select * from author
    // List<Author> findAll(String fn);

    // Select * from author where first_name = "al"
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    // select * from author where first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    // select * from author where first_name like 'al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    // select * from author where first_name like '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    // select * from author where first_name in ('ali','bow','coding')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

}
