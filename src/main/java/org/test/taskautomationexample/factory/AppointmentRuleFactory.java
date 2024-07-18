package org.test.taskautomationexample.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import org.test.taskautomationexample.model.AppointmentEvent;
import org.test.taskautomationexample.model.Event;
import org.test.taskautomationexample.rule.AppointmentTaskRule;
import org.test.taskautomationexample.rule.DueDateProvider;
import org.test.taskautomationexample.rule.ExecutorProvider;
import org.test.taskautomationexample.rule.OffsetBasedDueDateProvider;
import org.test.taskautomationexample.rule.RandomExecutor;
import org.test.taskautomationexample.rule.TaskAutomationRule;

import java.util.Map;


@Component
@RequiredArgsConstructor
public class AppointmentRuleFactory implements RuleFactory<AppointmentEvent> {

    private final RandomExecutor<AppointmentEvent> executor;

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
