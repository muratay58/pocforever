package com.ayceay.services;

import com.ayceay.dto.PostTagDTO;
import com.ayceay.entities.Post;
import com.ayceay.entities.Tag;

public interface PublicServicePost {

    public Post savePost(PostTagDTO post);

    public Post savePostWithTag(Post post, Tag tag);
}
