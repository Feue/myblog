package com.feue.myblog.api.v1;

import com.feue.myblog.model.NewsInfoDO;
import com.feue.myblog.service.NewsBoxService;
import com.feue.myblog.service.NewsInfoService;
import com.feue.myblog.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Feue
 * @create 2021-11-24 17:36
 */
@RestController
@RequestMapping(value = "v1/news")
public class NewsController {
//    @Autowired
//    private NewsInfoService newsInfoService;
//    @Autowired
//    private NewsBoxService newsBoxService;

    @RequestMapping(value = "receiver/id/{receiverId}")
    public UnifyResponse<List<NewsInfoDO>> getAllByReceiverId(@PathVariable Long receiverId) {
        return null;
    }
}
