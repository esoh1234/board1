package com.example.simpleboard.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
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

    @Column(columnDefinition ="integer default 0")
    private Long updateViews = 0L;

//    @Column(columnDefinition = "number")
//    private Long postviews;

    @PrePersist //영속되기전
    public void prePersist() {
        this.updateViews = this.updateViews == null ? 0 : this.updateViews;
    }

    @Builder
    public BoardEntity(Long id, String title, String author, String content,Long updateViews){
        this.id=id;
        this.title=title;
        this.author=author;
        this.content=content;
        this.updateViews=updateViews;
    }

}
