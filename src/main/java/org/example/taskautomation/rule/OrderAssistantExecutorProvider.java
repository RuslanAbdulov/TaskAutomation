package org.example.taskautomation.rule;

import org.example.taskautomation.model.OrderEvent;
import org.springframework.stereotype.Component;


@Component
public class OrderAssistantExecutorProvider implements ExecutorProvider<OrderEvent> {

    @Override
    public String process(OrderEvent event) {
        return event.getAssistant();
    }

}
