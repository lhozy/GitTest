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
    @Test
    public void testAdd(){
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
        Assert.assertEquals(1,count);
    }
    @Test
    public void testDel(){
        String sql = "DELETE FROM emp WHERE id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
        Assert.assertEquals(1,count);
    }

}
