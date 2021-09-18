package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

public class VideoBlockMapper implements ArticleBlockMapper{
    @Override
    public ArticleBlockDto map(ArticleBlock articleBlock) {
        VideoBlock videoBlock = (VideoBlock) articleBlock;

        com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock videoBlockDTO = new com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock();
        videoBlockDTO.setType(videoBlock.getType());
        videoBlockDTO.setUrl(videoBlock.getUrl());
        videoBlockDTO.setSortIndex(videoBlock.getSortIndex());
        return videoBlockDTO;
    }
}
