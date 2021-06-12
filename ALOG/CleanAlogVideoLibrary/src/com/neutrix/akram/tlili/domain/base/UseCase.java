package com.neutrix.akram.tlili.domain.base;

public abstract class UseCase<P,R> {
    public abstract R execute(P param);
}




