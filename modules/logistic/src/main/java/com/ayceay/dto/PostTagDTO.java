package com.ayceay.dto;

import com.ayceay.entities.Post;
import com.ayceay.entities.Tag;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;

public class PostTagDTO implements Serializable {

    @JsonManagedReference("post")
    private transient Post post;

    @JsonManagedReference("tag")
    private transient Tag tag;


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
