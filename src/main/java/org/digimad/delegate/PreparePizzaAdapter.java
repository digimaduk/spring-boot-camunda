package org.digimad.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PreparePizzaAdapter implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        log.info("Inside PreparePizzaAdapter");
    }
}
