package com.naninani.NaniNaniBox.service;

import com.naninani.NaniNaniBox.dto.CommentRequest;
import com.naninani.NaniNaniBox.entity.CommentEntity;
import com.naninani.NaniNaniBox.entity.SuggestionEntity;
import com.naninani.NaniNaniBox.repository.CommentRepository;
import com.naninani.NaniNaniBox.repository.SuggestionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final SuggestionRepository suggestionRepository;

    public void create(@RequestBody CommentRequest commentRequest, Integer id){
        log.info("Creating comment");
        CommentEntity comment = new CommentEntity();

//        busca a sugestão pelo ID, que será fornecido no caminho da url
        SuggestionEntity suggestion = suggestionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Suggestion not found"));

        suggestion.setUpdateDate(LocalDateTime.now());
        comment.setSuggestion(suggestion);
        comment.setText(commentRequest.text());

        commentRepository.save(comment);
        log.info("Comment CREATED");
    }


}
