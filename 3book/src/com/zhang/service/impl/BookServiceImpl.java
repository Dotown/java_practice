package com.zhang.service.impl;

import com.zhang.bean.Book;
import com.zhang.dao.BookDao;
import com.zhang.dao.impl.BookDaoImpl;
import com.zhang.service.BookService;

import java.util.List;

/**
 * @author Dotown
 * @create 2021-03-30-14:37
 */
public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
