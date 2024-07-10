package com.abdul.postdb.dao.impl;

import com.abdul.postdb.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    // the class that we are going to test
    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBookA();

        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?,?,?)"),
                eq("1633-2906-15"), eq("Java Spring"), eq(1L)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql(){
        underTest.findOne("1692-1553-243");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("1692-1553-243")
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateBookGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBookA();
        underTest.update(book.getIsbn(), book);
        verify(jdbcTemplate).update(
                eq("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?"),
                eq(book.getIsbn()),
                eq(book.getTitle()),
                eq(book.getAuthorId()),
                eq(book.getIsbn())
        );
    }

    @Test
    public void testThatDeleteBookGeneratesCorrectSql(){
        underTest.delete("1623-5543-221");
        verify(jdbcTemplate).update(
                eq("DELETE FROM books WHERE isbn = ?"),
                eq("1623-5543-221")
        );
    }


}
