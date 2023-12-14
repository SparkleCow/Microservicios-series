package com.microservice.chapters.repositories;

import com.microservice.chapters.entities.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    @Query(value = "SELECT * FROM chapters WHERE serie_id = :id", nativeQuery = true)
    Set<Chapter> findBySerie(@Param("id") Long id);
}
