package com.ayceay.controller;

import com.ayceay.dto.PostTagDTO;
import com.ayceay.entities.Post;
import com.ayceay.entities.Tag;
import com.ayceay.repo.PostRepository;
import com.ayceay.repo.TagRepository;
import com.ayceay.services.PublicServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PublicServicePostController implements PublicServicePost {

    PostRepository postRepository;
    TagRepository tagRepository;

    @Autowired
    public PublicServicePostController(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }


    @Override
    @PostMapping("/savepost")
    public Post savePost(@RequestBody @Valid PostTagDTO posttag) {
        Optional<Tag> tagOpt = tagRepository.findById(posttag.getTag().getId());
        Tag tagTemp = null;
        if (tagOpt.isPresent()) {
            tagTemp = tagOpt.get();
        }
        posttag.getPost().setId(1L);
        posttag.getPost().addTag(tagTemp);
        return postRepository.save(posttag.getPost());
    }

    @Override
    @PostMapping("/addtag")
    public Post savePostWithTag(Post post, Tag tag) {
        post.addTag(tag);
        return postRepository.save(post);
    }

}
