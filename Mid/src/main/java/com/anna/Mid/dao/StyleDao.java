package com.anna.Mid.dao;

import com.anna.Mid.connection.ConnectionDb;
import com.anna.Mid.entity.Style;
import com.anna.Mid.mapper.StyleMapper;
import com.anna.Mid.notification.event.StyleDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import java.util.List;

@Component
public class StyleDao implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private JdbcTemplate jdbcTemplate;

    //Insert new category
    private final String INSERT_INTO_STYLE = "INSERT INTO style(title) VALUES (?)";
    //Delete category
    private final String DELETE_STYLE = "DELETE FROM style WHERE id = ?";
    //Get all categories
    private final String GET_ALL_STYLE = "SELECT id, title FROM style";

    @Autowired
    public StyleDao(ConnectionDb databaseConnection){
        this.jdbcTemplate = new JdbcTemplate(databaseConnection.getDriverManagerDataSource());
    }

    public int createStyle(Style style){
        return jdbcTemplate.update(INSERT_INTO_STYLE, style.getTitle());
    }

    public int deleteStyle(Long id){
        eventPublisher.publishEvent(new StyleDeleteEvent(this, id));
        return jdbcTemplate.update(DELETE_STYLE, id);
    }

    public List<Position> getAllStyle(){
        return jdbcTemplate.query(GET_ALL_STYLE, new StyleMapper());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}