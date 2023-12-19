package com.microservice.series.services;

import com.microservice.series.client.ChapterClient;
import com.microservice.series.entities.Chapter.ChapterDto;
import com.microservice.series.entities.Serie.Serie;
import com.microservice.series.http.response.SerieResponse;
import com.microservice.series.repositories.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieServiceImp implements SerieService{

    private final SerieRepository serieRepository;
    private final ChapterClient chapterClient;
    @Override
    public List<Serie> findAllSeries() {
        return serieRepository.findAll();
    }

    @Override
    public List<Serie> findSeriesByGenre(String genre) {
        return serieRepository.findByGender(genre);
    }

    @Override
    public List<Serie> findSerieByTitle(String title) {
        return serieRepository.findSeriesByTitle(title);
    }

    @Override
    public Serie findSerieById(Long id) {
        return serieRepository.findById(id).orElseThrow();
    }

    @Override
    public Serie createSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public Serie deleteSerie(Long id) {
        return null;
    }

    @Override
    public SerieResponse findChaptersBySerie(Long id) {
        Serie serie = serieRepository.findById(id).orElseThrow();
        System.out.print(serie.toString());
        List<ChapterDto> chapterDtos = chapterClient.findChaptersBySerie(id);
        System.out.print(chapterDtos);
        return SerieResponse.builder()
                .serieTitle(serie.getTitle())
                .description(serie.getDescription())
                .releaseDate(serie.getReleaseDate())
                .bannerUrl(serie.getBannerUrl())
                .genres(serie.getGenres())
                .chapter(chapterDtos).build();
    }
}
