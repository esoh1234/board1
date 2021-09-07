package com.example.simpleboard.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

//Mapping btw contents(will be a data of db) and Object
@NoArgsConstructor(access = AccessLevel.PROTECTED) //Only I access
@Getter
@Entity
@Table(name="board")
public class BoardEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Crieteria of key
    private Long id;

    @Column(columnDefinition ="TEXT") //Column mapping
    private String title;

    @Column(columnDefinition = "TEXT")
    private String author;

    @Column(columnDefinition = "TEXT")
    private String content;


    @Builder
    public BoardEntity(Long id, String title, String author, String content){
        this.id=id;
        this.title=title;
        this.author=author;
        this.content=content;
    }

}
