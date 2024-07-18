package org.test.taskautomationexample.rule;

import org.test.taskautomationexample.model.Event;

public interface ExecutorProvider<E extends Event> {

    String process(E event);

}
