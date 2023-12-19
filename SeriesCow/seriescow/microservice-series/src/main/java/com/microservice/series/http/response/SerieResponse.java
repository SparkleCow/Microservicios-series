package com.microservice.series.http.response;

import com.microservice.series.entities.Chapter.ChapterDto;
import com.microservice.series.entities.Serie.Genre;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@Builder
public record SerieResponse(
        String serieTitle,
        String description,
        Date releaseDate,
        String bannerUrl,
        List<Genre> genres,
        List<ChapterDto> chapter
) {
}
