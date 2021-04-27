package com.example.test.tag;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    public final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public void create(Tag tag){
        System.out.println(tag);
        tagRepository.save(tag);
    }
}
