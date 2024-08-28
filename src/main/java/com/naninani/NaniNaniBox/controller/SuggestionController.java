package com.naninani.NaniNaniBox.controller;


import com.naninani.NaniNaniBox.dto.SuggestionRequest;
import com.naninani.NaniNaniBox.entity.SuggestionEntity;
import com.naninani.NaniNaniBox.service.SuggestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("suggestion")
@AllArgsConstructor
public class SuggestionController {

    private final SuggestionService suggestionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SuggestionRequest suggestionRequest){
        suggestionService.create(suggestionRequest);
        log.info("POST /suggestion -> 201 CREATED");
    }

    @GetMapping
    public List<SuggestionEntity> listAll(){
       List<SuggestionEntity> suggestionList = suggestionService.listAll();
        log.info("GET /suggestion -> SUCCESSFUL");
        return suggestionList;
    }
}
