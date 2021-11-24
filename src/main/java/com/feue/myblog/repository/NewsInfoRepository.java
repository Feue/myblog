package com.feue.myblog.repository;

import com.feue.myblog.model.NewsInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Feue
 * @create 2021-11-24 17:19
 */
public interface NewsInfoRepository extends JpaRepository<NewsInfoDO, Long> {

}
