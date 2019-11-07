package com.lh.jdbc;

import com.lh.domain.Emp;
import com.lh.utils.JDBCUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcDemo {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void testQuery(){
        //查询结果封装到JavaBean
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }

    }
    @Test
    public void testUpdate(){
        String sql = "update emp set salary = ? where id = ?";
        int i = template.update(sql, 1000, 1001);
        Assert.assertEquals(1,i);
    }

}
