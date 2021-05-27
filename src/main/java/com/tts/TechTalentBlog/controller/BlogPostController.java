package com.tts.TechTalentBlog.controller;

import com.tts.TechTalentBlog.model.BlogPost;
import com.tts.TechTalentBlog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;
//    the code above and below do the same thing

//    public BlogPostController(BlogPostService blogPostService) {
//        this.blogPostService = blogPostService;
//    }

    @GetMapping(value= "/")
    public String index(BlogPost blogPost, Model model) {
        model.addAttribute("posts", blogPostService.getAllBlogPosts());
        // this return value is a reference to a template
        // it will not literally return a string value
        return "blogpost/index";
    }

    @GetMapping("/blogposts/new")
    public String newBlog(BlogPost blogPost) {
        return "blogPost/new";
    }

    @PostMapping("/blogposts")
    public String addNewBlogPost(BlogPost blogPost, Model model) {
        blogPostService.addNewBlogPost(blogPost);
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";

    }

    @DeleteMapping("/blogposts/{id}")
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {
        blogPostService.deletePostById(id);
        return "redirect:/";
    }

    @GetMapping("/blogposts/{id}")
    public String editPostWithId(@PathVariable Long id, BlogPost blogPost, Model model){
        BlogPost foundPost = blogPostService.findBlogPostById(id);
        model.addAttribute("blogPost", foundPost);
        return "blogpost/edit";
    }

    @PostMapping("blogposts/update/{id}")
    public String updateExistingPost(@PathVariable Long  id, BlogPost blogPost, Model model) {
        BlogPost editedPost = blogPostService.editBlogPostById(id, blogPost);
        model.addAttribute("blogPost", editedPost);
        return "blogpost/result";
    }

}
