package com.bananleafnewspaper.api;

import com.bananleafnewspaper.dto.NewsDTO;
import org.springframework.web.bind.annotation.*;

//@RestController = @Controller + @ResponseBody
@RestController
public class NewsAPI {

    //@PostMapping = @RequestMapping + method
    @PostMapping(value = "/news")
    public NewsDTO createNew(@RequestBody NewsDTO model) {
        return model;
    }

    @PutMapping(value = "/news")
    public NewsDTO updateNews(@RequestBody NewsDTO model) {
        return model;
    }

    @DeleteMapping(value = "/news")
    public String deleteNews(@RequestBody int[] ids) {
        //
        return "DELETE";
    }
}