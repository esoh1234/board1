package com.example.simpleboard.controller;

import lombok.AllArgsConstructor;
import com.example.simpleboard.service.BoardService;
import com.example.simpleboard.dto.BoardDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller //Autodetection
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/")
    public String index(){
        return "/index.html";
    }

    @GetMapping("/list")
    public String list(){
        return "/board/list.html";
    }

    @GetMapping("/list/{no}")
    public String post(@PathVariable("no") Long no, Model model){
        model.addAttribute("no", no);
        return "/board/post.html";
    }

    @GetMapping("/list/newpost")
    public String post(){
        return "/board/newpost.html";
    }

    @DeleteMapping("/list/{no}")
    public String deletePost(@PathVariable("no") Long no){
        boardService.deletePost(no);
        return "redirect:/list";
    }

    @PostMapping("/posting")
    public String posting(@RequestBody BoardDto boardDto){;
        //System.out.println(boardDto);
        boardService.savePost(boardDto);
        return "redirect:/list";
    }
    /*@PostMapping("/posting")
    public String post(BoardDto boardDto){;
        boardService.savePost(boardDto);
        return "redirect:/list";
    }

    @GetMapping("/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model){;
        BoardDto boardDTO = boardService.getPost(no);
        //System.out.println(boardDTO);
        model.addAttribute("boardDto", boardDTO);
        return "board/editing.html";
    }

    @PutMapping("/editing/{no}")
    //i guessed i should recieve no(number). but no, maybe because of "Put"Mapping?.
    //Nope, boardDTO has "id" data. hidden id is came from view.
    public String edit(BoardDto boardDto){
        //System.out.println(boardDto);
        boardService.savePost(boardDto);
        return "redirect:/list";
    }*/
}