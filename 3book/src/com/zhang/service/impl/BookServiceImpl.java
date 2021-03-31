package com.zhang.service.impl;

import com.zhang.bean.Book;
import com.zhang.bean.Page;
import com.zhang.dao.BookDao;
import com.zhang.dao.PageDao;
import com.zhang.dao.impl.BookDaoImpl;
import com.zhang.dao.impl.PageDaoImpl;
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

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> bookPage = new Page<>();
        PageDao pageDao = new PageDaoImpl();
        int pageTotalCount = pageDao.queryForPageTotalCount();
        //1.PageNo
//        bookPage.setPageNo(pageNo);   ，因为要和pageTotal比较，会出现空指针
        //2.pageTotal
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount%pageSize!=0){
            pageTotal+=1;
        }
        bookPage.setPageTotal(pageTotal);
        //3.pageTotalCount
        bookPage.setPageTotalCount(pageTotalCount);
        //4.pageSize
        bookPage.setPageSize(pageSize);
        //1.PageNo
        bookPage.setPageNo(pageNo);
        //5.item
        int begin = pageSize*(bookPage.getPageNo()-1);
        List<Book> books = pageDao.queryForPageItems(begin, pageSize);
        bookPage.setItem(books);

        return bookPage;
    }
}
