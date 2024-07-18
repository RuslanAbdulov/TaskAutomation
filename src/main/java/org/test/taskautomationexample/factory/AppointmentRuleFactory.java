package org.test.taskautomationexample.factory;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import org.test.taskautomationexample.event.OrderEvent;
import org.test.taskautomationexample.rule.DueDate;
import org.test.taskautomationexample.rule.Executor;
import org.test.taskautomationexample.rule.OrderRule;
import org.test.taskautomationexample.rule.Rule;


@Component
public class OrderRuleFactory implements RuleFactory<OrderEvent> {

    @Override
    public Rule<OrderEvent> createRule(Executor<OrderEvent> executor, DueDate<OrderEvent> dueDate) {
        return createOrderRule(executor, dueDate);
    }

    @Lookup
    protected OrderRule createOrderRule(
            @NonNull Executor<OrderEvent> executor,
            @NonNull DueDate<OrderEvent> dueDate) {
        return new OrderRule(executor, dueDate);
    }

}
