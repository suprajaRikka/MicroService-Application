package com.microservice.quiz_service;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@ElementCollection
	private List<Integer> questionsIds;
	public Quiz(Integer id, String title, List<Integer> questions) {
		super();
		this.id = id;
		this.title = title;
		this.questionsIds = questionsIds;
	}
	public Quiz() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Integer> getQuestionsIds() {
		return questionsIds;
	}
	public void setQuestionsIds(List<Integer> questionsIds) {
		this.questionsIds = questionsIds;
	}
	@Override
	public String toString() {
		
		return "Quiz [id=" + id + ", title=" + title + ", questionsIds=" + questionsIds + "]";
	}
	
}
