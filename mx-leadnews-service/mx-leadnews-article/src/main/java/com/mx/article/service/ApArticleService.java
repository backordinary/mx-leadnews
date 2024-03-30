package com.mx.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mx.model.article.dtos.ArticleHomeDto;
import com.mx.model.article.pojos.ApArticle;
import com.mx.model.common.dtos.ResponseResult;

public interface ApArticleService extends IService<ApArticle> {
    /**
     * 加载文章列表
     * @param dto
     * @param type  1加载更多  2加载最新
     * @return
     */
    ResponseResult load(ArticleHomeDto dto,Short type);

}
