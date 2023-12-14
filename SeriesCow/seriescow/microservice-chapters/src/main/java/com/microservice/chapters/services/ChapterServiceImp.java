package com.microservice.chapters.services;

import com.microservice.chapters.entities.Chapter;
import com.microservice.chapters.entities.ChapterUpdateDTO;
import com.microservice.chapters.repositories.ChapterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ChapterServiceImp implements ChapterService{

    private final ChapterRepository chapterRepository;
    @Override
    public Set<Chapter> findAllChapters() {
        return Set.copyOf(chapterRepository.findAll());
    }

    @Override
    public Set<Chapter> findChaptersBySerie(Long id) {
        return chapterRepository.findBySerie(id);
    }

    @Override
    public Chapter findChapterById(Long id) {
        return chapterRepository.findById(id).orElseThrow();
    }

    @Override
    public Chapter createChapter(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Override
    public Chapter updateChapter(Long id, ChapterUpdateDTO chapterUpdateDTO) {
        Chapter chapter = chapterRepository.findById(id).orElseThrow();
        chapter = chapter.update(chapterUpdateDTO);
        return chapterRepository.save(chapter);
    }

    @Override
    public Chapter deleteChapter(Long id) {
        Chapter chapter = chapterRepository.findById(id).orElseThrow();
        chapterRepository.deleteById(id);
        return chapter;
    }
}
