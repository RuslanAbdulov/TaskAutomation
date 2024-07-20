package org.example.taskautomation.rule;

import lombok.RequiredArgsConstructor;
import org.example.taskautomation.model.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.example.taskautomation.model.AppointmentEvent;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class AppointmentTaskRule implements TaskAutomationRule<AppointmentEvent> {

    private final ExecutorProvider<? super AppointmentEvent> executorRule;
    private final DueDateProvider<? super AppointmentEvent> dueDateRule;

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
