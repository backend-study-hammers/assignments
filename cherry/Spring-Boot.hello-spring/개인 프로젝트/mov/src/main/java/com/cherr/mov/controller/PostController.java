package com.cherr.mov.controller;

import com.cherr.mov.domain.posts.PostsDto;
import com.cherr.mov.domain.posts.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {
    private PostsService postsService;

    @GetMapping("/")
    public String list(Model model){
        List<PostsDto> postsList = postsService.getBoardlist();

        model.addAttribute("postsList", postsList);
        return "posts/list.html";
    }

    @GetMapping("/post")
    public String write() {
        return "posts/write.html";
    }

    @PostMapping("/post")
    public String write(PostsDto postsDto) {
        postsService.savePost(postsDto);

        return "redirect:/";
    }

    @RequestMapping(value = "/post/edit/{no}" , method = RequestMethod.GET)
    public String edit(@PathVariable("no") Long no, Model model) {
        PostsDto postsDto = postsService.getPost(no);

        model.addAttribute("postsDto", postsDto);
        return "posts/update.html";
    }

    @RequestMapping(value = "/post/edit/{no}" , method = {RequestMethod.POST, RequestMethod.PUT})
    public String update(PostsDto postsDto) {
        postsService.savePost(postsDto);

        return "redirect:/";
    }

    @RequestMapping(value = "/post/{no}" , method = RequestMethod.GET)
    public String detail(@PathVariable("no") Long no, Model model) {
        PostsDto postsDto = postsService.getPost(no);

        model.addAttribute("postsDto", postsDto);
        return "posts/detail.html";
    }

    @RequestMapping(value = "/post/{no}" , method = {RequestMethod.POST, RequestMethod.DELETE})
    public String delete(@PathVariable("no") Long no) {
        postsService.deletePost(no);

        return "redirect:/";
    }

    // 로그인 페이지
    @RequestMapping(value = "/login")
    public String loginpage(){

        return "login/login.html";
    }

    // 회원가입 페이지
    @RequestMapping(value = "/join")
    public String join(){

        return "login/join.html";
    }
}
