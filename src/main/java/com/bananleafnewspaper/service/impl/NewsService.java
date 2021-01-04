package com.bananleafnewspaper.service.impl;

import com.bananleafnewspaper.converter.NewsConverter;
import com.bananleafnewspaper.dto.NewsDTO;
import com.bananleafnewspaper.entity.CategoryEntity;
import com.bananleafnewspaper.entity.NewsEntity;
import com.bananleafnewspaper.repository.CategoryRepository;
import com.bananleafnewspaper.repository.NewsRepository;
import com.bananleafnewspaper.service.base.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService implements INewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewsConverter newsConverter;

    @Override
    public List<NewsDTO> getAll() {
        List<NewsEntity> newsEntities = newsRepository.findAll();
        List<NewsDTO> newsDTOs = new ArrayList<>();
        for (NewsEntity newsEntity:newsEntities) {
            newsDTOs.add(newsConverter.toDTO(newsEntity));
        }
        return newsDTOs;
    }

    @Override
    public NewsDTO save(NewsDTO newsDTO) {
        NewsEntity newsEntity = new NewsEntity();
        if (newsDTO.getId() != null) {
            //newsEnity.Id != null --> update
            NewsEntity oldNewsEntity = newsRepository.findById(newsDTO.getId()).orElse(null);
            newsEntity = newsConverter.toEntity(newsDTO, oldNewsEntity);
        } else {
            //newsEnity.Id == null --> insert
            newsEntity = newsConverter.toEntity(newsDTO);
        }

        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
        newsEntity.setCategory(categoryEntity);
        //newsEnity.Id == null --> insert
        newsEntity = newsRepository.save(newsEntity);
        return newsConverter.toDTO(newsEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long id: ids){
            newsRepository.deleteById(id);
        }
    }

//    @Override
//    public NewsDTO update(NewsDTO newsDTO) {
//        NewsEntity oldNewsEntity = newsRepository.findById(newsDTO.getId()).orElse(null);
//        NewsEntity updateNewsEntity = newsConverter.toEntity(newsDTO, oldNewsEntity);
//
//        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
//        updateNewsEntity.setCategory(categoryEntity);
//        //newsEnity.Id != null --> update
//        updateNewsEntity = newsRepository.save(updateNewsEntity);
//        return newsConverter.toDTO(updateNewsEntity);
//    }
}
