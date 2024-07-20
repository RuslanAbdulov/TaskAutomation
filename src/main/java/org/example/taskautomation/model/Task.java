package org.example.taskautomation.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class Task {

    private String description;
    private String executor;
    private Instant dueDate;

}
