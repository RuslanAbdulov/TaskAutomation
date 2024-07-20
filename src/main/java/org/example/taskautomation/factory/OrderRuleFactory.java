package org.example.taskautomation.factory;

import lombok.RequiredArgsConstructor;
import org.example.taskautomation.model.OrderEvent;
import org.example.taskautomation.rule.DueDateProvider;
import org.example.taskautomation.rule.ExecutorProvider;
import org.example.taskautomation.rule.OrderTaskRule;
import org.example.taskautomation.rule.TaskAutomationRule;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import org.example.taskautomation.rule.OffsetBasedDueDateProvider;
import org.example.taskautomation.rule.OrderAssistantExecutor;

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
