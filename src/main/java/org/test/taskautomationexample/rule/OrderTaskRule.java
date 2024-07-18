package org.test.taskautomationexample.rule;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.test.taskautomationexample.model.OrderEvent;
import org.test.taskautomationexample.model.Task;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class OrderRule implements Rule<OrderEvent> {

    private final Executor<OrderEvent> executorRule;
    private final DueDate<? super OrderEvent> dueDateRule;

    @Override
    public Task process(OrderEvent event) {
        var executor = executorRule.process(event);
        var dueDate = dueDateRule.process(event);
        return Task.builder()
                .description("Check fulfillment of order %s.".formatted(event.getOrder()))
                .executor(executor)
                .dueDate(dueDate)
                .build();
    }

}
