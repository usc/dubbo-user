package com.alibaba.dubbo.user.provider.dao;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.alibaba.dubbo.user.provider.model.Task1;
import com.google.common.collect.Iterables;

/**
 *
 * @author Shunli
 */
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml", "/META-INF/spring/jpa-data.xml" })
public class DaoTest extends AbstractJUnit4SpringContextTests {

    // @Resource(name = "db1DataSource")
    // private DataSource dataSource;

    @Resource(name = "db1JdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        // query List
        System.out.println("1.1 " + jdbcTemplate.query("select * from ss_task", BeanPropertyRowMapper.newInstance(Task1.class)));
        System.out.println("1.2 " + jdbcTemplate.queryForList("select title from ss_task where title like ?", String.class, "%t1_%"));

        // // query Object
        // -- normal
        System.out.println("2.1 " + Iterables.getFirst(jdbcTemplate.query("select * from ss_task where id = ?", BeanPropertyRowMapper.newInstance(Task1.class), 1), null));
        System.out.println("2.2 " + jdbcTemplate.queryForObject("select * from ss_task where id = ?", BeanPropertyRowMapper.newInstance(Task1.class), 1));

        // -- abonormal empty
        System.out.println("2.3 " + Iterables.getFirst(jdbcTemplate.query("select * from ss_task where id = ?", BeanPropertyRowMapper.newInstance(Task1.class), 2), null));
        System.out.println("2.4 " + jdbcTemplate.queryForObject("select title from ss_task where title like ?", BeanPropertyRowMapper.newInstance(Task1.class), 2));

        // -- abonormal more results
        System.out.println("2.5 " + Iterables.getFirst(jdbcTemplate.query("select * from ss_task where title like ?", BeanPropertyRowMapper.newInstance(Task1.class), "%t1_%"), null));
        System.out.println("2.6 " + jdbcTemplate.queryForObject("select * from ss_task where title like ?", BeanPropertyRowMapper.newInstance(Task1.class), "%t1_%"));

        // query String
        System.out.println("3.1 " + Iterables.getFirst(jdbcTemplate.queryForList("select title from ss_task where id = ?", String.class, 2), StringUtils.EMPTY));
        System.out.println("3.2 " + jdbcTemplate.queryForObject("select title from ss_task where id = ?", String.class, 2));

    }
}
