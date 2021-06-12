package com.neutrix.akram.tlili.domain.base;


public abstract class VoidUseCase<P>{
    public abstract void execute(P param) throws Exception;
}