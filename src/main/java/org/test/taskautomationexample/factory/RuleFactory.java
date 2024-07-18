package org.test.taskautomationexample.factory;

import org.test.taskautomationexample.model.Event;
import org.test.taskautomationexample.rule.TaskAutomationRule;

import java.util.Map;

public interface RuleFactory<E extends Event> {

    TaskAutomationRule<E> createRule(Map<String, String> settings);

}
