package com.microservice.quiz_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	@Autowired
	QuizInterface quizInterface;


	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
	List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
	Quiz quiz = new Quiz();
	quiz.setTitle(title);
	quiz.setQuestionsIds(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
	 Quiz quiz = quizDao.findById(id).get();
	 List<Integer> questionIds = quiz.getQuestionsIds();
	 
	 ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
		
			return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses)
	{
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		 new ResponseEntity<>(score, HttpStatus.OK);
		 return score;
	}
	


}
	
