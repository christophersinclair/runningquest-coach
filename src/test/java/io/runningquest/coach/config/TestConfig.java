package io.runningquest.coach.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class TestConfig {

    private static final EmbeddedDatabase embeddedTestDB;

    static {
        embeddedTestDB = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/sql/create-db.sql")
                .build();
    }

    @Bean
    public DataSource dataSource() {
        return embeddedTestDB;
    }
}
