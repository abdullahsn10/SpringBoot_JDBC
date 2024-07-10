-- Create sequence if it does not exist
CREATE SEQUENCE IF NOT EXISTS authors_id_seq;

-- Drop tables if they exist
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

-- Create authors table
CREATE TABLE authors (
     id bigint DEFAULT nextval('authors_id_seq') NOT NULL,
     name text,
     age integer,
     CONSTRAINT authors_pkey PRIMARY KEY (id)
);

-- Create books table
CREATE TABLE books (
       isbn text NOT NULL,
       title text,
       author_id bigint,
       CONSTRAINT books_pkey PRIMARY KEY (isbn),
       CONSTRAINT fk_author FOREIGN KEY (author_id)
       REFERENCES authors(id)
);
