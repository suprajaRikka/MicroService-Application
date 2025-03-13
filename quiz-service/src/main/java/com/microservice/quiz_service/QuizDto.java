package com.microservice.quiz_service;

public class QuizDto {
	String Category;
	Integer numQuestions;
	String title;
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public Integer getNumQuestions() {
		return numQuestions;
	}
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public QuizDto(String category, Integer numQuestions, String title) {
		super();
		Category = category;
		this.numQuestions = numQuestions;
		this.title = title;
	}
	public QuizDto() {
		super();
	}
	@Override
	public String toString() {
		return "QuizDto [Category=" + Category + ", numQuestions=" + numQuestions + ", title=" + title + "]";
	}

}
