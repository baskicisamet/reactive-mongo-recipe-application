package com.sam.reactivemongorecipeapplication.services;

import com.sam.reactivemongorecipeapplication.commands.UnitOfMeasureCommand;

import reactor.core.publisher.Flux;

public interface UnitOfMeasureService {

    Flux<UnitOfMeasureCommand> listAllUoms();
}
