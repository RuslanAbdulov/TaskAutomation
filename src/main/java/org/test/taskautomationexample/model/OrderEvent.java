package org.test.taskautomationexample.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class OrderEvent extends Event {

    private String order;
    private String assistant;

}
