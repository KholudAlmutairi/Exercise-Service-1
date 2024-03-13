package com.example.newsarticle.Controller;

import com.example.newsarticle.ApiResponse.ApiResponse;
import com.example.newsarticle.Model.NewsArticle;
import com.example.newsarticle.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/newsarticle")
@RequiredArgsConstructor
public class NewsArticleController {

    private final NewsArticleService newsArticleService;
   // 1. Get all NewsArticles
    @GetMapping("/get")
    public ResponseEntity getNewsArticleService(){
        ArrayList<NewsArticle> blogs=newsArticleService.getNewsArticle();
        return ResponseEntity.status(200).body(blogs);
    }

  //2. Add a NewsArticle
    @PostMapping("/add")
    public ResponseEntity addNewsArticle(@RequestBody @Valid NewsArticle newsArticle, Errors errors) {
        if(errors.hasErrors()){
            String massage =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        newsArticleService.addNewsArticle(newsArticle);
        return ResponseEntity.status(200).body( new ApiResponse("News Article added"));
    }



    //3. Update a NewsArticle.
    @PutMapping("/update/{id}")
    public ResponseEntity updatedArticleService(@PathVariable int id, @RequestBody @Valid  NewsArticle newsArticle,Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        boolean isupdated = newsArticleService.updateNewsArticle(id, newsArticle);
        if (isupdated) {
            return ResponseEntity.status(200).body(new ApiResponse("News Article  updated"));
           }
        return ResponseEntity.status(400).body(new ApiResponse("News Article not found"));
    }

       // 4. Delete a NewsArticle.
      @DeleteMapping("/delete/{id}")
      public ResponseEntity deleteNewsArticle(@PathVariable int id) {
            boolean isDeleted=newsArticleService.deleteNewsArticle(id);
            if(isDeleted){
                return ResponseEntity.status(200).body( new ApiResponse("News Article deleted"));
            }
            return ResponseEntity.status(400).body(new ApiResponse("News Article not found"));
       }
      // 5. Publish NewsArticles
    @PutMapping("/publish/{id}")
    public ResponseEntity publishNewsArticle(@PathVariable int id) {
        newsArticleService.publishNewsArticle(id);
        return ResponseEntity.status(200).body(new ApiResponse("News Article published"));
    }

    //6. Get all Published NewsArticles.

    @GetMapping("/published")
    public ResponseEntity getPublishedNewsArticles() {
        ArrayList<NewsArticle> publishedArticles = newsArticleService.getPublishedNewsArticles();
        return ResponseEntity.status(200).body(publishedArticles);
    }
    // 7. Get NewsArticles by Category.
    @GetMapping("/category/{category}")
    public ResponseEntity getNewsArticlesByCategory(@PathVariable String category) {
        ArrayList<NewsArticle> articlesByCategory = newsArticleService.getNewsArticlesByCategory(category);
        return ResponseEntity.status(200).body(articlesByCategory);
    }}














