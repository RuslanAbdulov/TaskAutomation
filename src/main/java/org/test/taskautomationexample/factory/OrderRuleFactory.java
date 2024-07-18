package org.test.taskautomationexample.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import org.test.taskautomationexample.model.OrderEvent;
import org.test.taskautomationexample.rule.DueDateProvider;
import org.test.taskautomationexample.rule.ExecutorProvider;
import org.test.taskautomationexample.rule.OffsetBasedDueDateProvider;
import org.test.taskautomationexample.rule.OrderAssistantExecutor;
import org.test.taskautomationexample.rule.OrderTaskRule;
import org.test.taskautomationexample.rule.TaskAutomationRule;

import java.util.Map;


@Component
@RequiredArgsConstructor
public class OrderRuleFactory implements RuleFactory<OrderEvent> {

    private final OrderAssistantExecutor executor;

    @Override
    public TaskAutomationRule<OrderEvent> createRule(Map<String, String> settings) {
        return createOrderRule(executor, createDueDate(settings.get("dueDateOffset")));
    }

    @Lookup
    private OffsetBasedDueDateProvider createDueDate(String offset) {
        return new OffsetBasedDueDateProvider(offset);
    }

    @Lookup
    private OrderTaskRule createOrderRule(ExecutorProvider<OrderEvent> executor, DueDateProvider<? super OrderEvent> dueDate) {
        return new OrderTaskRule(executor, dueDate);
    }

}
