package com.example.simpleboard.controller;

import com.example.simpleboard.dto.MemberDto;
import com.example.simpleboard.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("/user/login")
    public String login() {
        return "/user/login.html";
    }

    @GetMapping("/user/register")
    public String register() {
        return "/user/register.html";
    }

    @GetMapping("/user/login/result")
    public String loginsuccess() {
        return "redirect:/";
    }
    @PostMapping("/user/register")



    public String register(MemberDto memberDto) {
        memberService.registerMember(memberDto);
        return "redirect:/";
    }



}
