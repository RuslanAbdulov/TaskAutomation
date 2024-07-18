package org.test.taskautomationexample.event;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class AppointmentEvent extends Event {
    private String room;
}
