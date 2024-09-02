package org.twspring.lab12.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.twspring.lab12.Model.Blog;
import org.twspring.lab12.Model.User;
import org.twspring.lab12.Service.BlogService;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get-all") //anyone can see any blog
    public ResponseEntity getAllBlogs() {
        return ResponseEntity.status(200).body(blogService.getAllBlogs());
    }

    @GetMapping("/get-by-id/{blogId}")
    public ResponseEntity getBlogById(@PathVariable Integer blogId) {
        return ResponseEntity.status(200).body(blogService.getBlogById(blogId));
    }
    @GetMapping("/get-by-title/{string}")
    public ResponseEntity getBlogByTitle(@PathVariable String string) {
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(string));
    }

    @GetMapping("/get-by-author-id/{authorId}")
    public ResponseEntity getBlogByAuthorId(@PathVariable Integer authorId) {
        return ResponseEntity.status(200).body(blogService.getBlogsByAuthorId(authorId));
    }
    @GetMapping("/get-my-blogs")
    public ResponseEntity getMyBlogs(@AuthenticationPrincipal User author) {
        return ResponseEntity.status(200).body(blogService.getMyBlogs(author));
    }
    @PostMapping("/add")
    public ResponseEntity addBlog(@AuthenticationPrincipal User author,
                                  @RequestBody @Valid Blog blog) {
        blogService.addBlog(author.getId(), blog);
        return ResponseEntity.status(200).body("Blog added successfully");
    }
    @PutMapping("/update/{blogId}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal User author,
                           @PathVariable Integer blogId,
                           @RequestBody@Valid Blog blog) {
        blogService.updateBlog(author.getId(),blogId,blog);
        return ResponseEntity.status(200).body("Blog updated successfully");
    }

    @DeleteMapping("/delete/{blogId}")
    public ResponseEntity deleteBlog(@PathVariable Integer blogId,
                                     @AuthenticationPrincipal User author) {
        blogService.deleteBlog(author.getId(),blogId);
        return ResponseEntity.status(200).body("Blog deleted successfully");
    }
}
