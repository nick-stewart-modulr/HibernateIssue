package com.hibernate.issue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExampleData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data", nullable = false)
    private Long data;

    public ExampleData() {
    }

    public ExampleData(Long data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }
}
