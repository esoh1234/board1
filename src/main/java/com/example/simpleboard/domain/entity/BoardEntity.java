package com.example.simpleboard.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

//Mapping btw contents(will be a data of db) and Object

@ApiModel(value="BoardDto : 게시글 Entity", description="게시글 Entity")
@NoArgsConstructor(access = AccessLevel.PROTECTED) //Only I access
@Getter
@Entity
@Table(name="board")
public class BoardEntity extends TimeEntity{
    @ApiModelProperty(value="게시글 번호")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Crieteria of key
    private Long id;

    @ApiModelProperty(value="게시글 제목")
    @Column(columnDefinition ="TEXT") //Column mapping
    private String title;

    @ApiModelProperty(value="게시글 작성자")
    @Column(columnDefinition = "TEXT")
    private String author;

    @ApiModelProperty(value="게시글 내용")
    @Column(columnDefinition = "TEXT")
    private String content;

//    @Column(columnDefinition = "number")
//    private Long postviews;

    @Builder
    public BoardEntity(Long id, String title, String author, String content){
        this.id=id;
        this.title=title;
        this.author=author;
        this.content=content;
    }

}
