package com.zhang.test;

import com.zhang.bean.Book;
import com.zhang.dao.BookDao;
import com.zhang.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Dotown
 * @create 2021-03-30-13:05
 */
public class BookDaoImplTest {
    BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"剑指offer","zh", BigDecimal.valueOf(500),100,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"剑指回家","zh", BigDecimal.valueOf(500),100,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println("bookDao.queryBookById(20) = " + bookDao.queryBookById(20));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}