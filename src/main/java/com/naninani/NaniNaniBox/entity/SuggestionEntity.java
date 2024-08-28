package com.naninani.NaniNaniBox.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

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
    private String registerDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private String updateDate;

}
