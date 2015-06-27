package com.alibaba.dubbo.user.provider.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.google.common.collect.Iterables;

/**
 * suppress IncorrectResultSizeDataAccessException
 *
 * @author Shunli
 */
public class JdbcTemplate extends org.springframework.jdbc.core.JdbcTemplate {
    public JdbcTemplate() {
        super();
    }

    public JdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    public JdbcTemplate(DataSource dataSource, boolean lazyInit) {
        super(dataSource, lazyInit);
    }

    @Override
    public <T> T queryForObject(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper) throws DataAccessException {
        return Iterables.getFirst(super.query(sql, args, argTypes, new RowMapperResultSetExtractor<T>(rowMapper, 1)), null);
    }

    @Override
    public <T> T queryForObject(String sql, Object[] args, RowMapper<T> rowMapper) throws DataAccessException {
        return Iterables.getFirst(super.query(sql, args, new RowMapperResultSetExtractor<T>(rowMapper, 1)), null);
    }

    @Override
    public <T> T queryForObject(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        return Iterables.getFirst(super.query(sql, rowMapper), null);
    }

    @Override
    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args) throws DataAccessException {
        return Iterables.getFirst(super.query(sql, args, new RowMapperResultSetExtractor<T>(rowMapper, 1)), null);
    }
}
