package org.example.taskautomation.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Data
@SuperBuilder
public abstract class Event {

    private Instant timestamp;

}
