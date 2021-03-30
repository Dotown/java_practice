package com.zhang.service;

import com.zhang.bean.Book;

import java.util.List;

/**
 * @author Dotown
 * @create 2021-03-30-14:33
 */
public interface BookService {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
}
