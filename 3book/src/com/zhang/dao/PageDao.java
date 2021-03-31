package com.zhang.dao;

import com.zhang.bean.Book;

import java.util.List;

/**
 * @author Dotown
 * @create 2021-03-31-20:51
 */
public interface PageDao {
    public int queryForPageTotalCount();
    public List<Book> queryForPageItems(int begin,int pageSize);
}
