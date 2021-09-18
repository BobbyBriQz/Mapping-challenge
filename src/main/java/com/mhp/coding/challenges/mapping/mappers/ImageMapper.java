package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public ImageDto map(Image image){
        if(image == null) return null;

        ImageDto imageDto = new ImageDto();
        imageDto.setId(image.getId());
        imageDto.setUrl(image.getUrl());
        imageDto.setImageSize(image.getImageSize());

        return imageDto;
    }
}
