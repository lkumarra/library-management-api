package com.librarymanagement.bdd.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testng.Assert;

import javax.sql.DataSource;
import java.util.*;

@Slf4j
/**
 * This class contains the methods related to Database connection.
 * @Author : Lavendra Kumar Rajput
 */
public class DBUtils {

    private JdbcTemplate jdbcTemplate;

    public DBUtils(String jdbcUrl, String userName, String password) {
        try {
            Assert.assertNotNull(jdbcUrl, "Url can not be null or empty");
            Assert.assertNotNull(userName, "Username can not be null or empty");
            Assert.assertNotNull(password, "Password can not be null or empty");
            DataSource dataSource = new DriverManagerDataSource(jdbcUrl, userName, password);
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (Exception e) {
            log.error("Error occurred while connecting with database with error : {}", e.getMessage());
        }
    }

    public DBUtils(String jdbcUrl) {
        try {
            Assert.assertNotNull(jdbcUrl, "Url can not be null or empty");
            DataSource dataSource = new DriverManagerDataSource(jdbcUrl);
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (Exception e) {
            log.error("Error occurred while connecting with database with error : {}", e.getMessage());
        }
    }

    /**
     * Execute select query
     *
     * @param query Query to execute
     * @return List<Map < String, String>>
     */
    public List<Map<String, Object>> selectQueryResult(String query) {
        if (Objects.nonNull(jdbcTemplate)) {
            Assert.assertNotNull(query, "Query can not be null or empty.");
            return jdbcTemplate.queryForList(query);
        } else
            return null;
    }

    /**
     * Execute select query
     *
     * @param query     Query to execute
     * @param arguments Arguments to pass in query
     * @return List<Map < String, String>>
     */
    public List<Map<String, Object>> selectQueryResult(String query, Objects... arguments) {
        if (Objects.nonNull(jdbcTemplate)) {
            Assert.assertNotNull(query, "Query can not be null or empty.");
            return jdbcTemplate.queryForList(query, (Object) arguments);
        } else
            return null;
    }

    /**
     * Execute update query
     *
     * @param query Query to execute
     * @return Rows impacted with the query
     */
    public int updateQuery(String query) {
        if (Objects.nonNull(jdbcTemplate))
            return jdbcTemplate.update(query);
        else
            return 0;
    }

    /**
     * Execute update query
     *
     * @param query     Query to execute
     * @param arguments Arguments to pass in the query
     * @return Rows impacted with query
     */
    public int updateQuery(String query, Objects... arguments) {
        if (Objects.nonNull(jdbcTemplate))
            return jdbcTemplate.update(query, (Object) arguments);
        else
            return 0;
    }

    /**
     * Execute insert query
     *
     * @param query Query to insert
     * @return Rows impacted with the query
     */
    public int insertQuery(String query) {
        if (Objects.nonNull(jdbcTemplate))
            return jdbcTemplate.update(query);
        else
            return 0;
    }

    /**
     * Execute insert query
     *
     * @param query     Query to insert
     * @param arguments Arguments to pass in the query
     * @return Rows impacted with query
     */
    public int insertQuery(String query, Object... arguments) {
        if (Objects.nonNull(jdbcTemplate))
            return jdbcTemplate.update(query, arguments);
        else
            return 0;
    }

    /**
     * Execute delete query
     *
     * @param query Query to delete
     * @return Rows impacted with the query
     */
    public int deleteQuery(String query) {
        if (Objects.nonNull(jdbcTemplate))
            return jdbcTemplate.update(query);
        else
            return 0;
    }

    /**
     * Execute delete query
     *
     * @param query     Query to delete
     * @param arguments Arguments in the query
     * @return Rows impacted with query
     */
    public int deleteQuery(String query, Object... arguments) {
        if (Objects.nonNull(jdbcTemplate))
            return jdbcTemplate.update(query, arguments);
        else
            return 0;
    }

}
