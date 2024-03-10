package com.it.example.rest.config;

import com.it.example.domain.adapter.ExamplePrimaryAdapter;
import com.it.example.domain.contract.action.command.ExampleCommand;
import com.it.example.domain.contract.action.query.ExampleQuery;
import com.it.example.domain.contract.model.dto.ExampleDto;
import com.it.example.domain.contract.model.entity.ExampleEntity;
import com.it.example.domain.contract.port.driven.ExamplePersistencePort;
import com.it.example.domain.contract.port.driving.ExamplePort;
import com.it.example.domain.mediator.Handler;
import com.it.example.domain.mediator.Mediator;
import com.it.example.domain.mediator.impl.SimpleMediator;
import com.it.example.domain.usecase.ExampleReadHandler;
import com.it.example.domain.usecase.ExampleWriteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class ExampleApplicationBeanConfig {

    @Bean
    public ExamplePort examplePort(@Lazy Mediator mediator) {
        return new ExamplePrimaryAdapter(mediator);
    }

    @Bean
    public Mediator mediator(List<Handler<?,?>> handlers) {
        return new SimpleMediator(handlers);
    }

    @Bean
    public Handler<ExampleQuery, ExampleDto> exampleReadHandler(ExamplePersistencePort persistencePort) {
        return new ExampleReadHandler(persistencePort);
    }

    @Bean
    public Handler<ExampleCommand, Void> exampleWriteHandler(ExamplePersistencePort persistencePort) {
        return new ExampleWriteHandler(persistencePort);
    }

    @Bean
    public ExamplePersistencePort examplePersistencePort() {
        return new ExamplePersistencePort() {
            private final Map<String, ExampleEntity> state = new ConcurrentHashMap<>();
            @Override
            public void save(ExampleEntity entity) {
                state.put(entity.id(), entity);
            }

            @Override
            public Optional<ExampleEntity> findById(String id) {
                return Optional.ofNullable(state.get(id));
            }
        };
    }
}
