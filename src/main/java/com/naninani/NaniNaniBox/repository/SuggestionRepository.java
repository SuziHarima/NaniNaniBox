package com.naninani.NaniNaniBox.repository;


import com.naninani.NaniNaniBox.entity.SuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends JpaRepository<SuggestionEntity, Integer> {
}
