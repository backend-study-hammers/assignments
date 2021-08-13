package com.cherr.mov.domain.posts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostRepository postRepository;

    @Transactional
    public List<PostsDto> getBoardlist(){
        List<PostsEntity> postsEntities = postRepository.findAll();
        List<PostsDto> postsDtoList = new ArrayList<>();

        for(PostsEntity postsEntity : postsEntities){
            PostsDto postsDto = PostsDto.builder()
                    .id(postsEntity.getId())
                    .name(postsEntity.getName())
                    .content(postsEntity.getContent())
                    .title(postsEntity.getTitle())
                    .createdDate(postsEntity.getCreatedDate())
                    .build();
            postsDtoList.add(postsDto);
        }
        return postsDtoList;
    }

    @Transactional
    public PostsDto getPost(Long id){
        Optional<PostsEntity> postsEntityWrapper = postRepository.findById(id);
        PostsEntity postsEntity = postsEntityWrapper.get();

        PostsDto postsDto = PostsDto.builder()
                .id(postsEntity.getId())
                .name(postsEntity.getName())
                .content(postsEntity.getContent())
                .title(postsEntity.getTitle())
                .createdDate(postsEntity.getCreatedDate())
                .build();

        return postsDto;
    }

    @Transactional
    public Long savePost(PostsDto postsDto){
        return postRepository.save(postsDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
