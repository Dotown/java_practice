package com.zhang.dao.impl;

import com.zhang.bean.Book;
import com.zhang.dao.PageDao;

import java.util.List;

/**
 * @author Dotown
 * @create 2021-03-31-21:02
 */
public class PageDaoImpl extends BaseDaoImpl implements PageDao {
    @Override
    public int queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }
}
