package com.feue.myblog.service.impl;

import com.feue.myblog.model.NewsInfoDO;
import com.feue.myblog.repository.NewsInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Feue
 * @create 2021-11-24 17:20
 */
@Service
public class NewsInfoServiceImpl {
    @Autowired
    private NewsInfoRepository newsInfoRepository;

    public NewsInfoDO getById(Long id) {
        return this.newsInfoRepository.getById(id);
    }
}
