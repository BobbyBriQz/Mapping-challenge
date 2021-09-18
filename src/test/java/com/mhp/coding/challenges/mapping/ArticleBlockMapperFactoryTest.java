package com.mhp.coding.challenges.mapping;


import com.mhp.coding.challenges.mapping.mappers.*;
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.ImageBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlock;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleBlockMapperFactoryTest {

    @Test
    public void testGetMapperMethod(){

        ImageMapper imageMapper = new ImageMapper();
        ArticleBlockMapperFactory mapperFactory = new ArticleBlockMapperFactory();
        mapperFactory.setImageMapper(imageMapper);

        assertAll("Verifying that factory generates the right mapper",
                () -> assertEquals(GalleryBlockMapper.class, mapperFactory.getMapper(ArticleBlockType.GALLERY_BLOCK).getClass()),
                () -> assertEquals(ImageBlockMapper.class, mapperFactory.getMapper(ArticleBlockType.IMAGE_BLOCK).getClass()),
                () -> assertEquals(TextBlockMapper.class, mapperFactory.getMapper(ArticleBlockType.TEXT_BLOCK).getClass()),
                () -> assertEquals(VideoBlockMapper.class, mapperFactory.getMapper(ArticleBlockType.VIDEO_BLOCK).getClass())
        );
    }

    @Test
    public void testGetArticleBlockType(){

        ImageMapper imageMapper = new ImageMapper();
        ArticleBlockMapperFactory mapperFactory = new ArticleBlockMapperFactory();
        mapperFactory.setImageMapper(imageMapper);

        final ImageBlock imageBlock = new ImageBlock();
        final TextBlock textBlock = new TextBlock();
        final GalleryBlock galleryBlock = new GalleryBlock();
        final VideoBlock videoBlock = new VideoBlock();

        assertAll("Verifying algorithm that detects block type",
                () -> assertEquals(ArticleBlockType.GALLERY_BLOCK, mapperFactory.getBlockType(galleryBlock)),
                () -> assertEquals(ArticleBlockType.IMAGE_BLOCK, mapperFactory.getBlockType(imageBlock)),
                () -> assertEquals(ArticleBlockType.TEXT_BLOCK, mapperFactory.getBlockType(textBlock)),
                () -> assertEquals(ArticleBlockType.VIDEO_BLOCK, mapperFactory.getBlockType(videoBlock))
        );
    }
}
