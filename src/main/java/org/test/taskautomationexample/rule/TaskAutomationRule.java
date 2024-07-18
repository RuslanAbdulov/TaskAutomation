package org.test.taskautomationexample.rule;

import org.test.taskautomationexample.model.Event;
import org.test.taskautomationexample.model.Task;

public interface Rule<E extends Event> {

    Task process(E event);

}
