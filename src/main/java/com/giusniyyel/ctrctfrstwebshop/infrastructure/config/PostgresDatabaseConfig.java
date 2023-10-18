package com.giusniyyel.ctrctfrstwebshop.infrastructure.config;

import javax.sql.DataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.giusniyyel.ctrctfrstwebshop.infrastructure.persistence")
@EnableConfigurationProperties(DataSourceProperties.class)
@Data
public class PostgresDatabaseConfig {

    @Value("${spring.datasource.url}")
    private String databaseURL;

    @Value("${spring.datasource.username}")
    private String databaseUser;

    @Value("${spring.datasource.password}")
    private String databasePass;

    @Value("${spring.datasource.driverClassName}")
    private String databaseDriverClassName;

    @Primary
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(databaseURL);
        dataSource.setUsername(databaseUser);
        dataSource.setPassword(databasePass);
        dataSource.setDriverClassName(databaseDriverClassName);
        return dataSource;
    }
}
