package com.naninani.NaniNaniBox.service;


import com.naninani.NaniNaniBox.dto.SuggestionRequest;
import com.naninani.NaniNaniBox.entity.SuggestionEntity;
import com.naninani.NaniNaniBox.repository.SuggestionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class SuggestionService {

    private SuggestionRepository suggestionRepository;


    public void create(@RequestBody SuggestionRequest suggestionRequest){
        log.info("Creating Suggestion");
        SuggestionEntity suggestion = new SuggestionEntity();
        suggestion.setTitle(suggestionRequest.title());
        suggestion.setDescription(suggestionRequest.description());

        suggestionRepository.save(suggestion);
        log.info("Suggestion CREATED");
    }

    public List<SuggestionEntity> listAll(){
        log.info("Searching all Suggestions on database...");
        return suggestionRepository.findAll();
    }

    public SuggestionEntity findById(Integer id){
        log.info("Searching Suggestion by ID...");
        SuggestionEntity suggestion = suggestionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Suggestion not found"));
        return suggestion;
    }

}
