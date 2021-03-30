package com.zhang.dao;

import com.zhang.bean.Book;

import java.util.List;

/**
 * @author Dotown
 * @create 2021-03-30-11:09
 */
public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
}
