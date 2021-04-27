package com.example.test.tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tags")
public class TagController {

    public final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> index(){
        return tagService.getAll();
    }

    @PostMapping
    public void store(@RequestBody Tag tag){
        tagService.create(tag);
    }
}
