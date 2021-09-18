package com.mhp.coding.challenges.mapping;

import com.mhp.coding.challenges.mapping.mappers.*;
import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.db.ImageSize;
import com.mhp.coding.challenges.mapping.models.db.blocks.*;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class ArticleMapperTest {

    ArticleMapper articleMapper;
    SortedArticleBlockListMapper articleBlockListMapper;
    ArticleBlockMapperFactory articleBlockMapperFactory;
    ImageMapper imageMapper;
    Article article;

    @Before
    public void setUp(){

        imageMapper = new ImageMapper();
        articleBlockMapperFactory = new ArticleBlockMapperFactory();
        articleBlockMapperFactory.setImageMapper(imageMapper);
        articleBlockListMapper = new SortedArticleBlockListMapper();
        articleBlockListMapper.setArticleBlockMapperFactory(articleBlockMapperFactory);
        articleMapper = new ArticleMapper();
        articleMapper.setArticleBlockListMapper(articleBlockListMapper);

        long id = 1001L;
        article = new Article();
        article.setId(id);
        article.setAuthor("Max Mustermann");
        article.setDescription("Article Description " + id);
        article.setTitle("Article Nr.: " + id);
        article.setLastModifiedBy("Hans Müller");
        article.setLastModified(new Date());

        final Set<ArticleBlock> result = new HashSet<>();

        final TextBlock textBlock = new TextBlock();
        textBlock.setText("Some Text for " + id);
        textBlock.setSortIndex(0);
        result.add(textBlock);

        final VideoBlock videoBlock = new VideoBlock();
        videoBlock.setType(VideoBlockType.YOUTUBE);
        videoBlock.setUrl("https://youtu.be/myvideo");
        videoBlock.setSortIndex(5);
        result.add(videoBlock);


        final Image image = new Image();
        image.setId(id);
        image.setLastModified(new Date());
        image.setLastModifiedBy("Max Mustermann");
        image.setImageSize(ImageSize.LARGE);
        image.setUrl("https://someurl.com/image/" + id);

        final ImageBlock imageBlock = new ImageBlock();
        imageBlock.setImage(image);
        textBlock.setSortIndex(1);
        result.add(imageBlock);

        final GalleryBlock galleryBlock = new GalleryBlock();
        final List<Image> galleryImages = new ArrayList<>();
        image.setId(2L);
        galleryImages.add(image);
        image.setId(3L);
        galleryImages.add(image);
        galleryImages.add(null);
        galleryBlock.setImages(galleryImages);
        result.add(galleryBlock);

        article.setBlocks(result);

    }

    @Test
    @DisplayName("Test to verify that Article was correctly mapped to ArticleDTO")
    public void testArticleMapper(){

        ArticleDto articleDto = articleMapper.map(article);

        assertEquals(article.getId(), articleDto.getId());
        assertEquals(article.getAuthor(), articleDto.getAuthor());
        assertEquals(article.getTitle(), articleDto.getTitle());
        assertEquals(article.getDescription(), articleDto.getDescription());
        assertEquals(article.getBlocks().size(), articleDto.getBlocks().size());
    }

    @Test
    @DisplayName("Test to verify that Sort Index was used to sort collection of Blocks")
    public void testArticleBlocksSortOrder(){

        ArticleDto articleDto = articleMapper.map(article);

        List<ArticleBlockDto> blocks = new ArrayList<>(articleDto.getBlocks());
        for(int i = 1; i < blocks.size(); i++){
            assertTrue(blocks.get(i-1).getSortIndex() <= blocks.get(i).getSortIndex());
        }
    }
}
