package co.edu.icesi.apizoo.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class LiquidBaseConfig {

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/master.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

}
