package com.jia.apis.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class News {
	@Id
	private String id;
	//新闻标题 
	private String title;
	//新闻内容 
	private String content;
	//新闻作者 
	private String author;
	//发布日期 
	private Date publishDate;
	//最后修改日期
	private Date lastModifiedDate;

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", publishDate="
				+ publishDate + "]";
	}

}
