package com.microservice.chapters.controllers;

import com.microservice.chapters.entities.Chapter;
import com.microservice.chapters.services.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/chapter")
@RequiredArgsConstructor
public class ChapterController {
    private final ChapterService chapterService;

    @GetMapping
    public ResponseEntity<Set<Chapter>> findAllChapters(){
        return ResponseEntity.ok(chapterService.findAllChapters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chapter> findChapterById(@PathVariable Long id){
        return ResponseEntity.ok(chapterService.findChapterById(id));
    }

    @GetMapping("/serie/{id}")
    public ResponseEntity<Set<Chapter>> findChaptersBySerie(@PathVariable Long id){
        return ResponseEntity.ok(chapterService.findChaptersBySerie(id));
    }

    @PostMapping
    public ResponseEntity<Chapter> createChapter(@RequestBody Chapter chapter) {
        return ResponseEntity.ok(chapterService.createChapter(chapter));
    }
}
