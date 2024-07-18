package org.test.taskautomationexample.client;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.test.taskautomationexample.factory.AppointmentRuleFactory;
import org.test.taskautomationexample.factory.OrderRuleFactory;
import org.test.taskautomationexample.model.AppointmentEvent;
import org.test.taskautomationexample.model.Event;
import org.test.taskautomationexample.model.OrderEvent;
import org.test.taskautomationexample.model.Task;
import org.test.taskautomationexample.rule.TaskAutomationRule;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class RuleFactoryClient {

    private final OrderRuleFactory orderRuleFactory;
    private final AppointmentRuleFactory appointmentRuleFactory;

    private TaskAutomationRule<OrderEvent> checkOrderNextDay;
    private TaskAutomationRule<AppointmentEvent> prepareRoomBeforeAppointment;

    @PostConstruct
    public void init() {
        //check fulfillment on the next day
        checkOrderNextDay = orderRuleFactory.createRule(Map.of("dueDateOffset", "P1D"));
        //prepare room 30 minutes before appointment
        prepareRoomBeforeAppointment = appointmentRuleFactory.createRule(Map.of("dueDateOffset", "PT-30M"));
    }

    public Task createTask(Event event) {
        return switch (event) {
            case OrderEvent order -> checkOrderNextDay.process(order);
            case AppointmentEvent appointment -> prepareRoomBeforeAppointment.process(appointment);
            default -> throw new IllegalArgumentException("Unexpected value: " + event);
        };
    }

}
