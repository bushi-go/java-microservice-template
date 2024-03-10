package com.it.example.domain.contract.action.command;

import com.it.example.domain.mediator.Action;

public record ExampleCommand(String id, String name) implements Action {
}
