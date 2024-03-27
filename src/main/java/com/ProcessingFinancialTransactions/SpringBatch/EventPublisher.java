package com.ProcessingFinancialTransactions.SpringBatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public EventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @SuppressWarnings("null")
    public void publishEvent(Object event) {
        eventPublisher.publishEvent(event);
    }
}