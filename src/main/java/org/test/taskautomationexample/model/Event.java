package org.test.taskautomationexample.event;

import lombok.Data;

import java.time.Instant;

@Data
public class Event {
    private Instant timestamp;
}
