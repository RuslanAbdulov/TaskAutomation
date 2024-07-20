package org.example.taskautomation.factory;

import lombok.RequiredArgsConstructor;
import org.example.taskautomation.rule.TaskAutomationRule;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import org.example.taskautomation.model.AppointmentEvent;
import org.example.taskautomation.model.Event;
import org.example.taskautomation.rule.AppointmentTaskRule;
import org.example.taskautomation.rule.DueDateProvider;
import org.example.taskautomation.rule.ExecutorProvider;
import org.example.taskautomation.rule.OffsetBasedDueDateProvider;
import org.example.taskautomation.rule.RandomExecutorProvider;

import java.util.Map;


@Component
@RequiredArgsConstructor
public class AppointmentRuleFactory implements RuleFactory<AppointmentEvent> {

    private final RandomExecutorProvider<AppointmentEvent> executor;

    @Override
    public TaskAutomationRule<AppointmentEvent> createRule(Map<String, String> settings) {
        return createAppointmentRule(executor, createDueDate(settings.get("dueDateOffset")));
    }

    @Lookup
    private OffsetBasedDueDateProvider createDueDate(String offset) {
        return new OffsetBasedDueDateProvider(offset);
    }

    @Lookup
    private AppointmentTaskRule createAppointmentRule(ExecutorProvider<AppointmentEvent> executor, DueDateProvider<Event> dueDate) {
        return new AppointmentTaskRule(executor, dueDate);
    }

}
