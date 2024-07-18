package org.test.taskautomationexample.factory;

import org.springframework.stereotype.Component;
import org.test.taskautomationexample.event.Event;
import org.test.taskautomationexample.rule.DueDate;
import org.test.taskautomationexample.rule.Executor;
import org.test.taskautomationexample.rule.Rule;

@Component
public interface RuleFactory {
    <E extends Event> Rule<E> createRule(Executor<E> executor, DueDate<E> dueDate);
}
