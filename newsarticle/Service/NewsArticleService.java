package com.example.newsarticle.Service;

import com.example.newsarticle.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service

public class NewsArticleService {

    ArrayList<NewsArticle> newsArticles=new ArrayList<>();


    public ArrayList<NewsArticle>getNewsArticle(){
        return newsArticles;
    }


    public void addNewsArticle(NewsArticle newsArticle){
        newsArticles.add(newsArticle);
    }

    public boolean updateNewsArticle(int id, NewsArticle newsArticle) {
        for (int i = 0; i < newsArticles.size(); i++) {
            if (newsArticles.get(i).getId() == id) {
                newsArticles.set(i, newsArticle);
                return true;

            }
        }
        return false;
    }


    public boolean deleteNewsArticle(int id){
        for (int i=0; i<newsArticles.size();i++){
            if(newsArticles.get(i).getId()==id){
                newsArticles.remove(i);
                return true;
            }
        }
        return false;
    }



    public void publishNewsArticle(int id) {
        for (NewsArticle article : newsArticles) {
            if (article.getId() == id) {
                article.setPublished(true);
                article.setPublishDate(LocalDate.now());
                break;
            }
        }
    }

    public ArrayList<NewsArticle> getPublishedNewsArticles() {
        ArrayList<NewsArticle> publishedArticles = new ArrayList<>();
        newsArticles.forEach(article -> {
            if (article.isPublished()) {
                publishedArticles.add(article);
            }
        });
        return publishedArticles;
    }

    public ArrayList<NewsArticle> getNewsArticlesByCategory(String category) {
        ArrayList<NewsArticle> articlesByCategory = new ArrayList<>();
        newsArticles.forEach(article -> {
            if (article.getCategory().equalsIgnoreCase(category)) {
                articlesByCategory.add(article);
            }
        });
        return articlesByCategory;
    }
}














