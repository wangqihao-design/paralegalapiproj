package com.paralegalapi.demo.DAO;

import com.paralegalapi.demo.Enums.ResultEnum;
import com.paralegalapi.demo.domain.Passage;
import com.paralegalapi.demo.domain.Result;
import com.paralegalapi.demo.domain.User;
import com.paralegalapi.demo.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArticleMapper {
    /* 添加一个文章
     */

    public Result addPassage(Passage passage){

        Jedis jedis = new JedisPool().getResource();
        Logger.getLogger(getClass()).info("Added Passage titled" + passage.getTitle());

        List passageinfo = new ArrayList<String>();

        // [title, ArguedDate, DeterminedDate, Content]
        passageinfo.add(passage.getTitle());
        passageinfo.add(passage.getArguedDate());
        passageinfo.add(passage.getDeterminedDate());
        passageinfo.add(passage.getContent());


        Gson gson = new Gson();
        String JsonPassageinfo = gson.toJson(passageinfo);
        jedis.set("Passage:" + passage.getTitle(), JsonPassageinfo);
        return ResultUtil.success(ResultEnum.SUCCESS, passage);
    }

    /*删除一个文章*/


    public Result delPassage(String title){
        Jedis jedis = new JedisPool().getResource();
        Logger.getLogger(getClass()).info("Del passage titled" + title);
        jedis.del("Passage:"+title);
        return ResultUtil.success(ResultEnum.SUCCESS, title);
    }

    /*获取一个文章*/

    public Passage getPassage(String title){
        Jedis jedis = new JedisPool().getResource();
        Passage passage = new Passage();

        passage.setTitle(title);

        String passageContent = jedis.get("Passage:"+title);

        String ContentString = passageContent.substring(1, passageContent.length()-1);

        String[] ContentArray = ContentString.split(",");

        System.out.println(Arrays.toString(ContentArray));

        String PassageTitle = ContentArray[0].replaceAll("\"", "");
        String PassageContent = ContentArray[3].replaceAll("\"", "");
        int ArgueDate = Integer.parseInt(ContentArray[1]);
        int DetermineDate = Integer.parseInt(ContentArray[2]);


        passage.setTitle(PassageTitle);
        passage.setContent(PassageContent);
        passage.setArguedDate(ArgueDate);
        passage.setDeterminedDate(DetermineDate);

        return passage;
    }
}
