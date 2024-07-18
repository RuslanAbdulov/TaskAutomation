package org.test.taskautomationexample.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.test.taskautomationexample.model.AppointmentEvent;
import org.test.taskautomationexample.model.OrderEvent;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RuleFactoryClientIntegrationTest {

    @Autowired
    private RuleFactoryClient ruleFactoryClient;

    @Test
    void testOrderTask() {
        final var instant = Instant.now();
        var orderEvent = OrderEvent.builder()
                .order("ABC12")
                .assistant("User1")
                .timestamp(instant)
                .build();

        var task = ruleFactoryClient.createTask(orderEvent);
        assertThat(task).isNotNull();
        assertThat(task.getExecutor()).isEqualTo(orderEvent.getAssistant());
        assertThat(task.getDueDate()).isEqualTo(instant.plus(1, ChronoUnit.DAYS));
        assertThat(task.getDescription()).isEqualTo("Check fulfillment of order ABC12.");
    }

    @Test
    void testAppointmentTask() {
        final var instant = Instant.now().plus(2, ChronoUnit.DAYS);
        var appointmentEvent = AppointmentEvent.builder()
                .room("Appointment room #4")
                .timestamp(instant)
                .build();

        var task = ruleFactoryClient.createTask(appointmentEvent);
        assertThat(task).isNotNull();
        assertThat(task.getExecutor()).startsWith("Random Executor");
        assertThat(task.getDueDate()).isEqualTo(instant.minus(30, ChronoUnit.MINUTES));
        assertThat(task.getDescription()).isEqualTo("Prepare room Appointment room #4.");
    }

}