package com.example.simpleboard.dto;

import java.time.LocalDateTime;

import com.example.simpleboard.domain.entity.BoardEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter@Setter@ToString@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

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
