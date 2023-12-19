package com.microservice.series.client;

import com.microservice.series.entities.Chapter.ChapterDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "localhost:8080/api/chapter", name = "msvc-chapters")
public interface ChapterClient {

    @GetMapping("/serie/{id}")
    List<ChapterDto> findChaptersBySerie(@PathVariable Long id);
}
