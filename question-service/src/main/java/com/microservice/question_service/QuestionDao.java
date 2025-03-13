package com.microservice.question_service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.Order;

@Repository

public interface QuestionDao extends JpaRepository<Question, Integer>  {
	
	List<Question> findByCategory(String category);
	
//	@Query(value =" SELECT * FROM question q where q.category=:category" ORDER BY RANDOM() LIMIT :numQ, nativeQuery = true)
//	
//	List<Question> findRandomQuestionsByCategory(String category, int numQ);

	@Query(value = "SELECT q.id  FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	List<Integer> findRandomQuestionsByCategory(String category, int numQ);

}
