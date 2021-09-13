package com.example.simpleboard.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import com.example.simpleboard.service.BoardService;
import com.example.simpleboard.dto.BoardDto;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApiModel(value="RestBoardController : Rest Api Controller", description="Rest Api Controller")
@RestController //Autodetection
@RequestMapping("/api")

@AllArgsConstructor
public class RestBoardController {
    private BoardService boardService;

    @ApiModelProperty(value="게시글 리스트 조회")
    @RequestMapping(value = {"/list/p/{no}", "/list/p"}, method = RequestMethod.GET)
    public List<BoardDto> showList(@PathVariable("no") Optional<Integer> no){
        return boardService.getBoardlist(no.isPresent()?no.get():1);
        //return boardService.getBoardlist(pageNum.isPresent() ? pageNum.get() : (Integer)1);
    }
    @ApiModelProperty(value="페이징")
    @GetMapping("/page")
    public List<Integer> paging(){
        return boardService.getPageList();
    }

    @ApiModelProperty(value="게시글 조회")
    @GetMapping("/list/{no}")
    public BoardDto post(@PathVariable("no") Long no) {
        return boardService.getPost(no);
    }

    @ApiModelProperty(value="게시글 삭제")
    @DeleteMapping("/list/{no}")
    public void deletePost(@PathVariable("no") Long no){
        boardService.deletePost(no);
    }

    @ApiModelProperty(value="게시글 작성")
    @PostMapping("/posting")
    public void posting(@RequestBody BoardDto boardDto){
        boardService.savePost(boardDto);
    }

    @ApiModelProperty(value="게시글 수정")
    @PutMapping("/edit/list/{no}")
    public void edit(@RequestBody BoardDto boardDto){
        boardService.savePost(boardDto);
    }
}