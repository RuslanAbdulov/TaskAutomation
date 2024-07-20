package org.example.taskautomation.rule;

import org.example.taskautomation.model.Event;
import org.example.taskautomation.model.Task;

public interface TaskAutomationRule<E extends Event> {

    Task process(E event);

}
