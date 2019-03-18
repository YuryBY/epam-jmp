package com.epam.cdp.jmp.eventservice.controller.beans;

public class EventRequestFailure {
    private String errorMessage;

    public EventRequestFailure(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
