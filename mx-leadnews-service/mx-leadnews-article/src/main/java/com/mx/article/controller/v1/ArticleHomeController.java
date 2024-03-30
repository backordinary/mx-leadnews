package com.mx.article.controller.v1;

import com.mx.article.service.ApArticleService;
import com.mx.common.constants.ArticleConstants;
import com.mx.model.article.dtos.ArticleHomeDto;
import com.mx.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/article")
public class ArticleHomeController {

    @Autowired
    private ApArticleService apArticleService;
    /**
     * 加载首页
     * @param dto
     * @return
     */
    @PostMapping("/load")
    public ResponseResult load(@RequestBody ArticleHomeDto dto){

        return apArticleService.load(dto, ArticleConstants.LOADTYPE_LOAD_MORE);
    }

    /**
     * 加载更多
     * @param dto
     * @return
     */
    @PostMapping("/loadmore")
    public ResponseResult loadmore(@RequestBody ArticleHomeDto dto){

        return apArticleService.load(dto, ArticleConstants.LOADTYPE_LOAD_MORE);
    }



    /**
     * 加载最新 
     * @param dto
     * @return
     */
    @PostMapping("/loadnew")
    public ResponseResult loadnew(@RequestBody ArticleHomeDto dto){

        return apArticleService.load(dto, ArticleConstants.LOADTYPE_LOAD_NEW);
    }
}
