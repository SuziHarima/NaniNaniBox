package com.naninani.NaniNaniBox.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "suggestion")
public class SuggestionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime registerDate = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime updateDate = LocalDateTime.now();

}
