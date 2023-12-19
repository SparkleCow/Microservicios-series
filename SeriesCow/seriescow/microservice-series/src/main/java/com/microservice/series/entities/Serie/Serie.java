package com.microservice.series.entities.Serie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
@Table(name= "series")
public class Serie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(50)")
    private String title;
    @Column(columnDefinition = "VARCHAR(255)")
    private String description;
    @Column(name="release_date")
    private Date releaseDate;
    @Column(name="banner_url")
    private String bannerUrl;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Genre> genres = new ArrayList<>();
}
