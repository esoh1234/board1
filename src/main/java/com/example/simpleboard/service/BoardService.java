package com.example.simpleboard.service;

import com.example.simpleboard.domain.entity.BoardEntity;
import com.example.simpleboard.domain.repository.BoardRepository;
import com.example.simpleboard.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {

    @Transactional
    public List<BoardDto> getBoardlist(Integer pageNum) {
        Page<BoardEntity> page = boardRepository.findAll(PageRequest.of(pageNum-1,POST_PER_PAGE));

        List<BoardEntity> boardEntities = page.getContent();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntities) {
            BoardDto boardDto = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .author(boardEntity.getAuthor())
                    .content(boardEntity.getContent())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();
            //System.out.println(boardEntity.getCreatedDate());
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

//    @Transactional
//    public List<Integer> getPageList(){
//        Long numberOfPost = boardRepository.count();
//        List<Integer> a= new ArrayList<>();
//
//        for(int i=1;i<=numberOfPost;i++)
//            a.add(i);
//
//        return 0;
//    }

    private BoardRepository boardRepository;

    @Transactional //If I don't use this, entity is not added.
    public Long savePost(BoardDto boardDto){
        boardDto.setCreatedDate(LocalDateTime.now());
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    private static final int POST_PER_PAGE=4;



    @Transactional
    public BoardDto getPost(Long no) {
        Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(no);
        BoardEntity boardEntity = boardEntityWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .author(boardEntity.getAuthor())
                .content(boardEntity.getContent())
                .createdDate(boardEntity.getCreatedDate())
                .build();

        //System.out.println(boardEntity.getCreatedDate());

        return boardDto;
    }

    @Transactional
    public void deletePost(Long no){boardRepository.deleteById(no);}

}
