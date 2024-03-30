package com.mx.article.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mx.article.mapper.ApArticleMapper;
import com.mx.article.service.ApArticleService;
import com.mx.common.constants.ArticleConstants;
import com.mx.model.article.dtos.ArticleHomeDto;
import com.mx.model.article.pojos.ApArticle;
import com.mx.model.common.dtos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
@Transactional
@Slf4j
public class ApArticleServiceImpl extends ServiceImpl<ApArticleMapper,ApArticle> implements ApArticleService{


    private static final int MAX_PAGE_SIZE = 50;
    @Autowired
    private ApArticleMapper apArticleMapper;
    /**
     * 加载文章列表
     * @param dto
     * @param type 1加载更多  2 加载最新
     * @return
     */
    public ResponseResult load(ArticleHomeDto dto, Short type) {
        //1. 校验参数
        //分条页数校验
        Integer size = dto.getSize();
        if(size == null || size == 0){
            size = 10;
        }
        size = Math.min(size,MAX_PAGE_SIZE);
        //校验参数  -->type
        if(!type.equals(ArticleConstants.LOADTYPE_LOAD_MORE)&&!type.equals(ArticleConstants.LOADTYPE_LOAD_NEW)){
            type = ArticleConstants.LOADTYPE_LOAD_MORE;
        }

        //频道参数校验
        if(StringUtils.isBlank(dto.getTag())){
            dto.setTag(ArticleConstants.DEFAULT_TAG);
        }
        //时间校验
        if(dto.getMaxBehotTime() == null){
            dto.setMaxBehotTime(new Date());
        }
        if(dto.getMinBehotTime() == null){
            dto.setMinBehotTime(new Date());
        }
        //2.查询
        List<ApArticle> apArticles = apArticleMapper.loadArticleList(dto, type);
        //3.返回
        return ResponseResult.okResult(apArticles);
    }

}
