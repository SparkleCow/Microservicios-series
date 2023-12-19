package com.microservice.series.services;

import com.microservice.series.entities.Serie.Serie;
import com.microservice.series.http.response.SerieResponse;

import java.util.List;

public interface SerieService {
    List<Serie> findAllSeries();
    List<Serie> findSeriesByGenre(String genre);
    List<Serie> findSerieByTitle(String title);
    Serie findSerieById(Long id);
    Serie createSerie(Serie serie);
    Serie deleteSerie(Long id);
    SerieResponse findChaptersBySerie(Long id);
}
