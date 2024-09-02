package org.twspring.lab12.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.twspring.lab12.Model.Blog;
import org.twspring.lab12.Model.User;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Blog findBlogById(Integer id);
    Blog findBlogByTitle(String title);
    List<Blog> findAllByAuthor(User author);
    List<Blog> findAllByAuthorId(Integer authorId);

}
