package com.cherr.mov.member;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String username;
    private LocalDateTime createdDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .username(username)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String name, String nickname, String rrn, String gender, String phone, LocalDateTime createdDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.createdDate = createdDate;
    }
}
