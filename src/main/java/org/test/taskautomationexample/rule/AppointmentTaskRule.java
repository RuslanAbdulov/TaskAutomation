package org.test.taskautomationexample.rule;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.test.taskautomationexample.model.AppointmentEvent;
import org.test.taskautomationexample.model.Task;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class AppointmentRule implements Rule<AppointmentEvent> {

    private final Executor<AppointmentEvent> executorRule;
    private final DueDate<? super AppointmentEvent> dueDateRule;

    @Override
    public Task process(AppointmentEvent event) {
        var executor = executorRule.process(event);
        var dueDate = dueDateRule.process(event);
        return Task.builder()
                .description("Prepare room %s.".formatted(event.getRoom()))
                .executor(executor)
                .dueDate(dueDate)
                .build();
    }

}
