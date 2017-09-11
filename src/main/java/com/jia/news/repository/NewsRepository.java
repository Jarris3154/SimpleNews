package com.jia.news.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jia.news.domain.News;

public interface NewsRepository extends MongoRepository<News, String> {
    public List<News> findByTitle(String title);

    public List<News> findByAuthor(String author);

    public List<News> findAll();
}
