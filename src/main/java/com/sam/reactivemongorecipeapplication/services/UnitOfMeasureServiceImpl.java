package com.sam.reactivemongorecipeapplication.services;

import org.springframework.stereotype.Service;

import com.sam.reactivemongorecipeapplication.commands.UnitOfMeasureCommand;
import com.sam.reactivemongorecipeapplication.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.sam.reactivemongorecipeapplication.repositories.UnitOfMeasureRepository;
import com.sam.reactivemongorecipeapplication.repositories.reactive.UnitOfMeasureReactiveRepository;

import reactor.core.publisher.Flux;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    

    public UnitOfMeasureServiceImpl(UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository,
			UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
		super();
		this.unitOfMeasureReactiveRepository = unitOfMeasureReactiveRepository;
		this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
	}



	@Override
    public Flux<UnitOfMeasureCommand> listAllUoms() {
    	
    	
    	return unitOfMeasureReactiveRepository
                .findAll()
                .map(unitOfMeasureToUnitOfMeasureCommand::convert);

//        return StreamSupport.stream(unitOfMeasureRepository.findAll()
//                .spliterator(), false)
//                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
//                .collect(Collectors.toSet());
    }
}
