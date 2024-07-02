package com.hibernate.issue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=create-drop"})
public class ExampleRepositoryITest {

    @Autowired
    private ExampleDataRepository exampleDataRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
        "postgres:15-alpine"
    );


    @Test
    void shouldSaveHugeVolumeOfRecordsAtOnce() {

        List<ExampleData> exampleData = IntStream.range(0, 100000)
            .mapToObj(i -> new ExampleData(Long.valueOf(i)))
            .toList();

        Assertions.assertThat(exampleDataRepository.saveAll(exampleData))
            .hasSize(100000);

    }

}
