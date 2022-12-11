package com.example.com.nest.LibraryApp.dao;

import com.example.com.nest.LibraryApp.model.BooksModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDao extends CrudRepository<BooksModel,Integer> {
    @Query(value = "SELECT `id`, `description`, `image`, `price`, `releasedyear`, `title`, `author` FROM `books` WHERE `title` LIKE %:title%", nativeQuery = true)
    List<BooksModel> SearchBook(@Param("title") String title);

    @Query(value = "SELECT `id`, `description`, `image`, `price`, `releasedyear`, `title`, `author` FROM `books` WHERE `id`= :id", nativeQuery = true)
    List<BooksModel> GetBookById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `books` WHERE `id`= :id", nativeQuery = true)
    void DeleteBook(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `books` SET `description`= :description,`image`= :image,`price`= :price,`releasedyear`= :releasedyear,`title`= :title, `author`= :author WHERE `id` = :id", nativeQuery = true)
    void EditBook(@Param("id") Integer id, @Param("title") String title, @Param("description") String description, @Param("image") String image, @Param("price") String price, @Param("releasedyear") String releasedyear, @Param("author") String author);
}