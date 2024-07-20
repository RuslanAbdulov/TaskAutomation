package org.example.taskautomation.rule;

import org.example.taskautomation.model.Event;

import java.time.Instant;

public interface DueDateProvider<E extends Event> {

    Instant process(E event);

}
