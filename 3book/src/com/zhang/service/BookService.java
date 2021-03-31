package com.zhang.service;

import com.zhang.bean.Book;
import com.zhang.bean.Page;

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
    public Page<Book> page(int pageNo, int pageSize);
}
