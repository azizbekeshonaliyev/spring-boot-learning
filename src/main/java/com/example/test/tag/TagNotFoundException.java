package com.example.test.tag;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(Long id) {
        super("Could not find tag " + id);
    }
}
