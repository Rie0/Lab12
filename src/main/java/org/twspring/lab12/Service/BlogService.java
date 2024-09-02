package org.twspring.lab12.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.twspring.lab12.Api.ApiException;
import org.twspring.lab12.Model.Blog;
import org.twspring.lab12.Model.User;
import org.twspring.lab12.Repository.BlogRepository;
import org.twspring.lab12.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(Integer id) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null) {
            throw new ApiException("Blog not found");
        }
        return blog;
    }

    //two ways to get blog by user

      //by searching for a user
    public List<Blog> getBlogsByAuthorId(Integer authorId) {
        return blogRepository.findAllByAuthorId(authorId);
    }

      //users see their own blogs
    public List<Blog> getMyBlogs(User author) {
        return blogRepository.findAllByAuthor(author);
    }


    public Blog getBlogByTitle(String title) {
        Blog blog = blogRepository.findBlogByTitle(title);
        if (blog == null) {
            throw new ApiException("Blog not found");
        }
        return blog;
    }


    public void addBlog(Integer authorId, Blog blog) {
        User author = userRepository.findUserById(authorId);
        if (author == null) {
            throw new ApiException("User not found");
        }
        blog.setAuthor(author);
        blogRepository.save(blog);
    }




    public void updateBlog(Integer authorId,Integer blogId, Blog blog) {
        User author = userRepository.findUserById(authorId);
        Blog oldBlog = blogRepository.findBlogById(blogId);
        if (oldBlog == null) {
            throw new ApiException("Blog not found");
        }
        if(oldBlog.getAuthor().getId() != authorId){
            throw new ApiException("You are not allowed to update this blog");
        }
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());
        blogRepository.save(oldBlog);
    }


    public void deleteBlog(Integer authorId,Integer blogId) {
        User author = userRepository.findUserById(authorId);
        Blog oldBlog = blogRepository.findBlogById(blogId);
        if (oldBlog == null) {
            throw new ApiException("Blog not found");
        }
        if(oldBlog.getAuthor().getId() != authorId){
            throw new ApiException("You are not allowed to update this blog");
        }
        blogRepository.delete(oldBlog);
    }

}
