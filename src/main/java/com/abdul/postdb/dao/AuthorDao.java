package com.abdul.postdb.dao;

import com.abdul.postdb.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(Long id);

    List<Author> find();

    void update(long id, Author author);

    void delete(long id);
}
