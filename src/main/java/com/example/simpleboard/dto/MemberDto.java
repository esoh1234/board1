//package com.example.simpleboard.dto;
//
//import com.example.simpleboard.domain.entity.BoardEntity;
//import com.example.simpleboard.domain.entity.MemberEntity;
//import lombok.*;
//
//import javax.persistence.Column;
//import java.time.LocalDateTime;
//
//@Getter @Setter @ToString @NoArgsConstructor
//public class MemberDto {
//    private Long id;
//    private String memberID;
//    private String memberName;
//    private String password;
//    private LocalDateTime createdDate;
//    private LocalDateTime modifiedDate;
//
//    public MemberEntity toEntity(){
//        return MemberEntity.builder()
//                .id(id)
//                .memberID(memberID)
//                .memberName(memberName)
//                .password(password)
//                .build();
//    }
//
//    @Builder
//    public MemberDto(Long id, String memberID, String memberName,String password, LocalDateTime createdDate,LocalDateTime modifiedDate){
//        this.id=id;
//        this.memberID=memberID;
//        this.memberName=memberName;
//        this.password=password;
//        this.createdDate=createdDate;
//        this.modifiedDate=modifiedDate;
//    }
//}
