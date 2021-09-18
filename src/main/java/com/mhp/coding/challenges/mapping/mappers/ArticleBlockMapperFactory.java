package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.exceptions.ArticleServiceException;
import com.mhp.coding.challenges.mapping.models.db.blocks.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleBlockMapperFactory {

    private ImageMapper imageMapper;

    @Autowired
    public void setImageMapper(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    public ArticleBlockType getBlockType(ArticleBlock articleBlock){
        if(articleBlock instanceof GalleryBlock){

            return ArticleBlockType.GALLERY_BLOCK;
        }else if(articleBlock instanceof ImageBlock){

            return ArticleBlockType.IMAGE_BLOCK;
        }else if(articleBlock instanceof TextBlock){

            return ArticleBlockType.TEXT_BLOCK;
        }else if(articleBlock instanceof VideoBlock){

           return ArticleBlockType.VIDEO_BLOCK;
        }

        throw new ArticleServiceException("Strategy Not Implemented.");
    }

    public ArticleBlockMapper getMapper(ArticleBlockType type){

        switch (type){
            case GALLERY_BLOCK:
                return new GalleryBlockMapper(imageMapper);
            case IMAGE_BLOCK:
                return new ImageBlockMapper(imageMapper);
            case TEXT_BLOCK:
                return new TextBlockMapper();
            case VIDEO_BLOCK:
                return new VideoBlockMapper();
            default:
                throw new ArticleServiceException("Strategy Not Implemented.");
        }
    }
}
