package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

import java.util.Collection;
import java.util.List;

public interface ArticleBlockListMapper {

     List<ArticleBlockDto> mapBlocks(Collection<ArticleBlock> articleBlocks);
}
