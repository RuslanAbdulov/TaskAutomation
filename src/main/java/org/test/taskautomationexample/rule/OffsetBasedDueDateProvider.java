package org.test.taskautomationexample.rule;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.test.taskautomationexample.model.Event;

import java.time.Duration;
import java.time.Instant;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;


@Component
@Scope(SCOPE_PROTOTYPE)
public class OffsetBasedDueDate implements DueDate<Event> {

    private final Duration offset;

    public OffsetBasedDueDate(String offset) {
        this.offset = (offset != null) ? Duration.parse(offset) : Duration.ofSeconds(0);
    }

    @Override
    public Instant process(Event event) {
        return event.getTimestamp().plus(offset);
    }

}
