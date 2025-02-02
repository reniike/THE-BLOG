package com.example.blog.models;

import com.example.blog.enums.PostStatus;
import com.example.blog.enums.Verified;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post extends IdEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

   @ManyToOne
   @JoinColumn(name = "category_id", nullable = false)
    private Category category;

   @Column(nullable = false)
   @Enumerated(EnumType.STRING)
   private PostStatus status;

   @Column(nullable = false)
   @Enumerated(EnumType.STRING)
   private Verified verified;

   @Column(nullable = false)
   private Integer readingTime;

    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    private LocalDateTime postedOn;

    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
