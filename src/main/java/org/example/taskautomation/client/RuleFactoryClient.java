package org.example.taskautomation.client;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.taskautomation.factory.AppointmentRuleFactory;
import org.example.taskautomation.factory.OrderRuleFactory;
import org.example.taskautomation.model.Event;
import org.example.taskautomation.model.OrderEvent;
import org.example.taskautomation.model.Task;
import org.example.taskautomation.rule.TaskAutomationRule;
import org.springframework.stereotype.Component;
import org.example.taskautomation.model.AppointmentEvent;

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
