package org.example.taskautomation.rule;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.example.taskautomation.model.OrderEvent;
import org.example.taskautomation.model.Task;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class OrderTaskRule implements TaskAutomationRule<OrderEvent> {

    private final ExecutorProvider<OrderEvent> executorRule;
    private final DueDateProvider<? super OrderEvent> dueDateRule;

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
