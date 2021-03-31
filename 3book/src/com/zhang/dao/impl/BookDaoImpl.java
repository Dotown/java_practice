package com.zhang.dao.impl;

import com.zhang.bean.Book;
import com.zhang.dao.BookDao;

import java.util.List;

/**
 * @author Dotown
 * @create 2021-03-30-11:13
 */
public class BookDaoImpl extends BaseDaoImpl implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) " +
                "VALUES(? , ? , ? , ?, ? , ? , ?)";
        if(book.getImgPath()==""||book.getImgPath()==null){
            book.setImgPath("static/img/default.jpg");
        }
            return update(sql, book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name` = ?, `author` = ?, `price` = ?, `sales` = ?, `stock` = ?, `img_path` = ? where `id` = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book";
        return queryForList(Book.class,sql);
    }
}
