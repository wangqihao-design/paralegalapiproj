package com.paralegalapi.demo.service;

import com.paralegalapi.demo.domain.Passage;
import com.paralegalapi.demo.domain.Result;


public interface SearchService {
    Result addArticle(Passage Article);
    Result delArticle(String title);

    Passage getPassage(String title);

}
