package com.abdul.postdb.dao.impl;

import com.abdul.postdb.domain.Author;
import com.abdul.postdb.domain.Book;

public final class TestDataUtil {
    private TestDataUtil() {}


    static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Abdullah")
                .age(21)
                .build();
    }

    static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Ahmad")
                .age(22)
                .build();
    }

    static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Wasim")
                .age(21)
                .build();
    }

    static Book createTestBookA() {
        return Book.builder()
                .isbn("1633-2906-15")
                .title("Java Spring")
                .authorId(1L)
                .build();
    }

    static Book createTestBookB() {
        return Book.builder()
                .isbn("1611-2905-14")
                .title("Python Django")
                .authorId(1L)
                .build();
    }

    static Book createTestBookC() {
        return Book.builder()
                .isbn("2223-1423-60")
                .title("JavaScript")
                .authorId(2L)
                .build();
    }
}
