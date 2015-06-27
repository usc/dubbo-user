package com.alibaba.dubbo.user.provider.dao.jdbc;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.user.provider.model.Task1;
import com.google.common.collect.Iterables;

/**
 *
 * @author Shunli
 */
@Repository
public class TaskJdbcDaoImpl extends BaseDao implements TaskJdbcDao {
    @Resource(name = "db1JdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    protected String getDataSourceBeanName() {
        return "db2DataSource";
    }

    public void test() {
        Task1 addTask = new Task1("t1_jdbc_" + random(), "d1_jdbc_" + random(), "eT_jdbc_" + random());

        Number id = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("ss_task")
                .usingGeneratedKeyColumns("id")
                // .execute(new BeanPropertySqlParameterSource(addTask))
                .executeAndReturnKey(new BeanPropertySqlParameterSource(addTask));

        System.out.println("[JDBC.TEST]" + id + " added");

        jdbcTemplate.update("delete from ss_task where id = ?", 2);

        jdbcTemplate.update("update ss_task set title = ? where id = ?", "test", 1);

        // query List
        jdbcTemplate.query("select * from ss_task", BeanPropertyRowMapper.newInstance(Task1.class), "2121");
        jdbcTemplate.queryForList("select title from ss_task where title like '$?$'", String.class, "2");

        // query Object
        Iterables.getFirst(jdbcTemplate.query("select * from ss_task where id = ?", BeanPropertyRowMapper.newInstance(Task1.class), 2), null);
        try {
            jdbcTemplate.queryForObject("select * from ss_task where id = ?", BeanPropertyRowMapper.newInstance(Task1.class), 2);
        } catch (IncorrectResultSizeDataAccessException e) {
            // null;
        }

        // query String
        Iterables.getFirst(jdbcTemplate.queryForList("select title from ss_task where id = ?", String.class, 2), StringUtils.EMPTY);
        try {
            jdbcTemplate.queryForObject("select title from ss_task where id = ?", String.class, 2);
        } catch (IncorrectResultSizeDataAccessException e) {
            // StringUtils.EMPTY
        }

        // add task2
        // new SimpleJdbcInsert(getJdbcTemplate()).withTableName("ss_task").execute(new BeanPropertySqlParameterSource(new Task2("t2_jdbc_" + random(),
        // "d2_jdbc_" + random())));
    }

    private static String random() {
        return RandomStringUtils.randomAlphanumeric(6);
    }

}
