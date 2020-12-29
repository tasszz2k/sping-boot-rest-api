package com.bananleafnewspaper.service.base;

import com.bananleafnewspaper.dto.NewsDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

public interface INewsService {
    List<NewsDTO> getAll();
    NewsDTO save(NewsDTO newsDTO);
//    NewsDTO update(NewsDTO newsDTO);
    void delete(long[] ids);
}
