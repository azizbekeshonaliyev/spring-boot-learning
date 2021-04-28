package com.example.test.tag;

import org.apache.juli.logging.Log;
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

    @GetMapping(path = "/{id}")
    public Tag show(@PathVariable Long id){
        return tagService.get(id);
    }

    @PutMapping(path = "{id}")
    public void update(@RequestBody Tag tag, @PathVariable Long id){
        tagService.update(tag,id);
    }

    @DeleteMapping(path = "{id}")
    public void destroy(@PathVariable Long id){
        tagService.delete(id);
    }
}
