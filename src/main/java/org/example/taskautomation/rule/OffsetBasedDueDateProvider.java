package org.example.taskautomation.rule;

import org.example.taskautomation.model.Event;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;


@Component
@Scope(SCOPE_PROTOTYPE)
public class OffsetBasedDueDateProvider implements DueDateProvider<Event> {

    private final Duration offset;

    public OffsetBasedDueDateProvider(String offset) {
        this.offset = (offset != null) ? Duration.parse(offset) : Duration.ofSeconds(0);
    }

    @Override
    public Instant process(Event event) {
        return event.getTimestamp().plus(offset);
    }

}
