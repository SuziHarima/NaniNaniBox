package com.naninani.NaniNaniBox.controller;


import com.naninani.NaniNaniBox.dto.CommentRequest;
import com.naninani.NaniNaniBox.dto.SuggestionRequest;
import com.naninani.NaniNaniBox.entity.SuggestionEntity;
import com.naninani.NaniNaniBox.service.CommentService;
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
    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SuggestionRequest suggestionRequest){
        log.info("POST /suggestion -> BEGIN");
        suggestionService.create(suggestionRequest);
        log.info("POST /suggestion -> END");
    }

    @GetMapping
    public List<SuggestionEntity> listAll(){
        log.info("GET /suggestion -> BEGIN");
       List<SuggestionEntity> suggestionList = suggestionService.listAll();
        log.info("GET /suggestion -> END");
        return suggestionList;
    }

    @GetMapping("{id}")
    public SuggestionEntity findByID(@PathVariable Integer id){
        log.info("GET /suggestion -> BEGIN");
        SuggestionEntity suggestion = suggestionService.findById(id);
        log.info("GET /suggestion -> END");
        return suggestion;
    }

    @PostMapping("{id}/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody CommentRequest commentRequest, @PathVariable Integer id){
        log.info("POST /comment -> BEGIN");
        commentService.create(commentRequest,id);
        log.info("POST /comment -> END");
    }
}
