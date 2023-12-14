package com.microservice.chapters.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chapters")
@Data
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false,  length = 100, unique = true)
    private String title;
    @ElementCollection
    @Column(name = "video_players", nullable = false)
    private Set<String> videoPlayers = new HashSet<>();
    private Integer views = 0;
    @Column(name = "serie_id", nullable = false)
    private Long serieId;


    public Chapter(String title, Set<String> videoplayers, Long serieId){
        this.title=title;
        this.videoPlayers=videoplayers;
        this.serieId=serieId;
    }

    public void viewCount(){
        this.views++;
    }

    public Chapter update(ChapterUpdateDTO chapterUpdateDTO) {
        if(!(chapterUpdateDTO.title()==null) || !chapterUpdateDTO.title().equals("")){
            this.title=chapterUpdateDTO.title();
        }
        if(!(chapterUpdateDTO.serieId()==null)){
            this.title=chapterUpdateDTO.title();
        }
        if(!(chapterUpdateDTO.videoPlayers()==null) || !chapterUpdateDTO.videoPlayers().isEmpty()){
            this.title=chapterUpdateDTO.title();
        }
        return this;
    }
}
