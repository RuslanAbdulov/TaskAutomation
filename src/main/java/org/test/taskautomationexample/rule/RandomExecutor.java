package org.test.taskautomationexample.rule;

import org.springframework.stereotype.Component;
import org.test.taskautomationexample.model.Event;

import java.util.List;
import java.util.Random;

@Component
public class RandomExecutor<E extends Event> implements ExecutorProvider<E> {

    private final List<String> executors = List.of("Random Executor 1", "Random Executor 2", "Random Executor 3");
    private final Random random = new Random();

    @Override
    public String process(E event) {
        return executors.get(
                random.nextInt(executors.size()));
    }

}
