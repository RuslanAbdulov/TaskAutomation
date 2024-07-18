package org.test.taskautomationexample.rule;

import org.test.taskautomationexample.model.Event;

public interface Executor<E extends Event> {

    String process(E event);

}
