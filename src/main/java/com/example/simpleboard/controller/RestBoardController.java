package com.example.simpleboard.controller;

import lombok.AllArgsConstructor;
import com.example.simpleboard.service.BoardService;
import com.example.simpleboard.dto.BoardDto;
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

@RestController //Autodetection
@RequestMapping("/api")

@AllArgsConstructor
public class RestBoardController {
    private BoardService boardService;

    @RequestMapping(value = {"/list/p/{no}", "/list/p"}, method = RequestMethod.GET)
    public List<BoardDto> showList(@PathVariable("no") Optional<Integer> no){
        return boardService.getBoardlist(no.isPresent()?no.get():1);
        //return boardService.getBoardlist(pageNum.isPresent() ? pageNum.get() : (Integer)1);
    }

    @GetMapping("/page")
    public List<Integer> paging(){
        return boardService.getPageList();
    }

    @GetMapping("/list/{no}")
    public BoardDto post(@PathVariable("no") Long no) {
        return boardService.getPost(no);
    }

}