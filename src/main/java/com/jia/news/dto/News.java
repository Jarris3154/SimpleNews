package com.jia.news.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
public class News {
	@Id
	private String id;
	
	private String title;
	private String description;
	private String author;
	private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author + ", date="
				+ date + "]";
	}

}
