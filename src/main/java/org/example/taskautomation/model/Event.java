package org.example.taskautomation.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Data
@SuperBuilder
public class Event {
    private Instant timestamp;
}
