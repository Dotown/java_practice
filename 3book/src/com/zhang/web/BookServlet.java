package com.zhang.web;

import com.zhang.bean.Book;
import com.zhang.service.BookService;
import com.zhang.service.impl.BookServiceImpl;
import com.zhang.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Dotown
 * @create 2021-03-30-14:59
 */
public class BookServlet extends BaseServlet{
    private BookService bookService =new BookServiceImpl();
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        bookService.deleteBookById(i);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        Book book = bookService.queryBookById(i);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
    }

}
