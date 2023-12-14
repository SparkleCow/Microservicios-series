package com.microservice.chapters.entities;

import java.util.Set;

public record ChapterUpdateDTO(
        String title,
        Set<String> videoPlayers,
        Long serieId) {
}
