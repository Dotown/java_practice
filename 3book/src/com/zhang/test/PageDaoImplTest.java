package com.zhang.test;

import com.zhang.dao.PageDao;
import com.zhang.dao.impl.PageDaoImpl;
import org.junit.Test;

/**
 * @author Dotown
 * @create 2021-03-31-21:36
 */
public class PageDaoImplTest {
    PageDao pageDao = new PageDaoImpl();
    @Test
    public void queryForPageTotalCount() {
        System.out.println(pageDao.queryForPageTotalCount());
    }
}