package com.anna.Mid.connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConnectionDb {

    //Assigning values from the application.properties file
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;
    @Value("${database.driver}")
    private String driver;

    private DriverManagerDataSource driverManagerDataSource;

    //Post construct method for initializing connection to the database
    @PostConstruct
    public void init(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        driverManagerDataSource.setDriverClassName(driver);
        this.driverManagerDataSource = driverManagerDataSource;
    }

    public DriverManagerDataSource getDriverManagerDataSource() {
        return driverManagerDataSource;
    }

}
