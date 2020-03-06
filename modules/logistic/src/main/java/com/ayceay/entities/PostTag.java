package com.ayceay.entities;

import com.ayceay.constants.LogisticsConstraints;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "PostTag")
@Table(name = "post_tag", schema = LogisticsConstraints.SCHEMA_NAME)
public class PostTag {

    @EmbeddedId
    private PostTagId id;


    @JsonBackReference("post")
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    private Post post;

    @JsonBackReference("tag")
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tagId")
    private Tag tag;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    public PostTag() {
    }

    public PostTag(Post post, Tag tag) {
        this.post = post;
        this.tag = tag;
        this.id = new PostTagId(post.getId(), tag.getId());
    }

    public PostTagId getId() {
        return id;
    }

    public void setId(PostTagId id) {
        this.id = id;
    }

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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PostTag that = (PostTag) o;
        return Objects.equals(post, that.post) &&
                Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post, tag);
    }
}