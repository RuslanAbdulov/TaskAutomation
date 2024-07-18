package org.test.taskautomationexample.rule;

import org.springframework.stereotype.Component;
import org.test.taskautomationexample.model.OrderEvent;


@Component
public class OrderAssistantExecutor implements ExecutorProvider<OrderEvent> {

    @Override
    public String process(OrderEvent event) {
        return event.getAssistant();
    }

}
