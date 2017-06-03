package com.jia.news.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jia.news.dto.News;

public interface NewsRepository extends MongoRepository<News,String>{
	 List<News> findByTitle(String title);
}
