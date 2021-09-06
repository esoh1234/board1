package com.example.simpleboard.controller;

import lombok.AllArgsConstructor;
import com.example.simpleboard.service.BoardService;
import com.example.simpleboard.dto.BoardDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller //Autodetection
@AllArgsConstructor

public class BoardController {
    private BoardService boardService;

    @GetMapping("/")
    public String index(){
//  To understand a type of List or array.
//        ArrayList<Integer> a= new ArrayList();
//        a.add(1);
//        a.add(2);
//        System.out.println(a);
//
//        Integer[] b = new Integer[3];
//        b[1]=1;
//        b[2]=2;
//        System.out.println(b[1]);
        return "/index.html";
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="p", defaultValue = "1") Integer pageNum){
        List<BoardDto> boardList= boardService.getBoardlist(pageNum);
        //List<Integer> pageList=boardService.getPageList();

        model.addAttribute("boardList",boardList);
        //model.addAttribute("pageList",pageList);

        List<Integer> sample = new ArrayList();
        sample.add(1);
        sample.add(2);
        model.addAttribute("pageList",sample);
        System.out.println(pageNum);

        return "board/list.html";
    }

    @GetMapping("/posting")
    public String post(){
        return "board/posting.html";
    }

    @GetMapping("/post/{no}")
    public String post(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);
        System.out.println(boardDTO);
        model.addAttribute("boardDto", boardDTO);
        return "board/post.html";
    }

    @PostMapping("/posting")
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
    }

    @DeleteMapping("/delete/{no}")
    public String deletePost(@PathVariable("no") Long no){
        boardService.deletePost(no);
        return "redirect:/list";
    }

    //Do I need to make another method below to do this?
    @GetMapping("/delete/{no}")
    public String deletePostwithGET(@PathVariable("no") Long no){
        boardService.deletePost(no);
        return "redirect:/list";
    }

}