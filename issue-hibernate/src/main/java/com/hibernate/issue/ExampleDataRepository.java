package com.hibernate.issue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleDataRepository extends JpaRepository<ExampleData, Long> {
}
