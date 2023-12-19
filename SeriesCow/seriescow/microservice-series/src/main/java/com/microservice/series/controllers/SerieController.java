package com.microservice.series.controllers;

import com.microservice.series.entities.Serie.Serie;
import com.microservice.series.http.response.SerieResponse;
import com.microservice.series.services.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/serie")
public class SerieController {
    private final SerieService serieService;

    @GetMapping
    public ResponseEntity<List<Serie>> findAllSeries(){
        return ResponseEntity.ok(serieService.findAllSeries());
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Serie>> findSeriesByGender(@RequestParam("genre") String genre){
        return ResponseEntity.ok(serieService.findSeriesByGenre(genre));
    }

    @GetMapping("/title")
    public ResponseEntity<List<Serie>> findSeriesByTitle(@RequestParam("title") String title){
        return ResponseEntity.ok(serieService.findSerieByTitle(title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> findSeriesById(@PathVariable Long id){
        return ResponseEntity.ok(serieService.findSerieById(id));
    }

    @GetMapping("/chapters/{id}")
    public ResponseEntity<SerieResponse> findChaptersBySerie(@PathVariable Long id){
        System.out.print("Entramos");
        return ResponseEntity.ok(serieService.findChaptersBySerie(id));
    }

    @PostMapping
    public ResponseEntity<Serie> createSerie(@RequestBody Serie serie){
        return ResponseEntity.ok(serieService.createSerie(serie));
    }

}
