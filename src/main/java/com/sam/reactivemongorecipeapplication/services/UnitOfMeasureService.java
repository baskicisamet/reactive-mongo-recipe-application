package com.sam.reactivemongorecipeapplication.services;

import java.util.Set;

import com.sam.reactivemongorecipeapplication.commands.UnitOfMeasureCommand;

/**
 * Created by jt on 6/28/17.
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
