package com.naninani.NaniNaniBox.repository;

import com.naninani.NaniNaniBox.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
