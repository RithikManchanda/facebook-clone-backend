package com.dailycodebuffer.facebookclone.controller;

import com.dailycodebuffer.facebookclone.model.Post;
import com.dailycodebuffer.facebookclone.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ap1/v1/post")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;

    }

    @PostMapping
    public Post addPost(@RequestParam Map<String,String> requestParam) throws Exception {
        String strpost = requestParam.get("post");
        String email = requestParam.get("email");
        String name = requestParam.get("name");
        String file = requestParam.get("file");
        String profilePic = requestParam.get("profilePic");

        Post post = Post.builder().post(strpost).email(email).name(name).file(file).profilePic(profilePic).build();

        post=postService.addPost(post);
        return post;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }


}
