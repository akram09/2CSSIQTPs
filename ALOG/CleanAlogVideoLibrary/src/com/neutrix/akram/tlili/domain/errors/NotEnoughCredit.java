package com.neutrix.akram.tlili.domain.errors;

public class NotEnoughCredit extends Exception{
    public NotEnoughCredit() {
        super("There is not enough credit for this client");
    }
}
