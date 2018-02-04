package com.sam.reactivemongorecipeapplication.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sam.reactivemongorecipeapplication.commands.UnitOfMeasureCommand;
import com.sam.reactivemongorecipeapplication.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.sam.reactivemongorecipeapplication.domain.UnitOfMeasure;
import com.sam.reactivemongorecipeapplication.repositories.UnitOfMeasureRepository;
import com.sam.reactivemongorecipeapplication.repositories.reactive.UnitOfMeasureReactiveRepository;

import reactor.core.publisher.Flux;

public class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureReactiveRepository UnitOfMeasureReactiveRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        service = new UnitOfMeasureServiceImpl(UnitOfMeasureReactiveRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUoms() throws Exception {
        //given
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId("1");
        unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId("2");
        unitOfMeasures.add(uom2);

        when(UnitOfMeasureReactiveRepository.findAll()).thenReturn(Flux.just(uom1));

        //when
        List<UnitOfMeasureCommand> commands = service.listAllUoms().collectList().block();

        //then
        assertEquals(2, commands.size());
        verify(UnitOfMeasureReactiveRepository, times(1)).findAll();
    }

}