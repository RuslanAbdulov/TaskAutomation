package org.example.taskautomation.rule;

import org.example.taskautomation.model.Event;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RandomExecutorProvider<E extends Event> implements ExecutorProvider<E> {

    private final List<String> executors = List.of("Random Executor 1", "Random Executor 2", "Random Executor 3");
    private final Random random = new Random();

    @Override
    public String process(E event) {
        return executors.get(
                random.nextInt(executors.size()));
    }

}
