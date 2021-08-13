package com.cherr.mov.domain.posts;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostsDto {

    private Long id;
    private String name;
    private String content;
    private String title;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public PostsEntity toEntity(){
        PostsEntity postsEntity = PostsEntity.builder()
                .id(id)
                .name(name)
                .content(content)
                .title(title)
                .build();
        return postsEntity;

    }

    @Builder
    public PostsDto(Long id, String name, String content, String title, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.title = title;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
