package com.example.blog.data.models;

import com.example.blog.data.enums.PostStatus;
import com.example.blog.data.enums.Verified;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
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

   @ManyToOne(fetch = FetchType.LAZY)
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
    private Set<Tag> tags = new HashSet<>();

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime postedOn;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
