//package com.example.simpleboard.domain.entity;
//
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.*;
//
////Mapping btw contents(will be a data of db) and Object
//@NoArgsConstructor(access = AccessLevel.PROTECTED) //Only I access
//@Getter
//@Entity
//@Table(name="member")
//public class MemberEntity{
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY) //Crieteria of key
//    private Long id;
//
//    @Column(columnDefinition ="TEXT", nullable = false) //Column mapping
//    private String memberID;
//
//    @Column(columnDefinition ="TEXT", nullable = false) //Column mapping
//    private String memberName;
//
//    @Column(columnDefinition = "TEXT")
//    private String password;
//
//
//    @Builder
//    public MemberEntity(Long id, String memberID, String memberName, String password){
//        this.id=id;
//        this.memberID=memberID;
//        this.memberName=memberName;
//        this.password=password;
//    }
//
//}
