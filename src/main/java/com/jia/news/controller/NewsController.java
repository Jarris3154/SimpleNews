package com.jia.news.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jia.news.dto.News;
import com.jia.news.repository.NewsRepository;

@RestController
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	// 查询所有新闻
	@RequestMapping(method = RequestMethod.GET)
	public List<News> find() {
		return newsRepository.findAll();
	}

	// 增加新闻
	@RequestMapping(method = RequestMethod.POST)
	public News save(@RequestBody News news) {
		Date date = new Date();
		news.setPublishDate(date);
		news.setLastModifiedDate(date);
		newsRepository.save(news);
		return news;
	}

	// 按照id查询新闻
	@RequestMapping(value = "/{newsId}", method = RequestMethod.GET)
	public News findOne(@PathVariable String newsId) {
		return newsRepository.findOne(newsId);
	}

	// 按照条件查询
/*	@RequestMapping(method = RequestMethod.GET,consumes="application/json")
	public List<News> findByQuery(@RequestParam Query query) {
		return mongoTemplate.find(query, News.class);
	}*/

	// 删除新闻
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody News news) {
		newsRepository.delete(news);
	}

	// 局部更新
	@RequestMapping(method = RequestMethod.PATCH)
	public void update(@RequestBody News news) throws Exception {
		// 比较是否相同，只更新修改过的字段
		// 获取传进来的新闻
		String author = news.getAuthor();
		String title = news.getTitle();
		String content = news.getContent();
		String id = news.getId();
		if (id == null) {
			throw new Exception("您没有输入新闻id");
		}
		// 获取当前存储新闻(通过Repository后台取)
		News news2 = newsRepository.findOne(id);
		if (news2 == null) {
			throw new Exception("您要修改的新闻没有记录");
		}
		String author2 = news2.getAuthor();
		String title2 = news2.getTitle();
		String content2 = news2.getContent();

		// (或者通过api取json)
		/*
		 * URL newsUrl = new
		 * URL("http://localhost:8080/SimpleNews/api/rest/v1/news"); String
		 * newsString = getRestResponse(newsUrl); Gson gson = new Gson();
		 * gson.fromJson(newsString, List.class); JSONObject
		 * newsJson=(JSONObject) newsArray.get(0); String content3 = (String)
		 * newsJson.get("content"); String author3 = (String)
		 * newsJson.get("author"); String title3 = (String)
		 * newsJson.get("title");
		 */

		if (author != null && !author.equals(author2)) {
			mongoTemplate.updateFirst(new Query(Criteria.where("id").is(news.getId())),
					new Update().set("author", author).set("lastModifiedDate", new Date()), News.class);
		}
		if (title != null && !content.equals(title2)) {
			mongoTemplate.updateFirst(new Query(Criteria.where("id").is(news.getId())),
					new Update().set("title", title).set("lastModifiedDate", new Date()), News.class);
		}
		if (content != null && !content.equals(content2)) {
			mongoTemplate.updateFirst(new Query(Criteria.where("id").is(news.getId())),
					new Update().set("content", content).set("lastModifiedDate", new Date()), News.class);
		}
	}

	// 更新所有匹配新闻
	@RequestMapping(method = RequestMethod.PUT)
	public void updateMulti(@RequestBody News news) {
		String author = news.getAuthor();
		String title = news.getTitle();
		String content = news.getContent();
		if (author != null) {
			mongoTemplate.updateFirst(new Query(Criteria.where("id").is(news.getId())),
					new Update().set("author", author).set("lastModifiedDate", new Date()), News.class);
		}
		if (title != null) {
			mongoTemplate.updateFirst(new Query(Criteria.where("id").is(news.getId())),
					new Update().set("title", title).set("lastModifiedDate", new Date()), News.class);
		}
		if (content != null) {
			mongoTemplate.updateFirst(new Query(Criteria.where("id").is(news.getId())),
					new Update().set("content", content).set("lastModifiedDate", new Date()), News.class);
		}
	}

	// 通过url访问api获取json字符串
	private static String getRestResponse(URL newsUrl) throws Exception {
		StringBuilder result = new StringBuilder();
		HttpURLConnection conn = (HttpURLConnection) newsUrl.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(30000);
		conn.setReadTimeout(30000);
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		return result.toString();
	}
}
