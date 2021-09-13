package com.example.simpleboard.dto;

import java.time.LocalDateTime;

import com.example.simpleboard.domain.entity.BoardEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@ApiModel(value="BoardDto : 게시글 DTO", description="게시글 DTO")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    @ApiModelProperty(value="게시글 번호")
    private Long id;
    @ApiModelProperty(value="게시글 제목")
    private String title;
    @ApiModelProperty(value="게시글 작성자")
    private String author;
    @ApiModelProperty(value="게시글 내용")
    private String content;
    @ApiModelProperty(value="작성 시간")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime createdDate;
    @ApiModelProperty(value="수정 시간")
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
