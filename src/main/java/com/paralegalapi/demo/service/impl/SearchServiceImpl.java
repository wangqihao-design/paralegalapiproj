package com.paralegalapi.demo.service.impl;

import com.paralegalapi.demo.DAO.ArticleMapper;
import com.paralegalapi.demo.Enums.ResultEnum;
import com.paralegalapi.demo.domain.Passage;
import com.paralegalapi.demo.domain.Result;
import com.paralegalapi.demo.service.SearchService;
import com.paralegalapi.demo.utils.ResultUtil;

public class SearchServiceImpl implements SearchService{


    @Override
    public Result addArticle(Passage Article) {
        ArticleMapper articleMapper = new ArticleMapper();

        articleMapper.addPassage(Article);
        return ResultUtil.success(ResultEnum.SUCCESS, Article);
    }

    @Override
    public Result delArticle(String title) {
        ArticleMapper articleMapper = new ArticleMapper();

        articleMapper.delPassage(title);
        return ResultUtil.success(ResultEnum.SUCCESS, title);
    }

    @Override
    public Passage getPassage(String title) {
        ArticleMapper articleMapper = new ArticleMapper();

        return articleMapper.getPassage(title);
    }
}
