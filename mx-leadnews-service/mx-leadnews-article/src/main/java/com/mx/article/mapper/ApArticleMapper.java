package com.mx.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mx.model.article.dtos.ArticleHomeDto;
import com.mx.model.article.pojos.ApArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ApArticleMapper extends BaseMapper<ApArticle> {

    public List<ApArticle> loadArticleList(@Param("dto") ArticleHomeDto dto,@Param("type") short type);



}
