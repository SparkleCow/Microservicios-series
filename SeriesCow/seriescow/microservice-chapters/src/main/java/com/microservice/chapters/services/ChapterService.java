package com.microservice.chapters.services;

import com.microservice.chapters.entities.Chapter;
import com.microservice.chapters.entities.ChapterUpdateDTO;

import java.util.Set;

public interface ChapterService {
    Set<Chapter> findAllChapters();
    Set<Chapter> findChaptersBySerie(Long id);
    Chapter findChapterById(Long id);
    Chapter createChapter(Chapter chapter);
    Chapter updateChapter(Long id, ChapterUpdateDTO chapterUpdateDTO);
    Chapter deleteChapter(Long id);

}
