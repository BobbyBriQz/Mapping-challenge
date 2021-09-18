package com.mhp.coding.challenges.mapping.mappers;


import com.mhp.coding.challenges.mapping.models.db.blocks.*;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SortedArticleBlockListMapper implements ArticleBlockListMapper{

    private ArticleBlockMapperFactory mapperFactory;

    @Autowired
    public void setArticleBlockMapperFactory(ArticleBlockMapperFactory factory) {
        this.mapperFactory = factory;
    }


    public ArticleBlockDto map(ArticleBlock articleBlock){

        ArticleBlockType type = mapperFactory.getBlockType(articleBlock);
        ArticleBlockMapper mapper = mapperFactory.getMapper(type);
        return mapper.map(articleBlock);
    }

    @Override
    public List<ArticleBlockDto> mapBlocks(Collection<ArticleBlock> articleBlocks){
        return articleBlocks.stream()
                .sorted(Comparator.comparingInt(ArticleBlock::getSortIndex))
                .map(this::map).collect(Collectors.toList());
    }
}
