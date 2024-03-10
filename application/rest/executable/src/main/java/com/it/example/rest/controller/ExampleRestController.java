package com.it.example.rest.controller;

import com.it.example.domain.contract.action.command.ExampleCommand;
import com.it.example.domain.contract.action.query.ExampleQuery;
import com.it.example.domain.contract.model.dto.ExampleDto;
import com.it.example.domain.contract.port.driving.ExamplePort;
import com.it.example.rest.contract.request.ExampleWriteRequest;
import com.it.example.rest.contract.response.ExampleReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/v1/example")
@RequiredArgsConstructor
public class ExampleRestController {

    private final ExamplePort port;

    private final ConversionService mapper;

    @GetMapping(value = "/{exampleId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_PROBLEM_JSON_VALUE
            }
    )
    public ResponseEntity<ExampleReadResponse> getExample(@PathVariable("exampleId") String exampleId) {
        ExampleDto example = port.exampleRead(mapper.convert(exampleId, ExampleQuery.class));

        return ResponseEntity.ok(mapper.convert(example, ExampleReadResponse.class));
    }

    @PostMapping(value = "/{exampleId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_PROBLEM_JSON_VALUE
            }
    )
    public ResponseEntity<Void> postExample(@PathVariable("exampleId") String exampleId, ExampleWriteRequest request) {
        port.exampleWrite(new ExampleCommand(exampleId, request.getName()));
        return ResponseEntity.noContent().build();
    }
}
