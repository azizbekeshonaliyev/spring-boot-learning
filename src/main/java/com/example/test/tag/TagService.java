package com.example.test.tag;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        tagRepository.save(tag);
    }

    public Tag get(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new TagNotFoundException(id));
    }

    public void update(Tag tag, Long id) {
        tagRepository.findById(id)
                .map(item -> {
                    item.setName(tag.getName());
                    return tagRepository.save(item);
                })
                .orElseThrow(
                        () -> new TagNotFoundException(id)
                );
    }

    public void delete(Long id) {
        tagRepository.deleteById(id);
    }
}
