package com.anna.Mid.dao;

import com.anna.Mid.connection.ConnectionDb;
import com.anna.Mid.entity.Position;
import com.anna.Mid.mapper.PositionMapper;
import com.anna.Mid.notification.event.PositionDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PositionDao implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private JdbcTemplate jdbcTemplate;

    //Insert new category
    private final String INSERT_INTO_POSITION = "INSERT INTO position(name) VALUES (?)";
    //Delete category
    private final String DELETE_POSITION = "DELETE FROM position WHERE id = ?";
    //Get all categories
    private final String GET_ALL_POSITIONS = "SELECT id, name FROM position";

    @Autowired
    public PositionDao(ConnectionDb databaseConnection){
        this.jdbcTemplate = new JdbcTemplate(databaseConnection.getDriverManagerDataSource());
    }

    public int createPosition(Position position){
        return jdbcTemplate.update(INSERT_INTO_POSITION, position.getTitle());
    }

    public int deletePosition(Long id){
        eventPublisher.publishEvent(new PositionDeleteEvent(this, id));
        return jdbcTemplate.update(DELETE_POSITION, id);
    }

    public List<Position> getAllPositions(){
        return jdbcTemplate.query(GET_ALL_POSITIONS, new PositionMapper());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}