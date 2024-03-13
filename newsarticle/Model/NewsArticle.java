package com.example.newsarticle.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotNull(message = "Id cannot be null")
    private Integer id;

    @NotNull(message = "Title cannot be null")
    @Size(max = 100,message = " Title maximum length of 100 characters.")
    private String  title;


    @NotNull(message = "Author can not be null")
    @Size(max = 20,min = 5,message = "Author must be more than 4 characters and maximum length of 20 characters")
    private String author;

    @NotNull(message = "Content cannot be null:")
    @Size(min = 201,message = " Content must be more than 200 characters.")
    private String content;


    @NotNull(message = "Category can not be null")
    @Pattern(regexp = "^(politics|sports|technology)$")
    //Must be either "politics", " sports" or " technology" only.

    private String category;


    @NotNull(message = "Image url can not be null")
    private String imageUrl;

    //Must be by default false.
    private boolean isPublished=false;

    private LocalDate publishDate;









}
