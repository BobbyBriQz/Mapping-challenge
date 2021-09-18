package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ArticleMapper {

    private ArticleBlockListMapper articleBlockListMapperMapper;

    @Autowired
    public void setArticleBlockListMapper(ArticleBlockListMapper articleBlockMapper) {
        this.articleBlockListMapperMapper = articleBlockMapper;
    }

    public ArticleDto map(Article article) {

        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setTitle(article.getTitle());
        articleDto.setAuthor(article.getAuthor());
        articleDto.setDescription(article.getDescription());
        articleDto.setBlocks(articleBlockListMapperMapper.mapBlocks(article.getBlocks()));
        return articleDto;
    }

    public Article map(ArticleDto articleDto) {
        // Nicht Teil dieser Challenge.
        return new Article();
    }
}