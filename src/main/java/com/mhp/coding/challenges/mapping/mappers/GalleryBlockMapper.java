package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;

import java.util.List;
import java.util.stream.Collectors;

public class GalleryBlockMapper implements ArticleBlockMapper{

    private final ImageMapper imageMapper;
    public GalleryBlockMapper(ImageMapper imageMapper){
        this.imageMapper = imageMapper;
    }

    @Override
    public ArticleBlockDto map(ArticleBlock articleBlock) {
        GalleryBlockDto galleryBlockDto = new GalleryBlockDto();
        List<ImageDto> imageDtos = ((GalleryBlock) articleBlock).getImages()
                .stream()
                .map(imageMapper::map)
                .collect(Collectors.toList());
        galleryBlockDto.setImages(imageDtos);
        galleryBlockDto.setSortIndex(articleBlock.getSortIndex());
        return galleryBlockDto;
    }
}
