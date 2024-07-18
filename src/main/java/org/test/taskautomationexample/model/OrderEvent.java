package org.test.taskautomationexample.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderEvent extends Event {
    private String order;
    private String assistant;
}
