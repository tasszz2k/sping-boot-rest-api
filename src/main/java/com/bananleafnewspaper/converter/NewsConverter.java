package com.bananleafnewspaper.converter;

import com.bananleafnewspaper.dto.NewsDTO;
import com.bananleafnewspaper.entity.NewsEntity;
import org.springframework.stereotype.Component;

@Component
public class NewsConverter {
    public NewsEntity toEntity(NewsDTO dto) {
        NewsEntity entity = new NewsEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }

    public NewsDTO toDTO(NewsEntity entity) {
        NewsDTO dto = new NewsDTO();
        if(entity.getId() != null){
            dto.setId(entity.getId());
        }
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setShortDescription(entity.getShortDescription());
        dto.setThumbnail(entity.getThumbnail());
        dto.setCreatedBy(entity.getCreateBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }

    public NewsEntity toEntity(NewsDTO dto, NewsEntity entity) {
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }
}
