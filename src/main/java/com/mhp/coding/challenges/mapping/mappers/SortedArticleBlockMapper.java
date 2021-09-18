package com.mhp.coding.challenges.mapping.mappers;


import com.mhp.coding.challenges.mapping.exceptions.ArticleServiceException;
import com.mhp.coding.challenges.mapping.models.db.blocks.*;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SortedArticleBlockMapper implements ArticleBlockMapper{

    private Logger logger = LoggerFactory.getLogger(SortedArticleBlockMapper.class);

    private ImageMapper imageMapper;

    @Autowired
    public void setImageMapper(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Override
    public ArticleBlockDto map(ArticleBlock articleBlock){


        if(articleBlock instanceof GalleryBlock){

            GalleryBlockMapper galleryBlockMapper = new GalleryBlockMapper(this.imageMapper);
            return galleryBlockMapper.map(articleBlock);
        }else if(articleBlock instanceof ImageBlock){

            ImageBlockMapper imageBlockMapper = new ImageBlockMapper(this.imageMapper);
            return imageBlockMapper.map(articleBlock);
        }else if(articleBlock instanceof TextBlock){

            TextBlockMapper textBlockMapper = new TextBlockMapper();
            return textBlockMapper.map(articleBlock);
        }else if(articleBlock instanceof VideoBlock){

            VideoBlockMapper videoBlockMapper = new VideoBlockMapper();
            return videoBlockMapper.map(articleBlock);
        }

        throw new ArticleServiceException("Strategy Not Implemented.");
    }

    @Override
    public List<ArticleBlockDto> mapBlocks(Collection<ArticleBlock> articleBlocks){
        return articleBlocks.stream()
                .sorted(Comparator.comparingInt(ArticleBlock::getSortIndex))
                .map(this::map).collect(Collectors.toList());
    }
}
