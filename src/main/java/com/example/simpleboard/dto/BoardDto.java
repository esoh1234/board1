package com.example.simpleboard.dto;

import java.time.LocalDateTime;

import com.example.simpleboard.domain.entity.BoardEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    @JsonFormat(pattern="yyyy년MM월dd일 HH시mm분")
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // 4

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .id(id)
                .title(title)
                .author(author)
                .content(content)
                .build();
    }

    @Builder
    public BoardDto(Long id, String title, String author, String content, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id=id;
        this.author=author;
        this.title=title;
        this.content=content;
        this.createdDate=createdDate;
        this.modifiedDate=modifiedDate;
    }
}
