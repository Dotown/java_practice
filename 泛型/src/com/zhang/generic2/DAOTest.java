package com.zhang.generic2;

import org.junit.Test;

/**
 * @author Dotown
 * @create 2021-01-16-16:31
 */
public class DAOTest {
    @Test
    public void test(){
        StudentDAO dao = new StudentDAO();
        Student student = new Student();
        dao.add(student);
    }
}
