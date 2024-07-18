package org.test.taskautomationexample.rule;

import org.springframework.stereotype.Component;
import org.test.taskautomationexample.event.Event;

import java.util.List;
import java.util.Random;

@Component
public class RandomExecutor<E extends Event> implements Executor<E> {

    private final List<String> executors = List.of("Executor 1", "Executor 2", "Executor 3");
    private final Random random = new Random();

    @Override
    public String process(E event) {
        return executors.get(
                random.nextInt(executors.size()));
    }

}
