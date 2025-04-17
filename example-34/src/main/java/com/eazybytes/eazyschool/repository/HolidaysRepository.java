package com.eazybytes.eazyschool.repository;

import com.eazybytes.eazyschool.modal.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HolidaysRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public HolidaysRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Holiday>findAllHolidays()
    {
        String sql="SELECT * FROM holidays";
        var rowMapper= BeanPropertyRowMapper.newInstance(Holiday.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
}
