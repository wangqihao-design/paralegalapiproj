package com.paralegalapi.demo.controller;


import com.paralegalapi.demo.Enums.ResultEnum;
import com.paralegalapi.demo.domain.Passage;
import com.paralegalapi.demo.domain.Result;
import com.paralegalapi.demo.service.SearchService;
import com.paralegalapi.demo.service.impl.SearchServiceImpl;
import com.paralegalapi.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class SearchController {
    @PostMapping("/addPassage")
    public Result addPassage(Passage passage){
        SearchService searchService = new SearchServiceImpl();
        searchService.addArticle(passage);
        return ResultUtil.success(ResultEnum.SUCCESS, passage);
    }

    @PostMapping("/delPassage")
    public Result delPassage(String title){
        SearchService searchService = new SearchServiceImpl();
        searchService.delArticle(title);
        return ResultUtil.success(ResultEnum.SUCCESS, title);
    }

    @PostMapping("/getPassage")
    public Result getPassage(String title){
        SearchService searchService = new SearchServiceImpl();
        return ResultUtil.success(ResultEnum.SUCCESS, searchService.getPassage(title));
    }

}
