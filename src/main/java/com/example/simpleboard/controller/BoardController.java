package com.example.simpleboard.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import com.example.simpleboard.service.BoardService;
import com.example.simpleboard.dto.BoardDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Api(description="REST API")
@Controller //Autodetection
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/list/{no}")
    public String post(@PathVariable("no") Long no, Model model){
        model.addAttribute("no", no);
        return "/board/post.html";
    }

    @GetMapping("/")
    public String index(){
        return "/index.html";
    }

    @GetMapping("/list")
    public String list(){
        return "/board/list.html";
    }

    @GetMapping("/list/newpost")
    public String list(Model model){
        model.addAttribute("no",new Long(0));
        return "/board/newpost.html";
    }

    @GetMapping("/edit/list/{no}")
    public String edit(@PathVariable("no")Long no, Model model){
        model.addAttribute("no",no);
        return "/board/newpost.html";
    }


}