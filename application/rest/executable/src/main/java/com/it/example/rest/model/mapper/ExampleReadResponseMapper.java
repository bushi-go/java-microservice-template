package com.it.example.rest.model.mapper;

import com.it.example.domain.contract.model.dto.ExampleDto;
import com.it.example.rest.contract.response.ExampleReadResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExampleReadResponseMapper implements Converter<ExampleDto, ExampleReadResponse> {

    @Override
    public ExampleReadResponse convert(ExampleDto source) {
        return new ExampleReadResponse(source.id(), source.name());
    }
}
