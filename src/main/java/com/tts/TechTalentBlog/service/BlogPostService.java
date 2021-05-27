package com.tts.TechTalentBlog.service;


import com.tts.TechTalentBlog.model.BlogPost;

import java.util.Optional;

// this service is going to serve as a contract for our implementation
public interface BlogPostService {

    BlogPost addNewBlogPost(BlogPost blogPost);

    Iterable<BlogPost> getAllBlogPosts();
//    List<BlogPost> getAllBlogPostsAsList();

    void deletePostById(Long id);

    BlogPost findBlogPostById(Long id);

    BlogPost editBlogPostById(Long id, BlogPost blogPost);

}
