package com.microservice.series.repositories;

import com.microservice.series.entities.Serie.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT s FROM Serie s WHERE LOWER(s.genres) LIKE LOWER(CONCAT('%', :searchGenre, '%'))")
    List<Serie> findByGender(@Param("searchGenre") String searchGenre);
    @Query("SELECT s FROM Serie s WHERE LOWER(s.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Serie> findSeriesByTitle(@Param("title") String title);
}
