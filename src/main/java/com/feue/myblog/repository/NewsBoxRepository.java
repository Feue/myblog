package com.feue.myblog.repository;

import com.feue.myblog.model.NewsBoxDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Feue
 * @create 2021-11-24 17:18
 */
public interface NewsBoxRepository extends JpaRepository<NewsBoxDO, Long> {
}
