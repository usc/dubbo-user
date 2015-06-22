package com.alibaba.dubbo.user.provider.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Shunli
 */
public abstract class BaseDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationContext context;

    protected abstract String getDataSourceBeanName();

    protected void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = context.getBean(getDataSourceBeanName(), DataSource.class);
        }

        return dataSource;
    }

    protected JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            jdbcTemplate = new JdbcTemplate(getDataSource());
        }

        return jdbcTemplate;
    }

}
