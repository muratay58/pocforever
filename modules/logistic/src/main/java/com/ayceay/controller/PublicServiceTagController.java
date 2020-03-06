package com.ayceay.controller;

import com.ayceay.entities.Tag;
import com.ayceay.repo.TagRepository;
import com.ayceay.services.PublicServiceTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PublicServiceTagController implements PublicServiceTag {

    TagRepository tagRepository;

    @Autowired
    public PublicServiceTagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    @RequestMapping("savetag")
    public Tag saveTag(@RequestBody @Valid Tag tag) {
        return tagRepository.save(tag);
    }
}
