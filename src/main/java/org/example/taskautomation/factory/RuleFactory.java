package org.example.taskautomation.factory;

import org.example.taskautomation.rule.TaskAutomationRule;
import org.example.taskautomation.model.Event;

import java.util.Map;

public interface RuleFactory<E extends Event> {

    TaskAutomationRule<E> createRule(Map<String, String> settings);

}
