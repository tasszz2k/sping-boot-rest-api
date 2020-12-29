package com.bananleafnewspaper.api;

import com.bananleafnewspaper.service.base.INewsService;
import com.bananleafnewspaper.dto.NewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController = @Controller + @ResponseBody
@RestController
@CrossOrigin
public class NewsAPI {

    @Autowired
    private INewsService newsService;

    @GetMapping(value = "/news")
    public List<NewsDTO> getAllNews() {
        return newsService.getAll();
    }

    //@PostMapping = @RequestMapping + method
    @PostMapping(value = "/news")
    public NewsDTO createNews(@RequestBody NewsDTO model) {
        return newsService.save(model);
    }

    @PutMapping(value = "/news/{id}")
    public NewsDTO updateNews(@RequestBody NewsDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return newsService.save(model);
    }

    @DeleteMapping(value = "/news")
    public String deleteNews(@RequestBody long[] ids) {
        newsService.delete(ids);
        return "DELETE";
    }
}