package com.zhang.test;

import com.zhang.bean.Book;
import com.zhang.bean.Page;
import com.zhang.service.BookService;
import com.zhang.service.impl.BookServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dotown
 * @create 2021-03-31-21:34
 */
public class BookServiceImplTest {

    @Test
    public void page() {
        BookService bookService = new BookServiceImpl();
        Page<Book> page = bookService.page(2, 4);
        System.out.println(page);
    }
}