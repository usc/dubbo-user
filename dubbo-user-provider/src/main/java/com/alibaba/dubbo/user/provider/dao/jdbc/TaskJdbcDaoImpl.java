package com.alibaba.dubbo.user.provider.dao.jdbc;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.user.provider.model.Task1;
import com.alibaba.dubbo.user.provider.model.Task2;

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

        List<Task1> list = jdbcTemplate.query("select * from ss_task", BeanPropertyRowMapper.newInstance(Task1.class));
        System.out.println("[JDBC.TEST]" + list);

        jdbcTemplate.update("delete from ss_task where id = ?", 2);

        jdbcTemplate.update("update ss_task set title = ? where id = ?", "test", 1);

        // add task2
        new SimpleJdbcInsert(getJdbcTemplate()).withTableName("ss_task").execute(new BeanPropertySqlParameterSource(new Task2("t2_jdbc_" + random(), "d2_jdbc_" + random())));
    }

    private static String random() {
        return RandomStringUtils.randomAlphanumeric(6);
    }

}
