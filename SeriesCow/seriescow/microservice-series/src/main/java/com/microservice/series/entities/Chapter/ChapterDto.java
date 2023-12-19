package com.microservice.series.entities.Chapter;

import java.util.Set;

public record ChapterDto(
        String title,
        Set<String> videoPlayers,
        Integer views,
        Long serieId){
}
