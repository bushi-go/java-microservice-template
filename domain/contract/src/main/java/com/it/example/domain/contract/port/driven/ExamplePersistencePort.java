package com.it.example.domain.contract.port.driven;

import com.it.example.domain.contract.model.entity.ExampleEntity;

import java.util.Optional;

public interface ExamplePersistencePort {
    void save(ExampleEntity entity);

    Optional<ExampleEntity> findById(String id);
}
