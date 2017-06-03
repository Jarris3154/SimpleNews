package com.jia.news.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jia.news.dto.News;
import com.jia.news.repository.NewsRepository;

@RestController
public class NewsController {
	@Autowired
	private NewsRepository newsRepository;

	@RequestMapping("/save")
	public News save() {
		News news = new News();
		news.setAuthor("jiage");
		news.setDate(new Date());
		news.setTitle("今天去打球了");
		news.setDescription("今天打球时碰到一个小屁孩也在投篮");
		newsRepository.save(news);
		return news;
	}

	@RequestMapping("/find")
	public List<News> find() {
		return newsRepository.findAll();
	}

}
