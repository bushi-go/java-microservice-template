package com.it.example.rest.model.mapper;

import com.it.example.domain.contract.action.query.ExampleQuery;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExampleReadRequestMapper implements Converter<String, ExampleQuery> {

    @Override
    public ExampleQuery convert(String source) {
        return new ExampleQuery(source);
    }
}
