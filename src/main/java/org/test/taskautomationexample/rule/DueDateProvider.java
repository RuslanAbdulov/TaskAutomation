package org.test.taskautomationexample.rule;

import org.test.taskautomationexample.model.Event;

import java.time.Instant;

public interface DueDate<E extends Event> {

    Instant process(E event);

}
