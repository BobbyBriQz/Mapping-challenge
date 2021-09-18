package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.ImageBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

public class ImageBlockMapper implements ArticleBlockMapper{
    private final ImageMapper imageMapper;

    public ImageBlockMapper(ImageMapper imageMapper){
        this.imageMapper = imageMapper;
    }

    @Override
    public ArticleBlockDto map(ArticleBlock articleBlock) {
        ImageBlock imageBlock = ((ImageBlock) articleBlock);
        com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock imageBlockDTO = new com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock();
        imageBlockDTO.setImage(imageMapper.map(imageBlock.getImage()));
        imageBlockDTO.setSortIndex(imageBlock.getSortIndex());
        return imageBlockDTO;
    }
}
