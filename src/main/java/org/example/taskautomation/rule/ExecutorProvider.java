package org.example.taskautomation.rule;

import org.example.taskautomation.model.Event;

public interface ExecutorProvider<E extends Event> {

    String process(E event);

}
