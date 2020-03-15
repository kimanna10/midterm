package com.anna.Mid.dao;

import com.anna.Mid.connection.ConnectionDb;
import com.anna.Mid.entity.Client;
import com.anna.Mid.mapper.ClientMapper;
import com.anna.Mid.notification.event.ClientDeleteEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;



@Component
public class ClientDao implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private JdbcTemplate jdbcTemplate;

    private final String GET_ALL_CLIENT = "SELECT s.id, name, age, p.id, name FROM client s\n";

    private final String DELETE_CLIENT_MEMBER = "DELETE FROM client WHERE id = ?";
    private final String INSERT_NEW_CLIENT_MEMBER = "INSERT INTO client(name, name, age, group)" +
            "VALUES (?, ?, ?, ?, ?, ?)";


    public ClientDao(ConnectionDb databaseConnection){
        this.jdbcTemplate = new JdbcTemplate(databaseConnection.getDriverManagerDataSource());
    }

    public List<Client> getAllClient(){
        return jdbcTemplate.query(GET_ALL_CLIENT, new ClientMapper());
    }

    public int deleteClientMember(Long id) {
        //Publish event when staff member was deleted
        eventPublisher.publishEvent(new ClientDeleteEvent(this, id));
        return jdbcTemplate.update(DELETE_CLIENT_MEMBER, id);
    }

    public int createClientMember(Client client){
        return jdbcTemplate.update(INSERT_NEW_CLIENT_MEMBER, client.getName(), client.getAge(),  client.getGroup());
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

}