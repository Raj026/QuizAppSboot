package com.rapa.quizapp.dao;

import com.rapa.quizapp.Question;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Id> {
    List<Question> findByCategory(String category);
}
