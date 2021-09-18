package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

public class TextBlockMapper implements ArticleBlockMapper{
    @Override
    public ArticleBlockDto map(ArticleBlock articleBlock) {
        TextBlock textBlock = (TextBlock) articleBlock;
        com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock textBlockDTO = new com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock();
        textBlockDTO.setText(textBlock.getText());
        textBlockDTO.setSortIndex(textBlock.getSortIndex());
        return textBlockDTO;
    }
}
